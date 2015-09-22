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
import org.walkerljl.sso.domain.LoginInfo;
import org.walkerljl.sso.service.LoginInfoService;

/**
 * LoginInfoController 
 *
 * @author lijunlin<walkerljl@qq.com>
 */
@Controller @Authentication(type = AuthType.CODE, code = "sso-logininfo")
@RequestMapping(value = "/loginInfo", method = {RequestMethod.POST, RequestMethod.GET})
public class LoginInfoController extends CurdTemplate<LoginInfo> {

	@Resource private LoginInfoService loginInfoService;
	
	public LoginInfoController() {
		super();
		setObjectIdentifer("loginInfo");
	}
	
	@Override
	public DefaultBaseService<LoginInfo, Long> getService() {
		return loginInfoService;
	}
}