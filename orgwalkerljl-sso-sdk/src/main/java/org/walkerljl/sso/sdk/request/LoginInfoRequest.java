/*
 * Copyright (c) 2010-2015 www.walkerljl.org All Rights Reserved.
 * The software source code all copyright belongs to the author, 
 * without permission shall not be any reproduction and transmission.
 */
package org.walkerljl.sso.sdk.request;

import java.util.Date;

import org.walkerljl.remoting.sdk.request.RemotingRequest;
import org.walkerljl.sso.sdk.dto.AgentType;

/**
 * LoginInfoRequest 
 *
 * @author lijunlin<walkerljl@qq.com>
 */
public class LoginInfoRequest extends RemotingRequest {

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
	
	public LoginInfoRequest() {}
	
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

	/**
	 * 获取登录用户Id
	 * @return
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * 设置登录用户Id
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * 获取登录用户姓名
	 * @return
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * 设置登录用户姓名
	 * @param userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * 获取登录IP
	 * @return
	 */
	public String getLoginIp() {
		return loginIp;
	}

	/**
	 * 设置登录IP
	 * @param loginIp
	 */
	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}

	/**
	 * 获取登录日期
	 * @return
	 */
	public Date getLoginDate() {
		return loginDate;
	}

	/**
	 * 设置登录日期
	 * @param loginDate
	 */
	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}

	/**
	 * 获取注销日期
	 * @return
	 */
	public Date getLogoutDate() {
		return logoutDate;
	}

	/**
	 * 设置注销日期
	 * @param logoutDate
	 */
	public void setLogoutDate(Date logoutDate) {
		this.logoutDate = logoutDate;
	}

	/**
	 * 获取登录终端
	 * @return
	 */
	public Integer getLoginAgent() {
		return loginAgent;
	}

	/**
	 * 设置登录终端
	 * @param loginAgent
	 */
	public void setLoginAgent(Integer loginAgent) {
		this.loginAgent = loginAgent;
	}
}