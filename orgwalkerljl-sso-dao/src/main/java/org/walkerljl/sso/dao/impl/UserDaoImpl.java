package org.walkerljl.sso.dao.impl;

import org.springframework.stereotype.Repository;
import org.walkerljl.smart.dao.impl.BaseDaoImpl;
import org.walkerljl.sso.dao.UserDao;
import org.walkerljl.sso.domain.User;

/**
 *
 * UserDaoImpl
 *
 * @author lijunlin
 */
@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User, Long> implements UserDao {

	public UserDaoImpl() {
		super.baseNameSpace = "org.walkerljl.sso.dao.UserDao";
	}
}