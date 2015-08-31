/*
 * Copyright (c) 2010-2015 www.walkerljl.org All Rights Reserved.
 * The software source code all copyright belongs to the author, 
 * without permission shall not be any reproduction and transmission.
 */
package org.walkerljl.sso.service.impl;

import org.walkerljl.commons.mail.core.Email;
import org.walkerljl.sso.service.MessageService;

/**
 * MessageServiceImpl 
 *
 * @author lijunlin<walkerljl@qq.com>
 */
public class MessageServiceImpl implements MessageService {

	private String mailServerAddress;
	private int mailServerPort;
	private String mailServerUserName;
	private String mailServerPassword;
	
	@Override
	public boolean sendHtmlEmail(Email email) {
		// TODO Auto-generated method stub
		return false;
	}
}
