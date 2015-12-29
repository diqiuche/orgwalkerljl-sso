package org.walkerljl.sso.domain;

import java.util.Date;

import org.walkerljl.db.api.annotation.Column;
import org.walkerljl.db.api.annotation.Entity;
import org.walkerljl.smart.domain.Page;
import org.walkerljl.sso.enums.AgentType;

/**
 * 登录信息
 * 
 * @author lijunlin
 */
@Entity("sso_login_info")
public class LoginInfo extends Page<Object> {
	
	private static final long serialVersionUID = 1L;

	/** 编号*/
	@Column(key = true, value = "id")
	private Long id;
	/** 账号Id*/ @Column("user_id")
	private String userId;
	/** 账号名称*/ @Column("user_name")
	private String userName;
	/** 登录IP*/ @Column("login_ip")
	private String loginIp;
	/** 登录时间*/ @Column("login_time")
	private Date loginTime;
	/** 注销时间*/ @Column("logout_time")
	private Date logoutTime;
	/** 登录终端*/ @Column("login_agent")
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
	
	//getters and setters
	 /**
     * 获取编号
     * @return
     */
	public Long getId() {
		return id;
	}

    /**
     * 设置编号
     * @param id
     */
	public void setId(Long id) {
		this.id = id;
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
	 * 获取登录时间
	 * @return
	 */
	public Date getLoginTime() {
		return loginTime;
	}

	/**
	 * 设置登录时间
	 * @param loginTime
	 */
	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	/**
	 * 获取注销时间
	 * @return
	 */
	public Date getLogoutTime() {
		return logoutTime;
	}

	/**
	 * 设置注销时间
	 * @param logoutTime
	 */
	public void setLogoutTime(Date logoutTime) {
		this.logoutTime = logoutTime;
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
	
	@Override
	public String toString() {
		return String.format("userId=%s, userName=%s, loginIp=%s, loginTime=%s, logoutTime=%s, loginAgent=%s", 
				new Object[]{userId, userName, loginIp, loginTime, logoutTime, loginAgent});
	}
}