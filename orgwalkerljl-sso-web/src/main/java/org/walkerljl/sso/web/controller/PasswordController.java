package org.walkerljl.sso.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.walkerljl.commons.auth.AuthType;
import org.walkerljl.commons.auth.Authentication;
import org.walkerljl.smart.mvc.BaseController;

/**
 * PasswordController 
 *
 * @author lijunlin
 */
@Controller @Authentication(type = AuthType.CODE)
@RequestMapping(value = "/password", method = {RequestMethod.POST, RequestMethod.GET})
public class PasswordController extends BaseController {

	public PasswordController() {
		super();
		setObjectIdentifer("password");
	}
	
	@RequestMapping(value = "/update") 
	public ModelAndView updatePassword() {
		return toViewResult(getTemplate("update"));
	}
	
	@RequestMapping(value = "/reset") 
	public ModelAndView reset() {
		return toViewResult(getTemplate("reset"));
	}
}