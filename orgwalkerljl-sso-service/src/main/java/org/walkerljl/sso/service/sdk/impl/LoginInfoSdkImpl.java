package org.walkerljl.sso.service.sdk.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.walkerljl.commons.collection.ListUtils;
import org.walkerljl.log.Logger;
import org.walkerljl.log.LoggerFactory;
import org.walkerljl.remoting.api.response.RemotingResponse;
import org.walkerljl.sso.dao.LoginInfoDao;
import org.walkerljl.sso.domain.LoginInfo;
import org.walkerljl.sso.sdk.LoginInfoSdk;
import org.walkerljl.sso.sdk.dto.LoginInfoDto;
import org.walkerljl.sso.sdk.request.LoginInfoRequest;

/**
 * LoginInfoSdkImpl 
 *
 * @author lijunlin
 */
@Service
public class LoginInfoSdkImpl implements LoginInfoSdk {

	private static final Logger LOG = LoggerFactory.getLogger(LoginInfoSdkImpl.class);
	
	@Resource private LoginInfoDao loginInfoDao;
	
	@Override
	public RemotingResponse<List<LoginInfoDto>> getLoginInfos(LoginInfoRequest request) {
		RemotingResponse<List<LoginInfoDto>> response = new RemotingResponse<List<LoginInfoDto>>();
		try {
			LoginInfo queryObject = convertRequest(request);
			if (request.getPageNo() <= 1) {
				response.setTotalCount(loginInfoDao.selectListCount(queryObject));
			}
			List<LoginInfoDto> loginInfoDtos = convertResponse(loginInfoDao.selectList(queryObject, 1, 200));
			response.setResponseBody(loginInfoDtos);
			response.setResponseBodyItemCount(loginInfoDtos.size());
			response.setCode(RemotingResponse.CODE_OK);
			response.setMessage("获取登录信息成功");
		} catch(Exception e) {
			response.setCode(RemotingResponse.CODE_ERROR);
			String msg = "获取登录信息失败:" + e.getMessage();
			response.setMessage(msg);
			LOG.error(msg, e);
		}
		return response;
	}
	
	private List<LoginInfoDto> convertResponse(List<LoginInfo> loginInfos) {
		List<LoginInfoDto> loginInfoDtos = ListUtils.newArrayList();
		if (ListUtils.isNotEmpty(loginInfos)) {
			for (LoginInfo loginInfo : loginInfos) {
				LoginInfoDto loginInfoDto = new LoginInfoDto();
				loginInfoDtos.add(loginInfoDto);
				
				loginInfoDto.setUserId(loginInfo.getUserId());
				loginInfoDto.setUserName(loginInfo.getUserName());
				loginInfoDto.setLoginIp(loginInfo.getLoginIp());
				loginInfoDto.setLoginDate(loginInfo.getLoginDate());
				loginInfoDto.setLogoutDate(loginInfo.getLogoutDate());
				loginInfoDto.setLoginAgent(loginInfo.getLoginAgent());
			}
		}
		return loginInfoDtos;
	}
	
	private LoginInfo convertRequest(LoginInfoRequest request) {
		if (request == null) {
			return null;
		}
		LoginInfo loginInfo = new LoginInfo();
		loginInfo.setUserId(request.getUserId());
		loginInfo.setUserName(request.getUserName());
		loginInfo.setLoginDate(request.getLoginDate());
		loginInfo.setLogoutDate(request.getLogoutDate());
		loginInfo.setLoginIp(request.getLoginIp());
		loginInfo.setLoginAgent(request.getLoginAgent());
		loginInfo.setPageSize(request.getPageSize());
		loginInfo.setCurrentPage(request.getPageNo());
		return loginInfo;
	}
}