package com.ms.bean;

import java.util.List;

import com.ms.enums.State;
import com.ms.enums.StudentClass;

public class AbacusRegBean extends FormBean{

	
	private int id;
	private String formNum;
	private String firstName;
	private String lastName;
	private String nickName;
	private String dateOfBirth;
	private String fatherName;
	private String motherName;
	private String schoolname;
	private String gender;
	private String feeAmount;
	private Byte[] selMonth;
	private String address1;
	private String address2;
	private String area;
	private String city;
	private String state;
	private String pincode;
	private String phone;
	private String mobile;
	private String email;
	private List<State> stateList;
	private String schoolclass;
	private List<StudentClass> studentClassList;
	
	
	
	
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
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
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
	 * @return the nickName
	 */
	public String getNickName() {
		return nickName;
	}
	/**
	 * @param nickName the nickName to set
	 */
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	/**
	 * @return the dateOfBirth
	 */
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	/**
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
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
	 * @return the schoolname
	 */
	public String getSchoolname() {
		return schoolname;
	}
	/**
	 * @param schoolname the schoolname to set
	 */
	public void setSchoolname(String schoolname) {
		this.schoolname = schoolname;
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
	 * @return the feeAmount
	 */
	public String getFeeAmount() {
		return feeAmount;
	}
	/**
	 * @param feeAmount the feeAmount to set
	 */
	public void setFeeAmount(String feeAmount) {
		this.feeAmount = feeAmount;
	}
	/**
	 * @return the selMonth
	 */
	public Byte[] getSelMonth() {
		return selMonth;
	}
	/**
	 * @param selMonth the selMonth to set
	 */
	public void setSelMonth(Byte[] selMonth) {
		this.selMonth = selMonth;
	}
	/**
	 * @return the address1
	 */
	public String getAddress1() {
		return address1;
	}
	/**
	 * @param address1 the address1 to set
	 */
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	/**
	 * @return the address2
	 */
	public String getAddress2() {
		return address2;
	}
	/**
	 * @param address2 the address2 to set
	 */
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	/**
	 * @return the area
	 */
	public String getArea() {
		return area;
	}
	/**
	 * @param area the area to set
	 */
	public void setArea(String area) {
		this.area = area;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * @return the pincode
	 */
	public String getPincode() {
		return pincode;
	}
	/**
	 * @param pincode the pincode to set
	 */
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}
	/**
	 * @param mobile the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the schoolclass
	 */
	public String getSchoolclass() {
		return schoolclass;
	}
	/**
	 * @param schoolclass the schoolclass to set
	 */
	public void setSchoolclass(String schoolclass) {
		this.schoolclass = schoolclass;
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
}
