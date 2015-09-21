/*
 * Copyright (c) 2010-2015 www.walkerljl.org All Rights Reserved.
 * The software source code all copyright belongs to the author, 
 * without permission shall not be any reproduction and transmission.
 */
package org.walkerljl.sso.service;

import org.walkerljl.commons.mail.core.Email;

/**
 * MessageService 
 *
 * @author lijunlin<walkerljl@qq.com>
 */
public interface MessageService {
	
	/**
	 * 发送邮件
	 * @param email
	 * @return
	 */
	boolean sendHtmlEmail(Email email);
}
