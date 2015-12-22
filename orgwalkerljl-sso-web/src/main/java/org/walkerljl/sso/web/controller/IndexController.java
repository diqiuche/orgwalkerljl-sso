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
import org.walkerljl.commons.util.StringUtils;
import org.walkerljl.smart.domain.ViewResult;
import org.walkerljl.smart.mvc.DefaultIndexController;
import org.walkerljl.sso.domain.User;
import org.walkerljl.sso.enums.AgentType;
import org.walkerljl.sso.pojo.LoginCommand;
import org.walkerljl.sso.sdk.UserAuthenticationTicketFactory;
import org.walkerljl.sso.service.UserService;

/**
 * IndexController 
 *
 * @author lijunlin
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
	
	/**
	 * 覆盖父类的login方法和URL
	 */
	@RequestMapping(value = "/unvalid")
	public void login() {}
	
	/**
	 * 登录
	 * @param command
	 * @param operate
	 * @param returnAddress
	 * @return
	 * @throws IOException
	 */
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
	
	/**
	 * 注销
	 */
	@RequestMapping(value = "/logout")
	public void logout() {
		new UserAuthenticationTicketFactory(ssoAuthCookieDomain, ssoAuthCookieName, ssoAuthCookieKey).deleteTicket(getResponse());
		sendRedirect(getRequest().getContextPath());
	}
	
	/**
	 * 注册
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/register")
	public ModelAndView register(User user) {
		ViewResult viewResult = new ViewResult();
		if (user.getAccountNo() != null) {
			initBaseDomainWhenCreate(user);
			user.setCreator(user.getAccountNo());
			user.setModifier(user.getCreator());
			user.setLastLoginDate(user.getCreatedTime());
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