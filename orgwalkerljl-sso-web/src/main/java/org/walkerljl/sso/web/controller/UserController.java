package org.walkerljl.sso.web.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.walkerljl.commons.auth.AuthType;
import org.walkerljl.commons.auth.Authentication;
import org.walkerljl.smart.mvc.template.CurdTemplate;
import org.walkerljl.smart.service.BaseService;
import org.walkerljl.sso.service.UserService;
import org.walkerljl.sso.domain.User;

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
		super();
		setObjectIdentifer("user");
	}
	
	@Override
	public BaseService<User, Long> getService() {
		return userService;
	}
}