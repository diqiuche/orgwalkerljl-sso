package org.walkerljl.sso.domain;

import java.util.Date;

import org.walkerljl.commons.domain.BaseDomain;

/**
 *
 * User
 *
 * @author lijunlin
 */
public class User extends BaseDomain {

	private static final long serialVersionUID = 1L;

	/** 登录账号*/
	private String accountNo;
	/** 登录密码*/
	private String password;
	/** 随机盐*/
	private String salt;
	/** 最新登录日期*/
	private Date lastLoginDate;
	
	public User() {}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
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
}