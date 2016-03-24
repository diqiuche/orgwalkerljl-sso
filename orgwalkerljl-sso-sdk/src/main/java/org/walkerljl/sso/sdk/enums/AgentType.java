/*
 * Copyright (c) 2010-2015 www.walkerljl.org All Rights Reserved.
 * The software source code all copyright belongs to the author, 
 * without permission shall not be any reproduction and transmission.
 */
package org.walkerljl.sso.sdk.enums;

/**
 * 终端类型 
 *
 * @author lijunlin
 */
public enum AgentType {

	/**
	 * PC端
	 */
	PC(1, "PC"),
	
	/**
	 * App端
	 */
	APP(2, "App"),
	
	/**
	 * 手机Web端
	 */
	MOBILE(3, "Mobile");
	
	/** 类型值*/
	private Integer value;
	/** 类型名称*/
	private String name;
	
	/**
	 * 构造函数
	 * @param value
	 * @param name
	 */
	private AgentType(Integer value, String name) {
		this.value = value;
		this.name = name;
	}
	
	/**
	 * 获取类型值
	 * @return
	 */
	public Integer getValue() {
		return value;
	}
	
	/**
	 * 获取类型名称
	 * @return
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * 获取类型
	 * @param value
	 * @return
	 */
	public static AgentType getType(Integer value) {
		if (value == null) {
			return null;
		}
		for (AgentType type : AgentType.values()) {
			if (type.getValue().intValue() == value.intValue()) {
				return type;
			}
		}
		return null;
	}
	
	@Override
	public String toString() {
		return value + "";
	}
}