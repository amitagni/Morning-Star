/**
 * 
 */
package com.ms.util;

import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import com.ms.bean.ContactDetails;
import com.ms.bean.StudentDetails;
import com.ms.entity.StudentContactInfo;
import com.ms.entity.StudentInfo;
import com.ms.enums.Category;
import com.ms.enums.House;
import com.ms.enums.Month;
import com.ms.enums.Section;
import com.ms.enums.State;
import com.ms.enums.StudentClass;

/**
 * @author Amit.Agnihotri
 *
 */
public class MSUtil {
	private static DecimalFormat  grpdf = new DecimalFormat("####,###,##0.00");

	public static List<Category> populateCategoryList(){
		List<Category> categorieList = new ArrayList<>();
		categorieList.add(Category.GENERAL);
		categorieList.add(Category.OBC);
		categorieList.add(Category.SC);
		categorieList.add(Category.ST);
		
		return categorieList;
	}
	
	public static List<State> populateStateList(){
		List<State> stateList = new ArrayList<>();
		stateList.add(State.UTTARPRADESH);
		stateList.add(State.HARYANA);
		stateList.add(State.MADHYAPRADESH);
		return stateList;
	}
	
	public static List<StudentClass> populateClassList(){
		List<StudentClass> classList = new ArrayList<>();
		classList.add(StudentClass.PRE_NUR);
		classList.add(StudentClass.NUR);
		classList.add(StudentClass.KG);
		classList.add(StudentClass.I);
		return classList;
	}
	
	public static List<Section> populateSectionList(){
		List<Section> sectionList = new ArrayList<>();
		sectionList.add(Section.A);
		sectionList.add(Section.B);
		sectionList.add(Section.C);
		return sectionList;
	}
	
	
	public static List<House> populateHouseList(){
		List<House> houseList = new ArrayList<>();
		houseList.add(House.ARAVALI);
		houseList.add(House.SHIVALIK);
		houseList.add(House.NILGIRI);
		return houseList;
	}
	
	public static List<Month> populateMonthList(){
		List<Month> monthList = new ArrayList<>();
		for(Month month : Month.values()){
			monthList.add(month);
		}
		return monthList;
	}
	
	/**
	 * @param contactDetails
	 */
	public static StudentContactInfo populateContactInfo(ContactDetails contactDetails) {
		StudentContactInfo studentContactInfo = new StudentContactInfo();
		studentContactInfo.setAddress1(contactDetails.getAddress1());
		studentContactInfo.setAddress2(contactDetails.getAddress2());
		studentContactInfo.setArea(contactDetails.getArea());
		studentContactInfo.setCity(contactDetails.getCity());
		studentContactInfo.setState(contactDetails.getState());
		studentContactInfo.setPincode(contactDetails.getPincode());
		studentContactInfo.setPhone(contactDetails.getPhone());
		studentContactInfo.setMobile(contactDetails.getMobile());
		studentContactInfo.setEmail(contactDetails.getEmail());
		return studentContactInfo;
		 
	}

	public static String getStudentDocDirectoryPath() {
		String dataDirPath =SessionUtil.getDeploymentPath();
		System.out.println("----------dataDirPath----------------"+dataDirPath);
		String uploadDirPath = dataDirPath + File.separator + MSConstant.UPLOADDIR;
		System.out.println("----------------------U	pload Path-------------------------------------------"+uploadDirPath);
		File reportDir = new File(uploadDirPath);
		if (!reportDir.exists()) {
			reportDir.mkdir();
		}

		return uploadDirPath;
	}
	
	/**
	 * @param studentDetails
	 */
	public static StudentInfo populateStudentInfo(StudentDetails studentDetails) {
		StudentInfo studentInfo = new StudentInfo();
		studentInfo.setFirstName(studentDetails.getFirstName());
		studentInfo.setLastName(studentDetails.getLastName());
		studentInfo.setDob(studentDetails.getDob());
		studentInfo.setFatherName(studentDetails.getFatherName());
		studentInfo.setMotherName(studentDetails.getMotherName());
		studentInfo.setAdmissionClass(studentDetails.getStudentAdmissionClass());
		studentInfo.setCurrentClass(studentDetails.getStudentAdmissionClass());
		studentInfo.setCategory(Category.findCodeByName(studentDetails.getCategory()));
		studentInfo.setSection(studentDetails.getSection());
		studentInfo.setHouse(studentDetails.getHouse());
		studentInfo.setNationality(studentDetails.getNationality());
		studentInfo.setReligion(studentDetails.getReligion());
		studentInfo.setCaste(studentDetails.getCaste());
		studentInfo.setGender(studentDetails.getGender());
		studentInfo.setCreatedBy(SessionUtil.getUser().getId());
		return studentInfo;
	}
	
	/**
	 * @param value
	 * @return
	 */
	public static boolean isEmpty(String value) {
		if(value == null)
			return true;
		else if(value.trim().equals(MSConstant.BLANK))
			return true;
		else
			return false;
		
	}
	
	/**
	 * @param value
	 * @return
	 */
	public static String formatValue(float value){
		return grpdf.format(value);
	}
}
