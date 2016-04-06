package org.walkerljl.sso.web.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.walkerljl.identity.sdk.auth.AuthType;
import org.walkerljl.identity.sdk.auth.Authentication;
import org.walkerljl.smart.mvc.ObjectIdentifier;
import org.walkerljl.smart.mvc.template.CurdTemplate;
import org.walkerljl.smart.service.BaseService;
import org.walkerljl.sso.domain.LoginInfo;
import org.walkerljl.sso.service.LoginInfoService;

/**
 * LoginInfoController 
 *
 * @author lijunlin
 */
@Controller @Authentication(type = AuthType.CODE, code = "logininfo")
@RequestMapping(value = "/logininfo", method = {RequestMethod.POST, RequestMethod.GET})
public class LoginInfoController extends CurdTemplate<LoginInfo> {

	@Resource private LoginInfoService loginInfoService;
	
	public LoginInfoController() {
		setObjectIdentifier(new ObjectIdentifier("登录信息", "logininfo"));
	}
	
	@Override
	public BaseService<Long, LoginInfo> getService() {
		return loginInfoService;
	}
}