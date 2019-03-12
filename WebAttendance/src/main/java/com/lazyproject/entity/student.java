package com.lazyproject.entity;

import java.time.LocalDateTime;
import java.util.Date;

public class student {
	private int id;
	private String name;
	private LocalDateTime firstSection;
	private LocalDateTime secondSection;

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

	public LocalDateTime getFirstSection() {
		return firstSection;
	}

	public void setFirstSection(LocalDateTime firstSection) {
		this.firstSection = firstSection;
	}

	public LocalDateTime getSecondSection() {
		return secondSection;
	}

	public void setSecondSection(LocalDateTime secondSection) {
		this.secondSection = secondSection;
	}


}
