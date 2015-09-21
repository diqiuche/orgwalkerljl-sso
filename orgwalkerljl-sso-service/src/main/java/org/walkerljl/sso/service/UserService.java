package org.walkerljl.sso.service;

import org.walkerljl.commons.Message;
import org.walkerljl.commons.service.DefaultBaseService;
import org.walkerljl.sso.domain.User;
import org.walkerljl.sso.pojo.LoginCommand;

/**
 *
 * UserService
 *
 * @author lijunlin
 */
public interface UserService extends DefaultBaseService<User, Long> {
	
	/**
	 * 登录验证
	 * @param command
	 * @return
	 */
	Message login(LoginCommand command);
	
	/**
	 * 通过登录账号获取用户信息
	 * @param accountNo
	 * @return
	 */
	User getUserByAccountNo(String accountNo);
	
	/**
	 * 注册
	 * @param user
	 * @return
	 */
	Message register(User user);
	
	/**
	 * 确认注册
	 * @param accountNo
	 * @return
	 */
	Message confirmRegister(String accountNo);

	/**
	 * 修改密码
	 * @param user
	 * @return
	 */
	Message updatePassword(User user);
	
	/**
	 * 重置密码
	 * @param user
	 * @return
	 */
	Message resetPassword(User user);
	
	/**
	 * 登录账号是否存在
	 * @param accountNo
	 * @return
	 */
	boolean accountNoIsExists(String accountNo);
	
	/**
	 * 登录名是否存在
	 * @param accountName
	 * @return
	 */
	boolean accountNameIsExists(String accountName);
	
	/**
	 * 邮箱是否存在
	 * @param email
	 * @return
	 */
	boolean emailIsExists(String email);
	
	/**
	 * 手机是否存在
	 * @param mobile
	 * @return
	 */
	boolean mobileIsExists(String mobile);
}