/*
 * Copyright (c) 2010-2015 www.walkerljl.org All Rights Reserved.
 * The software source code all copyright belongs to the author, 
 * without permission shall not be any reproduction and transmission.
 */
package org.walkerljl.sso.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.walkerljl.commons.dao.DefaultBaseDao;
import org.walkerljl.commons.service.impl.DefaultBaseServiceImpl;
import org.walkerljl.sso.dao.LoginInfoDao;
import org.walkerljl.sso.domain.LoginInfo;
import org.walkerljl.sso.service.LoginInfoService;

/**
 * LoginInfoServiceImpl 
 *
 * @author lijunlin<walkerljl@qq.com>
 */
@Service("loginInfoService")
public class LoginInfoServiceImpl extends DefaultBaseServiceImpl<LoginInfo, Long> implements LoginInfoService {

	@Resource private LoginInfoDao loginInfoDao;
	
	@Override
	public DefaultBaseDao<LoginInfo, Long> getDao() {
		return loginInfoDao;
	}
}