/**
 * 
 */
package com.ms.bean;

import java.io.Serializable;
import java.util.List;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.ms.enums.House;
import com.ms.enums.Section;

/**
 * @author Amit.Agnihotri
 *
 */
public class AdmissionFormBean extends RegistrationFormBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer studentId;
	private String applicationDate;
	private String timeOfResiding;
	private List<Section> sectionList;
	private List<House> houseList;
	private CommonsMultipartFile studentPhoto;
	private CommonsMultipartFile studentTc;
	
	private String studentPhotoPath;
	private String  studentTcPath;
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
	/**
	 * @return the studentPhoto
	 */
	public CommonsMultipartFile getStudentPhoto() {
		return studentPhoto;
	}
	/**
	 * @param studentPhoto the studentPhoto to set
	 */
	public void setStudentPhoto(CommonsMultipartFile studentPhoto) {
		this.studentPhoto = studentPhoto;
	}
	/**
	 * @return the studentTc
	 */
	public CommonsMultipartFile getStudentTc() {
		return studentTc;
	}
	/**
	 * @param studentTc the studentTc to set
	 */
	public void setStudentTc(CommonsMultipartFile studentTc) {
		this.studentTc = studentTc;
	}
	/**
	 * @return the studentId
	 */
	public Integer getStudentId() {
		return studentId;
	}
	/**
	 * @param studentId the studentId to set
	 */
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	/**
	 * @return the studentPhotoPath
	 */
	public String getStudentPhotoPath() {
		return studentPhotoPath;
	}
	/**
	 * @param studentPhotoPath the studentPhotoPath to set
	 */
	public void setStudentPhotoPath(String studentPhotoPath) {
		this.studentPhotoPath = studentPhotoPath;
	}
	/**
	 * @return the studentTcPath
	 */
	public String getStudentTcPath() {
		return studentTcPath;
	}
	/**
	 * @param studentTcPath the studentTcPath to set
	 */
	public void setStudentTcPath(String studentTcPath) {
		this.studentTcPath = studentTcPath;
	}
	
	

}
