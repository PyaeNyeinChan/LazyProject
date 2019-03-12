package com.lazyproject.blog.model;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.lazyproject.blog.entity.Blog;
import com.lazyproject.blog.repo.BlogRepository;

@Named
@RequestScoped
public class BlogListBean {

	private String title;
	private String name;

	private List<Blog> blogs;
	
	@PostConstruct
	public void init() {
		blogs = repo.search(title, name);
	}
	
	@Inject
	private BlogRepository repo;
	
	public String search() {
		blogs = repo.search(title, name);
		return "/index";
	}
	
	public String delete(int id) {
		repo.delete(id);
		return "/index?faces-redirect=true";
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Blog> getBlogs() {
		return blogs;
	}

	public void setBlogs(List<Blog> blogs) {
		this.blogs = blogs;
	}

}