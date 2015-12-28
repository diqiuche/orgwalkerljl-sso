package org.walkerljl.sso.service.impl;

import java.util.Date;
import java.util.Random;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.walkerljl.commons.Message;
import org.walkerljl.commons.security.EncryptUtils;
import org.walkerljl.commons.util.StringUtils;
import org.walkerljl.smart.dao.BaseDao;
import org.walkerljl.smart.enums.Status;
import org.walkerljl.smart.service.impl.BaseServiceImpl;
import org.walkerljl.sso.dao.LoginInfoDao;
import org.walkerljl.sso.dao.UserDao;
import org.walkerljl.sso.domain.LoginInfo;
import org.walkerljl.sso.domain.User;
import org.walkerljl.sso.pojo.LoginCommand;
import org.walkerljl.sso.service.UserService;

/**
 *
 * UserServiceImpl
 *
 * @author lijunlin
 */
@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User, Long> implements UserService {

	@Resource private UserDao userDao;
	@Resource private LoginInfoDao loginInfoDao;
	
	@Override
	public BaseDao<User, Long> getDao() {
		return userDao;
	}
	
	@Override
	public User getUserByUserId(String userId) {
		User condition = new User();
		condition.setUserId(userId);	
		return userDao.selectOne(condition);
	}

	@Override @Transactional(rollbackFor = Exception.class)
	public Message<Object> login(LoginCommand command) {
		if (command == null) {
			LOGGER.warn("登录命令为空");
			return Message.failure();
		}
		
		if (StringUtils.isBlank(command.getUserId())) {
			LOGGER.warn("用户ID为空");
			return Message.failure();
		}
		
		if (StringUtils.isBlank(command.getPassword())) {
			LOGGER.warn("登录密码为空");
			return Message.failure();
		}
		
		User dbUser = getUserByUserId(command.getUserId());
		if (dbUser == null || !dbUser.isEnabled()) {
			LOGGER.warn(String.format("用户信息不存在,userId:%s", command.getUserId()));
			return Message.failure();
		}
		
		//随机盐+三次MD5加密
		String expectedPassword = getEncryptedPassword(command.getPassword(), dbUser.getSalt() + "");
		if (expectedPassword.equals(dbUser.getPassword())) {
			command.setUserName(dbUser.getUserName());
			//更新最新登录状态
			updateLastLoginStatus(dbUser.getId(), command);
			//记录登录信息
			addLoginInfo(command);
			return Message.success();
		}
		return Message.failure();
	}
	
	/**
	 * 获取加密的密码
	 * @param inputPassword
	 * @param salt
	 * @return
	 */
	private String getEncryptedPassword(String inputPassword, String salt) {
		return EncryptUtils.encryptByMD5(
				EncryptUtils.encryptByMD5(
				EncryptUtils.encryptByMD5(inputPassword + salt)));
	}
	
	/**
	 * 更新最新登录状态
	 * @param key
	 * @param command
	 */
	private void updateLastLoginStatus(Long key, LoginCommand command) {
		User userStatus = new User();
		userStatus.setLastLoginTime(new Date());
		userStatus.setLastLoginIp(command.getLoginIp());
		userStatus.setLastLoginAgent(command.getLoginAgent().getValue());
		userDao.updateByKey(userStatus, key);
	}
	
	/**
	 * 添加登录信息
	 * @param command
	 */
	private void addLoginInfo(LoginCommand command) {
		LoginInfo loginInfo = new LoginInfo();
		loginInfo.setUserId(command.getUserId());
		loginInfo.setUserName(command.getUserName());
		loginInfo.setLoginIp(command.getLoginIp());
		loginInfo.setLoginTime(new Date());
		loginInfo.setLogoutTime(loginInfo.getLoginTime());
		loginInfo.setLoginAgent(command.getLoginAgent().getValue());
		loginInfoDao.insert(loginInfo);
	}

	@Override
	public boolean userIdIsExists(String userId) {
		return getUserByUserId(userId) != null;
	}
	
	@Override
	public boolean userNameIsExists(String userName) {
		User condition = new User();
		condition.setUserName(userName);
		return userDao.selectOne(condition) != null;
	}

	@Override
	public boolean emailIsExists(String email) {
		User condition = new User();
		condition.setEmail(email);
		return userDao.selectOne(condition) != null;
	}

	@Override
	public boolean mobileIsExists(String mobile) {
		User condition = new User();
		condition.setMobile(mobile);
		return userDao.selectOne(condition) != null;
	}

	@Override
	public Message<Object> register(User user) {
		if (StringUtils.isEmpty(user.getUserId())) {
			return Message.failure("用户ID为空");
		} else if (StringUtils.isEmpty(user.getUserName())) {
			return Message.failure("用户名为空");
		} else if (StringUtils.isEmpty(user.getPassword())) {
			return Message.failure("登录密码为空");
		} else if (userIdIsExists(user.getUserId())) {
			return Message.failure("用户ID已存在");
		} else if (userNameIsExists(user.getUserName())) {
			return Message.failure("用户名已存在");
		} if (StringUtils.isNotEmpty(user.getEmail()) && emailIsExists(user.getEmail())) {
			return Message.failure("邮箱已被账号绑定");
		} if (StringUtils.isNotEmpty(user.getMobile()) && mobileIsExists(user.getMobile())) {
			return Message.failure("手机已被账号绑定");
		}
		//生成随机盐
		int max = 99999999;
	    int min = 10000000;
	    Random random = new Random();
	    int salt = random.nextInt(max) % (max - min + 1) + min;
	    user.setSalt(salt + "");
	    
	    //设置密码
	  	String encryptedPassword = getEncryptedPassword(user.getPassword(), user.getSalt());
	  	user.setPassword(encryptedPassword);
	    
		return Message.create(userDao.insert(user) > 0);
	}
	
	@Override
	public Message<Object> confirmRegister(String userId) {
		User user = getUserByUserId(userId);
		if (user == null) {
			return Message.failure("用户不存在");
		} else if (!user.isDisabled()) {
			return Message.failure("用户已经确认，不能重新确认");
		}
		user.setStatus(Status.ENABLED.getValue());
		user.setModifiedTime(new Date());
		return Message.create(userDao.updateByKey(user, user.getId()) > 0);
	}

	@Override
	public Message<Object> updatePassword(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Message<Object> resetPassword(User user) {
		// TODO Auto-generated method stub
		return null;
	}
}