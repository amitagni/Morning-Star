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
import com.ms.enums.Nationality;
import com.ms.enums.Religion;
import com.ms.enums.Result;
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
		for(Category category:Category.values()){
			categorieList.add(category);
		}
		return categorieList;
	}
	
	public static List<State> populateStateList(){
		List<State> stateList = new ArrayList<>();
		for(State state:State.values()){
			stateList.add(state);
		}
		return stateList;
	}
	
	public static List<StudentClass> populateClassList(){
		List<StudentClass> classList = new ArrayList<>();
		for(StudentClass stClass:StudentClass.values()){
			classList.add(stClass);
		}
		
		return classList;
	}
	
	public static List<Section> populateSectionList(){
		List<Section> sectionList = new ArrayList<>();
		for(Section section:Section.values()){
			sectionList.add(section);
		}
		return sectionList;
	}
	
	
	public static List<House> populateHouseList(){
		List<House> houseList = new ArrayList<>();
		for(House house:House.values()){
			houseList.add(house);
		}
		return houseList;
	}
	
	public static List<Month> populateMonthList(){
		List<Month> monthList = new ArrayList<>();
		for(Month month : Month.values()){
			monthList.add(month);
		}
		return monthList;
	}
	
	public static List<Result> populateResultList(){
		List<Result> resultList = new ArrayList<>();
		for(Result result : Result.values()){
			resultList.add(result);
		}
		return resultList;
	}
	
	public static List<Religion> populateReligionList(){
		List<Religion> religionList = new ArrayList<>();
		for(Religion religion : Religion.values()){
			religionList.add(religion);
		}
		return religionList;
	}
	
	public static List<Nationality> populateNationalityList(){
		List<Nationality> nationalityList = new ArrayList<>();
		for(Nationality nationality : Nationality.values()){
			nationalityList.add(nationality);
		}
		return nationalityList;
	}
	
	/**
	 * @param contactDetails
	 */
	public static StudentContactInfo populateContactInfo(ContactDetails contactDetails) {
		StudentContactInfo studentContactInfo = new StudentContactInfo();
		studentContactInfo.setId(contactDetails.getId());
		studentContactInfo.setAddress1(contactDetails.getAddress1());
		studentContactInfo.setAddress2(contactDetails.getAddress2());
		studentContactInfo.setArea(contactDetails.getArea());
		studentContactInfo.setCity(contactDetails.getCity());
		studentContactInfo.setState(contactDetails.getState());
		studentContactInfo.setPincode(contactDetails.getPincode());
		studentContactInfo.setPhone(contactDetails.getPhone());
		studentContactInfo.setMobile(contactDetails.getMobile());
		studentContactInfo.setEmail(contactDetails.getEmail());
		studentContactInfo.setCreatedBy(SessionUtil.getUser().getId());
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
		studentInfo.setId(studentDetails.getId());
		studentInfo.setRegId(studentDetails.getRegId());
		studentInfo.setFirstName(studentDetails.getFirstName());
		studentInfo.setLastName(studentDetails.getLastName());
		studentInfo.setDob(studentDetails.getDob());
		studentInfo.setFatherName(studentDetails.getFatherName());
		studentInfo.setMotherName(studentDetails.getMotherName());
		studentInfo.setAdmissionClass(studentDetails.getStudentAdmissionClass());
		studentInfo.setCurrentClass(studentDetails.getStudentAdmissionClass());
		studentInfo.setCategory(studentDetails.getCategory());
		studentInfo.setSection(studentDetails.getSection());
		studentInfo.setHouse(studentDetails.getHouse());
		studentInfo.setNationality(studentDetails.getNationality());
		studentInfo.setReligion(studentDetails.getReligion());
		studentInfo.setCaste(studentDetails.getCaste());
		studentInfo.setGender(studentDetails.getGender());
		studentInfo.setFatherOccupation(studentDetails.getFatherOccupation());
		studentInfo.setCreatedBy(SessionUtil.getUser().getId());
		StringBuilder subjects = new StringBuilder();
		if(studentDetails.getSubjects() != null){
			for(Byte subject :studentDetails.getSubjects()){
				subjects.append(subject);
				subjects.append(MSConstant.COMMA);
				
			}
		}
		studentInfo.setSubjects(subjects.toString());
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
