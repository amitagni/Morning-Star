package com.ms.bean;

import java.util.List;

import com.ms.enums.StudentClass;



public class AbacusRegBean {

	
	private int id;
	private String FormNum;
	private String FirstName;
	private String LastName;
	private String NickName;
	private String DateOfBirth;
	private String FatherName;
	private String MotherName;
	private String Schoolname;
	private String Gender;
	private String feeAmount;
	private Byte[] selMonth;
	private String address1;
	private String address2;
	private String area;
	private String city;
	private String state;
	private String pincode;
	private String schoolclass;
	
	public List<StudentClass> getStudentClassList() {
		return studentClassList;
	}
	public void setStudentClassList(List<StudentClass> studentClassList) {
		this.studentClassList = studentClassList;
	}
	private String phone;
	private String mobile;
	private String email;
	private List<StudentClass> studentClassList;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFormNum() {
		return FormNum;
	}
	public void setFormNum(String formNum) {
		FormNum = formNum;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getNickName() {
		return NickName;
	}
	public void setNickName(String nickName) {
		NickName = nickName;
	}
	public String getDateOfBirth() {
		return DateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		DateOfBirth = dateOfBirth;
	}
	public String getFatherName() {
		return FatherName;
	}
	public void setFatherName(String fatherName) {
		FatherName = fatherName;
	}
	public String getMotherName() {
		return MotherName;
	}
	public void setMotherName(String motherName) {
		MotherName = motherName;
	}
	public String getSchoolname() {
		return Schoolname;
	}
	public void setSchoolname(String schoolname) {
		Schoolname = schoolname;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public String getFeeAmount() {
		return feeAmount;
	}
	public void setFeeAmount(String feeAmount) {
		this.feeAmount = feeAmount;
	}
	public Byte[] getSelMonth() {
		return selMonth;
	}
	public void setSelMonth(Byte[] selMonth) {
		this.selMonth = selMonth;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
