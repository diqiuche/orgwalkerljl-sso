/*
 * Copyright (c) 2010-2015 www.walkerljl.org All Rights Reserved.
 * The software source code all copyright belongs to the author, 
 * without permission shall not be any reproduction and transmission.
 */
package org.walkerljl.sso.web.controller;

import java.io.IOException;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.walkerljl.commons.domain.ViewResult;
import org.walkerljl.commons.mvc.DefaultIndexController;
import org.walkerljl.commons.pojo.identity.LoginCommand;
import org.walkerljl.commons.util.StringUtils;
import org.walkerljl.sso.enumerate.LoginResult;
import org.walkerljl.sso.sdk.UserAuthenticationTicketFactory;
import org.walkerljl.sso.service.UserService;

/**
 * IndexController 
 *
 * @author lijunlin<walkerljl@qq.com>
 */
@Controller
@RequestMapping(value = "", method = {RequestMethod.POST, RequestMethod.GET})
public class IndexController extends DefaultIndexController {
	
	@Value(value = "${sso.auth.cookie.domain}")
	private String ssoAuthCookieDomain;
	@Value(value = "${sso.auth.cookie.name}")
	private String ssoAuthCookieName;
	@Value(value = "${sso.auth.cookie.key}")
	private String ssoAuthCookieKey;
	
	@Resource private UserService userService;
	
	@RequestMapping(value = "/signin")
	public ModelAndView signin(LoginCommand command, String operate, String returnAddress) throws IOException {
		ViewResult viewResult = new ViewResult();
		if (StringUtils.equals(operate, "signin")) {
			if (LOG.isDebugEnabled()) {
				LOG.debug("Current sign in user id: " + command.getUserId());
			}
			LoginResult loginResult = userService.verify(command);
			if (loginResult == LoginResult.SUCCESS) {
				if (LOG.isDebugEnabled()) {
					LOG.debug("sendRedirect: " + returnAddress);
				}
				new UserAuthenticationTicketFactory(ssoAuthCookieDomain, ssoAuthCookieName, ssoAuthCookieKey)
					.generateTicket(getResponse(), command.getUserId(), command.getUserId());
				if (StringUtils.isBlank(returnAddress)) {
					returnAddress = getRequest().getContextPath();
				}
				getResponse().sendRedirect(returnAddress);
			} else {
				viewResult.addModel("message", loginResult.getMessage());
			}
		}
		viewResult.addModel("returnAddress", returnAddress);
		return toViewResult(getTemplate("", "signin"), viewResult);
	}
}