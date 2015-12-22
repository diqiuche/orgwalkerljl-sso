package org.walkerljl.sso.remoting;

import org.walkerljl.commons.ClassScannerUtils;
import org.walkerljl.commons.collection.ListUtils;
import org.walkerljl.smart.service.ApplicationContextUtils;
import org.walkrljl.remoting.provider.hessian.server.HessianRemotingServer;

/**
 * SpringHessianRemotingServer 
 *
 * @author lijunlin
 */
public class SpringHessianRemotingServer extends HessianRemotingServer {

	private static final long serialVersionUID = 1L;

	@Override
	public Object getRemotingServiceImpl(Class<?> clazz) {
		Class<?> implClass = ListUtils.first(ClassScannerUtils.getClassListBySuper("org.walkerljl.sso.service.sdk.impl", clazz));
		return ApplicationContextUtils.getBean(implClass);
	}
}