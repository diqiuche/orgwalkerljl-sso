package org.walkerljl.sso.web.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.walkerljl.commons.auth.AuthType;
import org.walkerljl.commons.auth.Authentication;
import org.walkerljl.smart.mvc.template.CurdTemplate;
import org.walkerljl.smart.service.BaseService;
import org.walkerljl.sso.domain.LoginInfo;
import org.walkerljl.sso.service.LoginInfoService;

/**
 * LoginInfoController 
 *
 * @author lijunlin
 */
@Controller @Authentication(type = AuthType.CODE, code = "sso-logininfo")
@RequestMapping(value = "/logininfo", method = {RequestMethod.POST, RequestMethod.GET})
public class LoginInfoController extends CurdTemplate<LoginInfo> {

	@Resource private LoginInfoService loginInfoService;
	
	public LoginInfoController() {
		setObjectIdentifer("logininfo");
	}
	
	@Override
	public BaseService<LoginInfo, Long> getService() {
		return loginInfoService;
	}
}