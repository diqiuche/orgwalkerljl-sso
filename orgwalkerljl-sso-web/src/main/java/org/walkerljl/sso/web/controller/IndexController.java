/*
 * Copyright (c) 2010-2015 www.walkerljl.org All Rights Reserved.
 * The software source code all copyright belongs to the author, 
 * without permission shall not be any reproduction and transmission.
 */
package org.walkerljl.sso.web.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.walkerljl.commons.Message;
import org.walkerljl.commons.domain.ViewResult;
import org.walkerljl.commons.mvc.DefaultIndexController;
import org.walkerljl.commons.util.StringUtils;
import org.walkerljl.sso.domain.User;
import org.walkerljl.sso.enumerate.AgentType;
import org.walkerljl.sso.pojo.LoginCommand;
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
	
	@RequestMapping(value = "/login")
	public ModelAndView login(LoginCommand command, String operate, String returnAddress) throws IOException {
		ViewResult viewResult = new ViewResult();
		if (StringUtils.equals(operate, "signin")) {
			if (LOG.isDebugEnabled()) {
				LOG.debug("Current sign in user id: " + command.getUserId());
			}
			//填充command字段值
			command.setLoginAgent(AgentType.PC);
			command.setLoginIp(getIpAddr(getRequest()));
			Message message = userService.login(command);
			if (message.result()) {
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
				message.setBody("登录失败");
				viewResult.addModel("message", message.getBody());
			}
		}
		viewResult.addModel("returnAddress", returnAddress);
		return toViewResult(getTemplate("", "login"), viewResult);
	}
	
	@RequestMapping(value = "/logout")
	public void logout() {
		new UserAuthenticationTicketFactory(ssoAuthCookieDomain, ssoAuthCookieName, ssoAuthCookieKey).deleteTicket(getResponse());
		sendRedirect(getRequest().getContextPath());
	}
	
	@RequestMapping(value = "/register")
	public ModelAndView register(User user) {
		ViewResult viewResult = new ViewResult();
		if (user.getAccountNo() != null) {
			initBaseDomainWhenCreate(user);
			user.setCreateUserId(user.getAccountNo());
			user.setCreateUserName(user.getAccountName());
			user.setLastModifyUserId(user.getCreateUserId());
			user.setLastModifyUserName(user.getCreateUserName());
			user.setLastLoginDate(user.getCreateDate());
			user.setLastLoginIp(getIpAddr(getRequest()));
			user.setLastLoginAgent(AgentType.PC.getValue());
			if (user.isConfirmEmail()) {//验证邮箱
				//user.setStatusType(Status.DISABLED);
			}
			viewResult.addModel("message", userService.register(user));
		}
		return toViewResult(getTemplate("", "register"), viewResult);
	}
	
	/**
	 * 获取IP地址
	 * @param request
	 * @return
	 */
	private String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        } else {
        	String[] ipList = StringUtils.split(ip, ",");
            for (int index = 0; index < ipList.length; index ++) {  
                if (!("unknown".equalsIgnoreCase(ipList[index]))) {  
                    ip = ipList[index];  
                    break;  
                }  
            }  
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}