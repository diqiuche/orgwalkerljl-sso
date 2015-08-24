package org.walkerljl.sso.enumerate;
/**
 *
 * LoginResult
 *
 * @author lijunlin
 */
public enum LoginResult {

	/**
	 * 登录成功
	 */
	SUCCESS("200", "登录成功"),
	
	/**
	 * 登录失败
	 */
	FAILURE("201", "登录失败");
	
	private String code;
	private String message;
	
	private LoginResult(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}
}