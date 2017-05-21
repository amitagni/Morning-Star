/**
 * 
 */
package com.ms.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Amit.Agnihotri
 *
 */
@Entity
@Table(name = "student_info")
public class StudentInfo extends BaseEntity<Integer> implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "reg_id")
	private Integer regId;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	
	@Column(name = "dob")
	private String dob;
	
	
	@Column(name = "father_name")
	private String fatherName;
	
	@Column(name = "mother_name")
	private String motherName;
	
	
	@Column(name = "admission_class")
	private Byte admissionClass;
	
	@Column(name = "current_class")
	private Byte currentClass;
	
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "category")
	private Byte category;
	
	
	@Column(name = "section")
	private Byte section;
	
	@Column(name = "house")
	private Byte house;
	
	@Column(name = "photo")
	private String photo;
	
	@Column(name = "nationality")
	private String nationality;
	
	@Column(name = "religion")
	private String religion;
	
	@Column(name = "caste")
	private String caste;
	
	@Column(name = "tc_path")
	private String tcPath;
	
	@Column(name = "dob_proof_path")
	private String dobProofPath;
	
	@Column(name = "transport_taken")
	private Byte transportTaken;
	
	@Column(name = "sibling_study")
	private Byte sibling_study;
	


	@Column(name = "subjects")
	private String subjects;
	
	
	@Column(name = "father_occupation")
	private String fatherOccupation;


	@Column(name = "created_by")
	private Integer createdBy;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at")
	private Date createdAt;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the regId
	 */
	public Integer getRegId() {
		return regId;
	}

	/**
	 * @param regId the regId to set
	 */
	public void setRegId(Integer regId) {
		this.regId = regId;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the dob
	 */
	public String getDob() {
		return dob;
	}

	/**
	 * @param dob the dob to set
	 */
	public void setDob(String dob) {
		this.dob = dob;
	}

	/**
	 * @return the fatherName
	 */
	public String getFatherName() {
		return fatherName;
	}

	/**
	 * @param fatherName the fatherName to set
	 */
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	/**
	 * @return the motherName
	 */
	public String getMotherName() {
		return motherName;
	}

	/**
	 * @param motherName the motherName to set
	 */
	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	/**
	 * @return the admissionClass
	 */
	public Byte getAdmissionClass() {
		return admissionClass;
	}

	/**
	 * @param admissionClass the admissionClass to set
	 */
	public void setAdmissionClass(Byte admissionClass) {
		this.admissionClass = admissionClass;
	}

	/**
	 * @return the currentClass
	 */
	public Byte getCurrentClass() {
		return currentClass;
	}

	/**
	 * @param currentClass the currentClass to set
	 */
	public void setCurrentClass(Byte currentClass) {
		this.currentClass = currentClass;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the category
	 */
	public Byte getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(Byte category) {
		this.category = category;
	}



	/**
	 * @return the photo
	 */
	public String getPhoto() {
		return photo;
	}

	/**
	 * @param photo the photo to set
	 */
	public void setPhoto(String photo) {
		this.photo = photo;
	}

	/**
	 * @return the nationality
	 */
	public String getNationality() {
		return nationality;
	}

	/**
	 * @param nationality the nationality to set
	 */
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	/**
	 * @return the religion
	 */
	public String getReligion() {
		return religion;
	}

	/**
	 * @param religion the religion to set
	 */
	public void setReligion(String religion) {
		this.religion = religion;
	}

	/**
	 * @return the caste
	 */
	public String getCaste() {
		return caste;
	}

	/**
	 * @param caste the caste to set
	 */
	public void setCaste(String caste) {
		this.caste = caste;
	}

	/**
	 * @return the tcPath
	 */
	public String getTcPath() {
		return tcPath;
	}

	/**
	 * @param tcPath the tcPath to set
	 */
	public void setTcPath(String tcPath) {
		this.tcPath = tcPath;
	}

	/**
	 * @return the dobProofPath
	 */
	public String getDobProofPath() {
		return dobProofPath;
	}

	/**
	 * @param dobProofPath the dobProofPath to set
	 */
	public void setDobProofPath(String dobProofPath) {
		this.dobProofPath = dobProofPath;
	}

	/**
	 * @return the transportTaken
	 */
	public Byte getTransportTaken() {
		return transportTaken;
	}

	/**
	 * @param transportTaken the transportTaken to set
	 */
	public void setTransportTaken(Byte transportTaken) {
		this.transportTaken = transportTaken;
	}

	/**
	 * @return the sibling_study
	 */
	public Byte getSibling_study() {
		return sibling_study;
	}

	/**
	 * @param sibling_study the sibling_study to set
	 */
	public void setSibling_study(Byte sibling_study) {
		this.sibling_study = sibling_study;
	}

	/**
	 * @return the createdBy
	 */
	public Integer getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @return the createdAt
	 */
	public Date getCreatedAt() {
		return createdAt;
	}

	/**
	 * @param createdAt the createdAt to set
	 */
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	/**
	 * @return the section
	 */
	public Byte getSection() {
		return section;
	}

	/**
	 * @param section the section to set
	 */
	public void setSection(Byte section) {
		this.section = section;
	}

	/**
	 * @return the house
	 */
	public Byte getHouse() {
		return house;
	}

	/**
	 * @param house the house to set
	 */
	public void setHouse(Byte house) {
		this.house = house;
	}


	/**
	 * @return the subjects
	 */
	public String getSubjects() {
		return subjects;
	}

	/**
	 * @param subjects the subjects to set
	 */
	public void setSubjects(String subjects) {
		this.subjects = subjects;
	}

	/**
	 * @return the fatherOccupation
	 */
	public String getFatherOccupation() {
		return fatherOccupation;
	}

	/**
	 * @param fatherOccupation the fatherOccupation to set
	 */
	public void setFatherOccupation(String fatherOccupation) {
		this.fatherOccupation = fatherOccupation;
	}

}

