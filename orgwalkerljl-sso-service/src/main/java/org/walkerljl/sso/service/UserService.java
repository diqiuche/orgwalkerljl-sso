package org.walkerljl.sso.service;

import org.walkerljl.commons.pojo.identity.LoginCommand;
import org.walkerljl.commons.service.DefaultBaseService;
import org.walkerljl.sso.domain.User;
import org.walkerljl.sso.enumerate.LoginResult;

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
	LoginResult verify(LoginCommand command);
}
