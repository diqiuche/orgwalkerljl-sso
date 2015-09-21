package org.walkerljl.sso.dao.impl;

import org.springframework.stereotype.Repository;
import org.walkerljl.commons.dao.impl.DefaultBaseDaoImpl;
import org.walkerljl.sso.dao.UserDao;
import org.walkerljl.sso.domain.User;

/**
 *
 * UserDaoImpl
 *
 * @author lijunlin
 */
@Repository("userDao")
public class UserDaoImpl extends DefaultBaseDaoImpl<User, Long> implements UserDao {

	public UserDaoImpl() {
		super.baseNameSpace = "org.walkerljl.sso.dao.UserDao";
	}
}