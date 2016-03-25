package org.walkerljl.sso.sdk;

import java.io.Serializable;

/**
 *
 * UserAuthenticationTicket
 *
 * @author lijunlin
 */
public class UserAuthenticationTicket implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private static final ThreadLocal<UserAuthenticationTicket> HOLDER = new ThreadLocal<UserAuthenticationTicket>();

	private String userId;
	private String userName;
	private long expires;
	private long createDate;
	
	public UserAuthenticationTicket() {}
	
	public static UserAuthenticationTicket getTicket() {
		UserAuthenticationTicket instance = HOLDER.get();
		if (instance != null && instance.isExpired()) {
			remove();
			return null;
		} else {
			return instance;
		}
	}
	
	public static void set(UserAuthenticationTicket ticket) {
		HOLDER.set(ticket);
	}
	
	public static void remove() {
		HOLDER.remove();
	}
	
	public boolean isLogin() {
		boolean isLogin = (userId != null && !userId.equals("") && !isExpired());
		if (!isLogin) {
			UserAuthenticationTicket.remove();
		}
		return isLogin;
	}
	
	public boolean isExpired() {
		return System.currentTimeMillis() >= expires;
	}
	
	public static UserAuthenticationTicket parse(String valueString) {
		if (valueString == null || valueString.equals("")) {
			return null;
		}
		String[] values = valueString.split(",");
		if (values == null || values.length == 0) {
			return null;
		}
		UserAuthenticationTicket ticket = new UserAuthenticationTicket();
		for (String value : values) {
			String[] entry = value.split("=");
			if (entry == null || entry.length != 2) {
				continue;
			}
			String entryKey = entry[0];
			String entryValue = entry[1];
			if ("userId".equals(entryKey)) {
				ticket.setUserId(entryValue);
			} else if ("userName".equals(entryKey)) {
				ticket.setUserName(entryValue);
			} else if ("createDate".equals(entryKey)) {
				ticket.setCreateDate(Long.parseLong(entryValue));
			} else if ("expires".equals(entryKey)) {
				ticket.setExpires(Long.parseLong(entryValue));
			}
		}
		return ticket;
	}
	
	public String toValueString() {
		StringBuilder builder = new StringBuilder();
		builder.append("userId=").append(getUserId()).append(",");
		builder.append("userName=").append(getUserName()).append(",");
		builder.append("expires=").append(getExpires()).append(",");
		builder.append("createDate=").append(getCreateDate());
		return builder.toString();
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public long getExpires() {
		return expires;
	}

	public void setExpires(long expires) {
		this.expires = expires;
	}

	public long getCreateDate() {
		return createDate;
	}

	public void setCreateDate(long createDate) {
		this.createDate = createDate;
	}
}