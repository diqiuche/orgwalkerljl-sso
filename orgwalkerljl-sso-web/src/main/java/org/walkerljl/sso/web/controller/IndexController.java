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
import org.springframework.web.servlet.ModelAndView;
import org.walkerljl.commons.mvc.DefaultIndexController;
import org.walkerljl.commons.pojo.identity.LoginCommand;
import org.walkerljl.sso.service.UserService;

/**
 * IndexController 
 *
 * @author lijunlin<walkerljl@qq.com>
 */
@Controller
@RequestMapping(value = "", method = {RequestMethod.POST, RequestMethod.GET})
public class IndexController extends DefaultIndexController {
	
	@Resource private UserService userService;
	
	@RequestMapping(value = "/verify")
	public ModelAndView verify(LoginCommand command) {
		return toViewResult(getTemplate("/index", "index"));
	}
}
