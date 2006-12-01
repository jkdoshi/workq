package com.sysdelphia.workq.backing;

/**
 * Backing bean that says hello to visitors.
 * 
 * @author Jitesh Doshi
 */
public class HelloAction {
	private String name;

	/**
	 * Visitor's name.
	 */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
