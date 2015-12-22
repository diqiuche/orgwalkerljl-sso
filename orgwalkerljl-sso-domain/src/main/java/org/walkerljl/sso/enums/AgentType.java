package org.walkerljl.sso.enums;


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
			if (type != null && value != null && type.getValue().intValue() == value.intValue()) {
				return type;
			}
		}
		return null;
	}
}