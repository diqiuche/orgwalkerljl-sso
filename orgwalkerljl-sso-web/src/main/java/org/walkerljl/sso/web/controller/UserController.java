package org.walkerljl.sso.web.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.walkerljl.identity.sdk.auth.AuthType;
import org.walkerljl.identity.sdk.auth.Authentication;
import org.walkerljl.smart.mvc.template.CurdTemplate;
import org.walkerljl.smart.service.BaseService;
import org.walkerljl.sso.domain.User;
import org.walkerljl.sso.service.UserService;

/**
 * UserController 
 *
 * @author lijunlin
 */
@Controller @Authentication(type = AuthType.CODE, code="sso-user")
@RequestMapping(value = "/user", method = {RequestMethod.POST, RequestMethod.GET})
public class UserController extends CurdTemplate<User> {

	@Resource private UserService userService;
	
	public UserController() {
	}
	
	@Override
	public BaseService<Long, User> getService() {
		return userService;
	}
}