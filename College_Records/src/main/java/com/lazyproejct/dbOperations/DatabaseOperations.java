package com.lazyproejct.dbOperations;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.lazyproject.entity.College;
import com.lazyproject.entity.CollegeBean;

public class DatabaseOperations {

	private static EntityManager em = Persistence.createEntityManagerFactory("College_Records").createEntityManager();
	private static EntityTransaction transcation = em.getTransaction();
	
	public static List getAllSchoolDetails() {
		Query queryOne = em.createQuery("SELECT c FROM College c");
		List collegeList = queryOne.getResultList();
		if(collegeList != null && collegeList.size()>0) {
			return collegeList;
		}else {
			return null;
		}
	}
	
	public static String createNewCollege(String name,String phone,String email) {
		if(!transcation.isActive()) {
			transcation.begin();
		}
		College newCollege = new College();
		newCollege.setId(getMaxCollegeId());
		newCollege.setName(name);
		newCollege.setPhone(phone);
		newCollege.setEmail(email);
		
		em.persist(newCollege);
		transcation.commit();
		return "index?face-redirect=true";
		
	}

	private static int getMaxCollegeId() {
		int maxCollegeId = 1;
		Query queryTwo = em.createQuery("SELECT MAX(c.id)+1 FROM College c");
		if(queryTwo.getSingleResult() != null) {
			maxCollegeId = (Integer) queryTwo.getSingleResult();
		}
		return maxCollegeId;
	}
	
	private static boolean isCollegeIdHere(int collegeID) {
		boolean idRequest = false;
		Query queryThree = em.createQuery("SELECT c FROM College c WHERE c.id = :id");
		queryThree.setParameter("id", collegeID);
		College selectedID = (College) queryThree.getSingleResult();
		if(selectedID != null){
			idRequest = true;
		}
		
		return idRequest;
	}
	
	public static String updateCollegeDetails(int collegeId, String updateCollegeName) {
		if(!transcation.isActive()) {
			transcation.begin();
		}
		if(isCollegeIdHere(collegeId)) {
			Query queryFour = em.createQuery("UPDATE College c SET c.name=:name WHERE c.id=:id");
			queryFour.setParameter("id", collegeId);
			queryFour.setParameter("name", updateCollegeName);
			int updateCount = queryFour.executeUpdate();
			if(updateCount > 0) {
				System.out.println("Record id : " + collegeId + "is updated");
			}
		}
		transcation.commit();
		FacesContext.getCurrentInstance().addMessage("editCollegeFrom:collegeId", new FacesMessage("College Record "+ collegeId + "is successfully updated in db"));
		return "/collegeEdit";
	}

}
