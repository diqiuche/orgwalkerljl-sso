package org.walkerljl.sso.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.walkerljl.smart.dao.BaseDao;
import org.walkerljl.smart.service.impl.BaseServiceImpl;
import org.walkerljl.sso.dao.LoginInfoDao;
import org.walkerljl.sso.domain.LoginInfo;
import org.walkerljl.sso.service.LoginInfoService;

/**
 * LoginInfoServiceImpl 
 *
 * @author lijunlin
 */
@Service("loginInfoService")
public class LoginInfoServiceImpl extends BaseServiceImpl<LoginInfo, Long> implements LoginInfoService {

	@Resource private LoginInfoDao loginInfoDao;
	
	@Override
	public BaseDao<LoginInfo, Long> getDao() {
		return loginInfoDao;
	}
}