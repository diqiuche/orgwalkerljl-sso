/*
 * Copyright (c) 2010-2015 www.walkerljl.org All Rights Reserved.
 * The software source code all copyright belongs to the author, 
 * without permission shall not be any reproduction and transmission.
 */
package org.walkerljl.sso.sdk.enums;

/**
 * 性别
 *
 * @author lijunlin
 */
public enum Sex {

	/**
	 * 男
	 */
	MALE(1, "男"),
	
	/**
	 * 女
	 */
	FEMALE(2, "女");
	
	/** 类型值*/
	private Integer value;
	/** 类型名称*/
	private String name;
	
	/**
	 * 构造函数
	 * @param value
	 * @param name
	 */
	private Sex(Integer value, String name) {
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
	public static Sex getType(Integer value) {
		if (value == null) {
			return null;
		}
		for (Sex type : Sex.values()) {
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