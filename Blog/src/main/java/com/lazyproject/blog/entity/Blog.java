package com.lazyproject.blog.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.validation.constraints.NotEmpty;

public class Blog implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	@NotEmpty(message = "Please enter Blog Title.")
	private String title;
	@NotEmpty(message = "Please enter Blog Body.")
	private String body;
	@NotEmpty(message= "Please enter Author name.")
	private String user;
	private LocalDateTime postTime;

	public LocalDateTime getPostTime() {
		return postTime;
	}

	public void setPostTime(LocalDateTime postTime) {
		this.postTime = postTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

}