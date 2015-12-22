package org.walkerljl.sso.sdk;

import java.util.List;

import org.walkerljl.remoting.api.annotation.RemotingService;
import org.walkerljl.remoting.api.response.RemotingResponse;
import org.walkerljl.sso.sdk.dto.LoginInfoDto;
import org.walkerljl.sso.sdk.request.LoginInfoRequest;

/**
 * 登录信息业务接口
 *
 * @author lijunlin
 */
@RemotingService(address = "/loginInfoSdk")
public interface LoginInfoSdk {
	
	/**
	 * 获取登录信息
	 * @param request
	 * @return
	 */
	RemotingResponse<List<LoginInfoDto>> getLoginInfos(LoginInfoRequest request);
}