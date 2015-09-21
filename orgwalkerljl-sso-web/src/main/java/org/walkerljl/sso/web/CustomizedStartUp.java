/*
 * Copyright (c) 2010-2015 www.walkerljl.org All Rights Reserved.
 * The software source code all copyright belongs to the author, 
 * without permission shall not be any reproduction and transmission.
 */
package org.walkerljl.sso.web;

import javax.annotation.Resource;

import org.walkerljl.commons.mvc.init.DefaultStartUp;
import org.walkerljl.sso.service.UserService;

/**
 * CustomizedStartUp 
 *
 * @author lijunlin<walkerljl@qq.com>
 */
public class CustomizedStartUp extends DefaultStartUp {

	@Resource private UserService userService;
	
	@Override
	public void subProcess() {
		userService.selectByKey(1L);
	}
}
