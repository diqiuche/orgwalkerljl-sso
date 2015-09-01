/*
 * Copyright (c) 2010-2015 lijunlin All Rights Reserved.
 * The software source code all copyright belongs to the author, 
 * without permission shall not be any reproduction and transmission.
 */
package org.walkerljl.sso.domain;

import java.util.Date;

import org.walkerljl.commons.domain.BaseDomain;
import org.walkerljl.sso.enumerate.AgentType;

/**
 * 登录信息
 * 
 * @author lijunlin<walkerljl@qq.com>
 */
public class LoginInfo extends BaseDomain {
	
	private static final long serialVersionUID = 1L;

	/** 账号Id*/
	private String userId;
	/** 账号名称*/
	private String userName;
	/** 登录IP*/
	private String loginIp;
	/** 登录日期*/
	private Date loginDate;
	/** 注销日期*/
	private Date logoutDate;
	/** 登录终端*/
	private Integer loginAgent;
	
	public LoginInfo() {}
	
	//自定义方法
	/**
	 * 获取登录终端类型
	 * @return
	 */
	public AgentType getLoginAgentType() {
		return AgentType.getType(loginAgent);
	}
	
	/**
	 * 获取登录终端名称
	 * @return
	 */
	public String getLoginAgentName() {
		AgentType agentType = getLoginAgentType();
		return agentType == null ? "" : agentType.getName();
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getLoginIp() {
		return loginIp;
	}

	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}

	public Date getLoginDate() {
		return loginDate;
	}

	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}

	public Date getLogoutDate() {
		return logoutDate;
	}

	public void setLogoutDate(Date logoutDate) {
		this.logoutDate = logoutDate;
	}

	public Integer getLoginAgent() {
		return loginAgent;
	}

	public void setLoginAgent(Integer loginAgent) {
		this.loginAgent = loginAgent;
	}
}