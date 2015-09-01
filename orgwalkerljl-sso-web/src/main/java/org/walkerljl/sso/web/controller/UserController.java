/*
 * Copyright (c) 2010-2015 www.walkerljl.org All Rights Reserved.
 * The software source code all copyright belongs to the author, 
 * without permission shall not be any reproduction and transmission.
 */
package org.walkerljl.sso.web.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.walkerljl.commons.auth.AuthType;
import org.walkerljl.commons.auth.Authentication;
import org.walkerljl.commons.mvc.template.CurdTemplate;
import org.walkerljl.commons.service.DefaultBaseService;
import org.walkerljl.sso.domain.User;
import org.walkerljl.sso.service.UserService;

/**
 * UserController 
 *
 * @author lijunlin<walkerljl@qq.com>
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
	public DefaultBaseService<User, Long> getService() {
		return userService;
	}
}