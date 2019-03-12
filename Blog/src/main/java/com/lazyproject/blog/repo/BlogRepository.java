package com.lazyproject.blog.repo;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;

import com.lazyproject.blog.entity.Blog;

@ApplicationScoped
public class BlogRepository implements Serializable{

	private static final long serialVersionUID = 1L;

	private List<Blog> blogs;
	
	@PostConstruct
	private void init() {
		blogs = new ArrayList<>();
	}
	
	public void add(Blog blog) {
		blog.setPostTime(LocalDateTime.now());
		
		if(blogs.isEmpty()) {
			blog.setId(1);
		} else {
			blog.setId(blogs.get(blogs.size() - 1).getId() + 1);
		}

		blogs.add(blog);
	}
	
	public void update(Blog blog) {
		
	}
	
	public Blog findById(int id) {
		return blogs.stream()
				.filter(blog -> blog.getId() == id)
				.findFirst().orElse(null);
	}
	
	public void delete(int id) {
		Blog blog = findById(id);
		blogs.remove(blog);
	}
	
	public List<Blog> search(String title, String user) {
		List<Blog> list = new ArrayList<>();
		
		for(Blog b : blogs) {
			
			if(isNotEmpty(title) && isNotEmpty(user)) {
				if(startWithNoCase(b.getTitle(), title) && startWithNoCase(b.getUser(), user)) {
					list.add(b);
				}
			} else if (isNotEmpty(title)) {
				if(startWithNoCase(b.getTitle(), title)) {
					list.add(b);
				}
			} else if (isNotEmpty(user)) {
				if(startWithNoCase(b.getUser(), user)) {
					list.add(b);
				}
			} else {
				list.add(b);
			}
		}
		
		return list;
	}
	
	private boolean startWithNoCase(String origin, String content) {
		return origin.toLowerCase().startsWith(content.toLowerCase());
	}

	private boolean isNotEmpty(String str) {
		return null != str && !str.isEmpty();
	}
}