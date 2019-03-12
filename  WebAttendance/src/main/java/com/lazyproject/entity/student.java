package com.lazyproject.entity;

import java.time.LocalDateTime;

public class student {
	private int id;
	private String name;
	private State state;
	
	public enum State{
		Avaiable , Absent
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}
	


}