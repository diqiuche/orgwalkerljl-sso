package org.walkerljl.sso.domain;

import java.util.Date;

import org.walkerljl.commons.domain.BaseDomain;
import org.walkerljl.sso.enumeration.AgentType;

/**
 *
 * User
 *
 * @author lijunlin
 */
public class User extends BaseDomain {

	private static final long serialVersionUID = 1L;

	/** 账号Id*/
	private String accountNo;
	/** 账号名称*/
	private String accountName;
	/** 邮箱*/
	private String email;
	/** 手机*/
	private String mobile;
	/** 密码*/
	private String password;
	/** 随机盐*/
	private String salt;
	/** 最新登录日期*/
	private Date lastLoginDate;
	/** 最新登录Ip*/
	private String lastLoginIp;
	/** 最新登录终端*/
	private Integer lastLoginAgent;
	//扩展字段
	/** 旧密码*/
	private String oldPassword;
	/** 是否验证邮箱*/
	private boolean confirmEmail;
	
	public User() {}
	
	//自定义方法
	/**
	 * 获取最新登录终端类型
	 * @return
	 */
	public AgentType getLastLoginAgentType() {
		return AgentType.getType(lastLoginAgent);
	}
	
	/**
	 * 获取最新登录终端名称
	 * @return
	 */
	public String getLastLoginAgentName() {
		AgentType agentType = getLastLoginAgentType();
		return agentType == null ? "" : agentType.getName();
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
	 	return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public Date getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	public String getLastLoginIp() {
		return lastLoginIp;
	}

	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}

	public Integer getLastLoginAgent() {
		return lastLoginAgent;
	}

	public void setLastLoginAgent(Integer lastLoginAgent) {
		this.lastLoginAgent = lastLoginAgent;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public boolean isConfirmEmail() {
		return confirmEmail;
	}

	public void setConfirmEmail(boolean confirmEmail) {
		this.confirmEmail = confirmEmail;
	}
}