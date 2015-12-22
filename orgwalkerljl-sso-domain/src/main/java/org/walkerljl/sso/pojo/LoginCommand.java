/*
 * Copyright (c) 2010-present lijunlin All Rights Reserved.
 * The software source code all copyright belongs to the author, 
 * without permission shall not be any reproduction and transmission.
 */
package org.walkerljl.sso.pojo;

import java.io.Serializable;

import org.walkerljl.sso.enums.AgentType;

/**
 * 登录命令
 * 
 * @author lijunlin<walkerljl@qq.com>
 */
public class LoginCommand implements Serializable {
	
	private static final long serialVersionUID = 1L;

	/** 登录账号*/
	private String userId;
	/** 登录名*/
	private String userName;
	/** 密码*/
	private String password;
	/** 验证码*/
	private String verifyCode;
	/** 登录Ip*/
	private String loginIp;
	/** 登录终端*/
	private AgentType loginAgent;
	
	public LoginCommand() {}

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getVerifyCode() {
		return verifyCode;
	}

	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}

	public String getLoginIp() {
		return loginIp;
	}

	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}

	public AgentType getLoginAgent() {
		return loginAgent;
	}

	public void setLoginAgent(AgentType loginAgent) {
		this.loginAgent = loginAgent;
	}
}