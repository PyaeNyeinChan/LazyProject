package com.lazyproject.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.annotation.PostConstruct;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.lazyproject.entity.student;
import com.lazyproject.repo.studentRepository;

@Named
@ViewScoped
public class studentAddBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private student Students;
	
	@Inject
	private studentRepository repo;
	
	@PostConstruct
	private void init() {
		Students = new student();
		
		ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
		String str = context.getRequestParameterMap().get("id");
		
		if(null != str) {
			Students = repo.findByID(Integer.parseInt(str));
		}
	}
	
	public String save() {
		Students.setFirstSection(LocalDateTime.now());
		Students.setSecondSection(LocalDateTime.now());
		if(Students.getId() > 0) {
			repo.update(Students);
		} else {
			repo.add(Students);
		}
		return "/index?faces-redirect=true";
	}

	public student getStudents() {
		return Students;
	}

	public void setStudents(student students) {
		Students = students;
	}
	

}
