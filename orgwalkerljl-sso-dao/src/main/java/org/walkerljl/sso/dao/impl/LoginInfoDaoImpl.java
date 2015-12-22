/*
 * Copyright (c) 2010-2015 www.walkerljl.org All Rights Reserved.
 * The software source code all copyright belongs to the author, 
 * without permission shall not be any reproduction and transmission.
 */
package org.walkerljl.sso.dao.impl;

import org.springframework.stereotype.Repository;
import org.walkerljl.smart.dao.impl.BaseDaoImpl;
import org.walkerljl.sso.dao.LoginInfoDao;
import org.walkerljl.sso.domain.LoginInfo;

/**
 * LoginInfoDaoImpl 
 *
 * @author lijunlin
 */
@Repository("loginInfoDao")
public class LoginInfoDaoImpl extends BaseDaoImpl<LoginInfo, Long> implements LoginInfoDao {

	public LoginInfoDaoImpl() {
		super.baseNameSpace = "org.walkerljl.sso.dao.LoginInfoDao";
	}
}
