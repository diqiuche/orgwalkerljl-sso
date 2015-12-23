package org.walkerljl.sso.domain;

import java.util.Date;

import org.walkerljl.db.api.annotation.Column;
import org.walkerljl.db.api.annotation.Entity;
import org.walkerljl.smart.domain.BaseDomain;
import org.walkerljl.sso.enums.AgentType;

/**
 *
 * User
 *
 * @author lijunlin
 */
@Entity("sso_user")
public class User extends BaseDomain {

	private static final long serialVersionUID = 1L;

	/** 账号Id*/ @Column("user_id")
	private String userId;
	/** 账号名称*/ @Column("user_name")
	private String userName;
	/** 别名/昵称*/ @Column("alias")
	private String alias;
	/** 邮箱*/ @Column("email")
	private String email;
	/** 手机*/ @Column("mobile")
	private String mobile;
	/** 密码*/ @Column("password")
	private String password;
	/** 随机盐*/ @Column("salt")
	private String salt;
	/** 最新登录时间*/ @Column("last_login_time")
	private Date lastLoginTime;
	/** 最新登录Ip*/ @Column("last_login_ip")
	private String lastLoginIp;
	/** 最新登录终端*/ @Column("last_login_agent")
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
	
	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
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

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
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