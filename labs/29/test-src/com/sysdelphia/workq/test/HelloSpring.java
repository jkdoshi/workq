package com.sysdelphia.workq.test;

public class HelloSpring {
	private String name;

	private String mood;

	public HelloSpring(String name) {
		super();
		this.name = name;
	}

	public String getMood() {
		return mood;
	}

	public void setMood(String mood) {
		this.mood = mood;
	}

	public String getName() {
		return name;
	}

	public String sayHello(String arg) {
		return mood + " " + name + " says Hello " + arg;
	}
}
