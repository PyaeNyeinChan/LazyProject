package com.lazyproject.model;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.lazyproject.entity.student;
import com.lazyproject.repo.studentRepository;

@Named
@RequestScoped
public class studentListBean {
	private String Name;
	private List<student> students;

	@Inject
	private studentRepository repo;

	@PostConstruct
	public void init() {
		students = repo.search(Name);
	}

	public String search() {
		students = repo.search(Name);
		return "/index";
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public List<student> getStudents() {
		return students;
	}

	public void setStudents(List<student> students) {
		this.students = students;
	}

	public studentRepository getRepo() {
		return repo;
	}

	public void setRepo(studentRepository repo) {
		this.repo = repo;
	}

}