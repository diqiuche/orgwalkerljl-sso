package org.walkerljl.sso.sdk;


import java.io.Serializable;
import java.util.Date;

import org.walkerljl.sso.sdk.dto.AgentType;

/**
 *
 * 用户信息
 *
 * @author lijunlin
 */
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	/** ID*/ 
	private String userId;
	/** 名称*/ 
	private String userName;
	/** 别名/昵称*/ 
	private String alias;
	/** 邮箱*/ 
	private String email;
	/** 手机*/ 
	private String mobile;
	/** 最新登录时间*/
	private Date lastLoginTime;
	/** 最新登录Ip*/
	private String lastLoginIp;
	/** 最新登录终端*/
	private Integer lastLoginAgent;
	//扩展字段
	
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

	//getters and setters
	/**
	 * 获取ID
	 * @return
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * 设置ID
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * 获取名称
	 * @return
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * 设置名称
	 * @param userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	/**
	 * 获取别名
	 * @return
	 */
	public String getAlias() {
		return alias;
	}

	/**
	 * 设置别名
	 * @param alias
	 */
	public void setAlias(String alias) {
		this.alias = alias;
	}

	/**
	 * 获取Email
	 * @return
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * 设置Email
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * 获取Mobile
	 * @return
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * 设置Mobile
	 * @param mobile
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * 获取最近登录时间
	 * @return
	 */
	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	/**
	 * 设置最近登录时间
	 * @param lastLoginTime
	 */
	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	/**
	 * 获取最近登录IP
	 * @return
	 */
	public String getLastLoginIp() {
		return lastLoginIp;
	}

	/**
	 * 设置最近登录IP
	 * @param lastLoginIp
	 */
	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}

	/**
	 * 获取上次登录终端
	 * @return
	 */
	public Integer getLastLoginAgent() {
		return lastLoginAgent;
	}

	/**
	 * 设置上次登录终端
	 * @param lastLoginAgent
	 */
	public void setLastLoginAgent(Integer lastLoginAgent) {
		this.lastLoginAgent = lastLoginAgent;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", alias=" + alias + ", email=" + email
				+ ", mobile=" + mobile + ", lastLoginTime=" + lastLoginTime + ", lastLoginIp=" + lastLoginIp
				+ ", lastLoginAgent=" + lastLoginAgent + "]";
	}
}