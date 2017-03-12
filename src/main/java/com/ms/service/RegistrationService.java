/**
 * 
 */
package com.ms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.bean.RegistrationFormBean;
import com.ms.dao.StudentContactInfoDao;
import com.ms.dao.StudentInfoDao;
import com.ms.dao.StudentRegDao;
import com.ms.entity.StudentInfo;
import com.ms.entity.StudentReg;
import com.ms.enums.Category;
import com.ms.enums.State;
import com.ms.enums.StudentClass;

/**
 * @author Amit.Agnihotri
 *
 */
@Service
public class RegistrationService {

	@Autowired
	private StudentRegDao studentRegDao;
	
	@Autowired
	private StudentInfoDao studentInfoDao;
	
	@Autowired
	private StudentContactInfoDao studentContactInfoDao;
	
	public void populateRegistrationFormBean(RegistrationFormBean registrationFormBean) {
		
		registrationFormBean.setCategoryList(populateCategoryList());
		registrationFormBean.setStateList(populateStateList());
		registrationFormBean.setStudentClassList(populateClassList());
	}
	
	
	public void saveRegistrationFormBean(RegistrationFormBean registrationFormBean) {
		saveStudentInfoAndContact(registrationFormBean);
		registrationFormBean.setCategoryList(populateCategoryList());
		registrationFormBean.setStateList(populateStateList());
		registrationFormBean.setStudentClassList(populateClassList());
	}
	
	
	private void saveStudentInfoAndContact(RegistrationFormBean registrationFormBean) {
		StudentReg studentReg = new StudentReg();
		studentReg.setFormNumber(formNumber);
		studentReg.setRegDate(regDate);
		studentReg.setRegNumber(regNumber);
		studentReg.setLastClass(lastClass);
		studentReg.setLastSchool(lastSchool);
		studentReg.setResult(result);
		studentReg.setCreatedBy(createdBy);
		
		StudentInfo studentInfo = new StudentInfo();
		
		studentRegDao.persistOrMerge(studentReg);
	}
	
	private List<Category> populateCategoryList(){
		List<Category> categorieList = new ArrayList<>();
		return categorieList;
	}
	
	private List<State> populateStateList(){
		List<State> stateList = new ArrayList<>();
		return stateList;
	}
	
	private List<StudentClass> populateClassList(){
		List<StudentClass> classList = new ArrayList<>();
		return classList;
	}

}
