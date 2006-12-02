package com.sysdelphia.workq.backing;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Backing bean that says hello to visitors.
 * 
 * @author Jitesh Doshi
 */
public class HelloAction {
	private static final Log log = LogFactory.getLog(HelloAction.class);
	private String name;
	private String capName;

	/**
	 * Capitalized name.
	 */
	public String getCapName() {
		return capName;
	}

	public void setCapName(String capName) {
		this.capName = capName;
	}

	/**
	 * Visitor's name.
	 */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void upcase() {
		log.debug("Upcasing ...");
		capName = name.toUpperCase();
	}
}
