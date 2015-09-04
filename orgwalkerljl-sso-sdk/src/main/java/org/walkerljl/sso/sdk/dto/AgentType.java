/*
 * Copyright (c) 2010-2015 www.walkerljl.org All Rights Reserved.
 * The software source code all copyright belongs to the author, 
 * without permission shall not be any reproduction and transmission.
 */
package org.walkerljl.sso.sdk.dto;

/**
 * 终端类型 
 *
 * @author lijunlin<walkerljl@qq.com>
 */
public enum AgentType {

	/**
	 * PC端
	 */
	PC(1, "PC"),
	
	/**
	 * App端
	 */
	APP(2, "App");
	
	private Integer value;
	private String name;
	
	private AgentType(Integer value, String name) {
		this.value = value;
		this.name = name;
	}

	public Integer getValue() {
		return value;
	}

	public String getName() {
		return name;
	}
	
	public static AgentType getType(Integer value) {
		for (AgentType type : AgentType.values()) {
			if (value != null && value.intValue() == type.getValue()) {
				return type;
			}
		}
		return null;
	}
}