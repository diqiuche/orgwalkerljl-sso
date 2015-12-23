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

}
