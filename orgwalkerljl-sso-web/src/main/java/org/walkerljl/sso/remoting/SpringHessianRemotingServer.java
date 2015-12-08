/*
 * Copyright (c) 2010-2015 www.walkerljl.org All Rights Reserved.
 * The software source code all copyright belongs to the author, 
 * without permission shall not be any reproduction and transmission.
 */
package org.walkerljl.sso.remoting;

import org.walkerljl.commons.ClassScannerUtils;
import org.walkerljl.commons.collection.ListUtils;
import org.walkerljl.commons.service.ApplicationContextUtils;
import org.walkrljl.remoting.provider.hessian.server.HessianRemotingServer;

/**
 * SpringHessianRemotingServer 
 *
 * @author lijunlin<walkerljl@qq.com>
 */
public class SpringHessianRemotingServer extends HessianRemotingServer {

	private static final long serialVersionUID = 1L;

	@Override
	public Object getRemotingServiceImpl(Class<?> clazz) {
		Class<?> implClass = ListUtils.first(ClassScannerUtils.getClassListBySuper("org.walkerljl.sso.service.sdk.impl", clazz));
		return ApplicationContextUtils.getBean(implClass);
	}
}