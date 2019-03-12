package com.lazyproject.repo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;

import com.lazyproject.entity.student;

@ApplicationScoped
public class studentRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<student> students;

	@PostConstruct
	private void init() {
		students = new ArrayList<>();
	}

	public void add(student std) {
		if(students.isEmpty()) {
			std.setId(1);
		} else {
			std.setId(students.get(students.size() - 1).getId() + 1);
		}
		students.add(std);
	}

	public student findByID(int id) {
		return students.stream().filter(student -> student.getId() == id).findFirst().orElse(null);
	}

	public List<student> search(String name){
		List<student> std = new ArrayList<>();
		for(student s : students) {
			if(isNotEmpty(name) && startWithNoCase(s.getName(),name)) {
				std.add(s);
			} else {
				std.add(s);
			}
		}
		return std;
	}

	public void update(student std) {

	}

	private boolean startWithNoCase(String origin, String content) {
		return origin.toLowerCase().startsWith(content.toLowerCase());
	}

	private boolean isNotEmpty(String name) {
		return null != name && !name.isEmpty();
	}

}