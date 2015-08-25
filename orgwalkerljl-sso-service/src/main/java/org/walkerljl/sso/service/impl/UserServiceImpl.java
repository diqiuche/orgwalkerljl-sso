package org.walkerljl.sso.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.walkerljl.commons.collection.ListUtils;
import org.walkerljl.commons.dao.DefaultBaseDao;
import org.walkerljl.commons.pojo.identity.LoginCommand;
import org.walkerljl.commons.security.EncryptUtils;
import org.walkerljl.commons.service.impl.DefaultBaseServiceImpl;
import org.walkerljl.commons.util.StringUtils;
import org.walkerljl.sso.dao.UserDao;
import org.walkerljl.sso.domain.User;
import org.walkerljl.sso.enumerate.LoginResult;
import org.walkerljl.sso.service.UserService;

/**
 *
 * UserServiceImpl
 *
 * @author lijunlin
 */
@Service("userService")
public class UserServiceImpl extends DefaultBaseServiceImpl<User, Long> implements UserService {

	@Resource private UserDao userDao;
	
	@Override
	public DefaultBaseDao<User, Long> getDao() {
		return userDao;
	}

	@Override
	public LoginResult verify(LoginCommand command) {
		if (command == null) {
			LOG.warn("Command is null");
			return LoginResult.FAILURE;
		}
		
		if (StringUtils.isBlank(command.getUserId())) {
			LOG.warn("User id is null or blank");
			return LoginResult.FAILURE;
		}
		
		if (StringUtils.isBlank(command.getPassword())) {
			LOG.warn("User password is null or blank");
			return LoginResult.FAILURE;
		}
		
		User condition = new User();
		condition.setAccountNo(command.getUserId());	
		User dbUser = ListUtils.first(userDao.selectList(condition));
		if (dbUser == null) {
			LOG.warn(String.format("Invalid user information,condition:{accountNo:%s}", command.getUserId()));
			return LoginResult.FAILURE;
		}
		
		String expectedPassword = EncryptUtils.encryptByMD5(EncryptUtils.encryptByMD5(EncryptUtils.encryptByMD5(command.getPassword() + dbUser.getSalt())));
		if (expectedPassword.equals(dbUser.getPassword())) {
			return LoginResult.SUCCESS;
		}
		return LoginResult.FAILURE;
	}
	
	public static void main(String[] args) {
		System.out.println(EncryptUtils.encryptByMD5(EncryptUtils.encryptByMD5(EncryptUtils.encryptByMD5("" + "99887745"))));
	}
}