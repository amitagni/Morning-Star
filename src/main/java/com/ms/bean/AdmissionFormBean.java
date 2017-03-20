/**
 * 
 */
package com.ms.bean;

import java.util.List;

import com.ms.enums.House;
import com.ms.enums.Section;

/**
 * @author Amit.Agnihotri
 *
 */
public class AdmissionFormBean extends RegistrationFormBean{
	private String applicationDate;
	private String timeOfResiding;
	private List<Section> sectionList;
	private List<House> houseList;
	/*private String lastClass;
	private String lastSchool;
	private String lastClassResult;
	
	private StudentDetails studentDetails;
	private ContactDetails contactDetails;
	private List<StudentClass> studentClassList;
	private List<Category> categoryList;
	private List<State> stateList;*/
	/**
	 * @return the applicationDate
	 */
	public String getApplicationDate() {
		return applicationDate;
	}
	/**
	 * @param applicationDate the applicationDate to set
	 */
	public void setApplicationDate(String applicationDate) {
		this.applicationDate = applicationDate;
	}
	/**
	 * @return the timeOfResiding
	 */
	public String getTimeOfResiding() {
		return timeOfResiding;
	}
	/**
	 * @param timeOfResiding the timeOfResiding to set
	 */
	public void setTimeOfResiding(String timeOfResiding) {
		this.timeOfResiding = timeOfResiding;
	}
	/**
	 * @return the sectionList
	 */
	public List<Section> getSectionList() {
		return sectionList;
	}
	/**
	 * @param sectionList the sectionList to set
	 */
	public void setSectionList(List<Section> sectionList) {
		this.sectionList = sectionList;
	}
	/**
	 * @return the houseList
	 */
	public List<House> getHouseList() {
		return houseList;
	}
	/**
	 * @param houseList the houseList to set
	 */
	public void setHouseList(List<House> houseList) {
		this.houseList = houseList;
	}
	
	

}
