/**
 * 
 */
package com.ms.bean;

import java.util.List;

import com.ms.enums.Category;
import com.ms.enums.State;
import com.ms.enums.StudentClass;

/**
 * @author Amit.Agnihotri
 *
 */
public class RegistrationFormBean extends FormBean{
	
	
	private String formNum;
	private String dateOfIssue;
	private String regNum;
	private String lastClass;
	private String lastSchool;
	private String lastClassResult;
	private StudentDetails studentDetails;
	private ContactDetails contactDetails;
	private List<StudentClass> studentClassList;
	private List<Category> categoryList;
	private List<State> stateList;
	
	
	
	/**
	 * @return the formNum
	 */
	public String getFormNum() {
		return formNum;
	}
	/**
	 * @param formNum the formNum to set
	 */
	public void setFormNum(String formNum) {
		this.formNum = formNum;
	}
	/**
	 * @return the dateOfIssue
	 */
	public String getDateOfIssue() {
		return dateOfIssue;
	}
	/**
	 * @param dateOfIssue the dateOfIssue to set
	 */
	public void setDateOfIssue(String dateOfIssue) {
		this.dateOfIssue = dateOfIssue;
	}
	/**
	 * @return the regNum
	 */
	public String getRegNum() {
		return regNum;
	}
	/**
	 * @param regNum the regNum to set
	 */
	public void setRegNum(String regNum) {
		this.regNum = regNum;
	}
	/**
	 * @return the studentDetails
	 */
	public StudentDetails getStudentDetails() {
		return studentDetails;
	}
	/**
	 * @param studentDetails the studentDetails to set
	 */
	public void setStudentDetails(StudentDetails studentDetails) {
		this.studentDetails = studentDetails;
	}
	/**
	 * @return the contactDetails
	 */
	public ContactDetails getContactDetails() {
		return contactDetails;
	}
	/**
	 * @param contactDetails the contactDetails to set
	 */
	public void setContactDetails(ContactDetails contactDetails) {
		this.contactDetails = contactDetails;
	}
	/**
	 * @return the studentClassList
	 */
	public List<StudentClass> getStudentClassList() {
		return studentClassList;
	}
	/**
	 * @param studentClassList the studentClassList to set
	 */
	public void setStudentClassList(List<StudentClass> studentClassList) {
		this.studentClassList = studentClassList;
	}
	/**
	 * @return the categoryList
	 */
	public List<Category> getCategoryList() {
		return categoryList;
	}
	/**
	 * @param categoryList the categoryList to set
	 */
	public void setCategoryList(List<Category> categoryList) {
		this.categoryList = categoryList;
	}
	/**
	 * @return the stateList
	 */
	public List<State> getStateList() {
		return stateList;
	}
	/**
	 * @param stateList the stateList to set
	 */
	public void setStateList(List<State> stateList) {
		this.stateList = stateList;
	}
	/**
	 * @return the lastClass
	 */
	public String getLastClass() {
		return lastClass;
	}
	/**
	 * @param lastClass the lastClass to set
	 */
	public void setLastClass(String lastClass) {
		this.lastClass = lastClass;
	}
	/**
	 * @return the lastSchool
	 */
	public String getLastSchool() {
		return lastSchool;
	}
	/**
	 * @param lastSchool the lastSchool to set
	 */
	public void setLastSchool(String lastSchool) {
		this.lastSchool = lastSchool;
	}
	/**
	 * @return the lastClassResult
	 */
	public String getLastClassResult() {
		return lastClassResult;
	}
	/**
	 * @param lastClassResult the lastClassResult to set
	 */
	public void setLastClassResult(String lastClassResult) {
		this.lastClassResult = lastClassResult;
	}

}
