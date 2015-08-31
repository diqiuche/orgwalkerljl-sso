/*
 * Copyright (c) 2010-2015 www.walkerljl.org All Rights Reserved.
 * The software source code all copyright belongs to the author, 
 * without permission shall not be any reproduction and transmission.
 */
package org.walkerljl.sso.web;

import org.walkerljl.commons.mvc.DefaultMvcSupporter;
import org.walkerljl.commons.service.config.Configurator;
import org.walkerljl.commons.service.config.impl.AbstractConfigurator;

/**
 * CustomizedMvcSupporter 
 *
 * @author lijunlin<walkerljl@qq.com>
 */
public class CustomizedMvcSupporter extends DefaultMvcSupporter {
	
	@Override
	public Configurator getConfigurator() {
		return new AbstractConfigurator() {
			@Override
			public Object getProperty(String key) {
				// TODO Auto-generated method stub
				return null;
			}
		};
	}
}