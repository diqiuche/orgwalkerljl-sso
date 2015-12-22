package org.walkerljl.sso.web;

import javax.annotation.Resource;

import org.walkerljl.smart.mvc.init.DefaultStartUp;
import org.walkerljl.sso.service.UserService;

/**
 * CustomizedStartUp 
 *
 * @author lijunlin
 */
public class CustomizedStartUp extends DefaultStartUp {

	@Resource private UserService userService;
	
	@Override
	public void subProcess() {
		userService.selectByKey(1L);
	}
}
