package com.lazyproject.blog.model;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.lazyproject.blog.entity.Blog;
import com.lazyproject.blog.repo.BlogRepository;

@Named
@ViewScoped
public class BlogAddBean implements Serializable{

	private static final long serialVersionUID = 1L;

	private Blog blog;

	@Inject
	private BlogRepository repo;

	@PostConstruct
	private void init() {
		blog = new Blog();
		
		ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
		String str = context.getRequestParameterMap().get("id");
		
		if(null != str) {
			blog = repo.findById(Integer.parseInt(str));
		}
	}

	public String save() {
		
		if(blog.getId() > 0) {
			repo.update(blog);
		} else {
			repo.add(blog);
		}
		return "/index?faces-redirect=true";
	}

	public Blog getBlog() {
		return blog;
	}

	public void setBlog(Blog blog) {
		this.blog = blog;
	}

}