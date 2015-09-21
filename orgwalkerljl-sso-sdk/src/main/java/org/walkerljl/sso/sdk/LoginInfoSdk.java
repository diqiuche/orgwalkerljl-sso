/*
 * Copyright (c) 2010-2015 www.walkerljl.org All Rights Reserved.
 * The software source code all copyright belongs to the author, 
 * without permission shall not be any reproduction and transmission.
 */
package org.walkerljl.sso.sdk;

import org.walkerljl.remoting.sdk.annotation.RemotingService;
import org.walkerljl.remoting.sdk.response.RemotingResponse;
import org.walkerljl.sso.sdk.request.LoginInfoRequest;

/**
 * 登录信息业务接口
 *
 * @author lijunlin<walkerljl@qq.com>
 */
@RemotingService(address = "/loginInfoSdk")
public interface LoginInfoSdk {
	
	/**
	 * 获取登录信息
	 * @param request
	 * @return
	 */
	RemotingResponse getLoginInfos(LoginInfoRequest request);
}