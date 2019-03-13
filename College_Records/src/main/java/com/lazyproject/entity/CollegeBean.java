package com.lazyproject.entity;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.lazyproejct.dbOperations.DatabaseOperations;

@Named
@RequestScoped
public class CollegeBean {
	private int id;
	private String name;
	private String phone;
	private String email;
	private String editCollegeID;
	
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEditCollegeID() {
		return editCollegeID;
	}
	public void setEditCollegeID(String editCollegeID) {
		this.editCollegeID = editCollegeID;
	}
	
	public List collegeListFromDB() {
		return DatabaseOperations.getAllSchoolDetails();
	}
	public String addNewCollege(CollegeBean collegeBean) {
		return DatabaseOperations.createNewCollege(collegeBean.getName(),collegeBean.getPhone(), collegeBean.getEmail());
	}
	public String editCollegeDetail() {
		editCollegeID = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("selectedCollegeId");
		return "/college_edit";
	}
	public String updateSchoolDetails(CollegeBean collegeBean) {
		return DatabaseOperations.updateCollegeDetails(Integer.parseInt(collegeBean.getEditCollegeID()), collegeBean.getName());
	}
	
}
