
package com.ms.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ms.bean.AdmissionFormBean;
import com.ms.bean.ContactDetails;
import com.ms.bean.StudentDetails;
import com.ms.entity.StudentContactInfo;
import com.ms.entity.StudentInfo;
import com.ms.entity.StudentReg;
import com.ms.service.AdmissionService;
import com.ms.service.RegistrationService;
import com.ms.util.MSConstant;
import com.ms.util.MSException;
import com.ms.util.MSUtil;
import com.ms.util.SessionUtil;

/**
 * @author Amit Agnihotri
 *
 */
@Controller
@Scope("request")
public class AdmissionController {


	@Autowired
	private AdmissionService admissionService;
	
	@Autowired
	private RegistrationService registrationService;

	
	/**
	 * @param login
	 * @param bindingResult
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/admission", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView admission(@ModelAttribute("admissionFormBean") AdmissionFormBean admissionFormBean, BindingResult bindingResult, Model model,HttpServletRequest request) {
		SessionUtil.setPage(MSConstant.ADMISSION);
		

		populateAdmissionFormBean(admissionFormBean);
		if (request.getMethod().equalsIgnoreCase(RequestMethod.GET.name())) {
			String regId = request.getParameter("regId");
			StudentReg studentReg  = null;
			if(regId != null){
				try {
				  studentReg =registrationService.findId(Integer.parseInt(regId));
				} catch (MSException e) {
					e.printStackTrace();
				}
				StudentInfo studentInfo = admissionService.findStudentByRegNum(regId);
				StudentContactInfo studentContactInfo = null;
				if(studentInfo != null)
					studentContactInfo = admissionService.findStudentContactInfoByStudentId(studentInfo.getId());
				
				populateAdmissionFormBeanWithStudentData(studentReg,studentInfo,studentContactInfo,admissionFormBean);
				
			}
			return new ModelAndView("admission", "admissionFormBean", admissionFormBean);
		}else{
			try {
				
				StudentInfo studentInfo = saveAdmissionFormBean(admissionFormBean);
				String path = MSUtil.getStudentDocDirectoryPath();
				System.out.println("Path:::"+path);
				byte[] bytes = null;
				BufferedOutputStream bout = null;
				String studentPhotoPath = admissionFormBean.getStudentPhotoPath();
				String studentTcPath  = admissionFormBean.getStudentTcPath();
				if(studentPhotoPath != null){
					int index = studentPhotoPath.indexOf(MSConstant.UPLOADDIR);
					if(index != -1){
						studentPhotoPath = studentPhotoPath.substring(index+MSConstant.UPLOADDIR.length()+1,studentPhotoPath.length());
					}
				}
				if(studentTcPath != null){
					int index = studentTcPath.indexOf(MSConstant.UPLOADDIR);
					if(index != -1){
						studentTcPath = studentTcPath.substring(index+MSConstant.UPLOADDIR.length()+1,studentTcPath.length());
					}
				}
				if(admissionFormBean.getStudentPhoto().getSize() != 0){
					studentPhotoPath =   studentInfo.getId() +  File.separator + admissionFormBean.getStudentPhoto().getOriginalFilename();
					bytes = admissionFormBean.getStudentPhoto().getBytes();
					File studentDir = new File(path +  File.separator +  studentInfo.getId());
					if (!studentDir.exists()) {
						studentDir.mkdir();
					}
					bout = new BufferedOutputStream(new FileOutputStream(path + File.separator + studentPhotoPath ));
					bout.write(bytes);
					bout.flush();
					bout.close();
				}
				if(admissionFormBean.getStudentTc().getSize() != 0){
					studentTcPath =   studentInfo.getId() +  File.separator + admissionFormBean.getStudentTc().getOriginalFilename();
					bytes = admissionFormBean.getStudentTc().getBytes();
					bout = new BufferedOutputStream(new FileOutputStream(path +  File.separator + studentTcPath));
					bout.write(bytes);
					bout.flush();
					bout.close();
				}
				if(studentPhotoPath.equals(MSConstant.DEFAULTIMAGEPATH))
					studentPhotoPath = null;
				if(studentTcPath.equals(MSConstant.DEFAULTIMAGEPATH))
					studentTcPath = null;
				studentInfo.setPhoto(studentPhotoPath);
				studentInfo.setTcPath(studentTcPath);
				studentInfo.setSibling_study(Byte.valueOf((byte) (admissionFormBean.isSiblingStudy()?1:0)));
				studentInfo.setTransportTaken(Byte.valueOf((byte) (admissionFormBean.isTransportReq()?1:0)));
				admissionService.save(studentInfo);
				if(studentInfo.getId() != null)
					return new ModelAndView("redirect:/fee.do?id="+studentInfo.getId().intValue());
				else
					return new ModelAndView("admission", "admissionFormBean", admissionFormBean);
			} catch (Exception e) {
				e.printStackTrace();
				return new ModelAndView("admission", "admissionFormBean", admissionFormBean);
			}
			
		}
		
		
	}
	
	/**
	 * @param studentReg 
	 * @param studentInfo
	 * @param studentContactInfo
	 * @param admissionFormBean
	 */
	private void populateAdmissionFormBeanWithStudentData(StudentReg studentReg, StudentInfo studentInfo, StudentContactInfo studentContactInfo, AdmissionFormBean admissionFormBean) {
		StudentDetails studentDetails =  null;
	    ContactDetails contactDetails = null;
	    if(studentReg != null){
	    	admissionFormBean.setApplicationDate(studentReg.getRegDate());
	    	admissionFormBean.setLastSchool(studentReg.getLastSchool());
	    	admissionFormBean.setLastClass(studentReg.getLastClass());
	    	admissionFormBean.setLastClassResult(studentReg.getResult());
	    	admissionFormBean.setRegNum(studentReg.getId());
	    }
	    if(studentInfo != null){
	    	boolean transporttaken = false;
	    	if(studentInfo.getTransportTaken()!= null && studentInfo.getTransportTaken().byteValue() == 1)
	    		transporttaken = true;
	    	
	    	boolean siblingStudy = false;
	    	if(studentInfo.getSibling_study()!= null && studentInfo.getSibling_study().byteValue() == 1)
	    		siblingStudy = true;
	    	
	    	admissionFormBean.setTransportReq(transporttaken);
	    	admissionFormBean.setSiblingStudy(siblingStudy);
	    	
	    	studentDetails = new StudentDetails();
	    	studentDetails.setId(studentInfo.getId());
	    	studentDetails.setFirstName(studentInfo.getFirstName());
	    	studentDetails.setRegId(studentInfo.getRegId());
	    	studentDetails.setLastName(studentInfo.getLastName());
	    	studentDetails.setDob(studentInfo.getDob());
	    	studentDetails.setGender(studentInfo.getGender());
	    	studentDetails.setFatherName(studentInfo.getFatherName());
	    	studentDetails.setMotherName(studentInfo.getMotherName());
	    	studentDetails.setStudentClass(studentInfo.getCurrentClass()==null?-1:studentInfo.getCurrentClass());
	    	studentDetails.setSection(studentInfo.getSection()==null?-1:studentInfo.getSection());
	    	studentDetails.setCategory(studentInfo.getCategory());
	    	studentDetails.setReligion(studentInfo.getReligion());
	    	studentDetails.setCaste(studentInfo.getCaste());
	    	studentDetails.setHouse(studentInfo.getHouse());
	    	studentDetails.setStudentAdmissionClass(studentInfo.getAdmissionClass());
	    	studentDetails.setFatherOccupation(studentInfo.getFatherOccupation());
	    	String subjects = studentInfo.getSubjects();
	    	if(subjects != null && subjects.trim().length()>0){
	    		String[] strArr = subjects.split(MSConstant.COMMA);
	    		byte[] subjectArr = new byte[strArr.length];;
	    		for (int i = 0; i < strArr.length; i++) {
	    			subjectArr[i] = Byte.parseByte(strArr[i]);
				}
	    		studentDetails.setSubjects(subjectArr);
	    	}
	    	if(!MSUtil.isEmpty(studentInfo.getPhoto())){
	    		admissionFormBean.setStudentPhotoPath(MSConstant.HTTPPATH + "/" + MSConstant.UPLOADDIR + "/" + studentInfo.getPhoto());
	    		System.out.println(admissionFormBean.getStudentPhotoPath());
	    	}
	    	if(!MSUtil.isEmpty(studentInfo.getTcPath())){
	    		admissionFormBean.setStudentTcPath(MSConstant.HTTPPATH + "/" + MSConstant.UPLOADDIR + "/" + studentInfo.getTcPath());
	    		System.out.println(admissionFormBean.getStudentPhotoPath());
	    	}
	    }
	    if(studentContactInfo != null){
	    	contactDetails = new ContactDetails();
	    	contactDetails.setId(studentContactInfo.getId());
	    	contactDetails.setAddress1(studentContactInfo.getAddress1());
	    	contactDetails.setAddress2(studentContactInfo.getAddress2());
	    	contactDetails.setArea(studentContactInfo.getArea());
	    	contactDetails.setCity(studentContactInfo.getCity());
	    	contactDetails.setPincode(studentContactInfo.getPincode());
	    	contactDetails.setState(studentContactInfo.getState());
	    	contactDetails.setPhone(studentContactInfo.getPhone());
	    	contactDetails.setMobile(studentContactInfo.getMobile());
	    	contactDetails.setEmail(studentContactInfo.getEmail());
	    }
	    admissionFormBean.setStudentDetails(studentDetails);
	    admissionFormBean.setContactDetails(contactDetails);
	    
	}

	/**
	 * @param admissionFormBean
	 */
	public void populateAdmissionFormBean(AdmissionFormBean admissionFormBean) {
		
		admissionFormBean.setCategoryList(MSUtil.populateCategoryList());
		admissionFormBean.setStateList(MSUtil.populateStateList());
		admissionFormBean.setStudentClassList(MSUtil.populateClassList());
		admissionFormBean.setResultList(MSUtil.populateResultList());
		admissionFormBean.setReligionList(MSUtil.populateReligionList());
		admissionFormBean.setHouseList(MSUtil.populateHouseList());
		admissionFormBean.setSectionList(MSUtil.populateSectionList());
		admissionFormBean.setNationalityList(MSUtil.populateNationalityList());
		
	}

	/**
	 * @param admissionFormBean
	 * @throws MSException 
	 */
	public StudentInfo saveAdmissionFormBean(AdmissionFormBean admissionFormBean) throws MSException {
		StudentReg studentReg = null;
		if(admissionFormBean.getStudentDetails().getRegId() == null){
			studentReg = new StudentReg();
			//studentReg.setFormNumber(registrationFormBean.getFormNum());
			studentReg.setRegDate(admissionFormBean.getApplicationDate());
			studentReg.setLastClass(admissionFormBean.getLastClass());
			studentReg.setLastSchool(admissionFormBean.getLastSchool());
			studentReg.setResult(admissionFormBean.getLastClassResult());
			studentReg.setCreatedBy(SessionUtil.getUser().getId());
		}else{
			studentReg = registrationService.findId(admissionFormBean.getStudentDetails().getRegId());
			studentReg.setLastClass(admissionFormBean.getLastClass());
			studentReg.setLastSchool(admissionFormBean.getLastSchool());
			studentReg.setResult(admissionFormBean.getLastClassResult());
		}
		StudentInfo studentInfo = MSUtil.populateStudentInfo(admissionFormBean.getStudentDetails());
		StudentContactInfo studentContactInfo  = MSUtil.populateContactInfo(admissionFormBean.getContactDetails());
		//admissionService.save(studentInfo, studentContactInfo);
		registrationService.save(studentReg,studentInfo,studentContactInfo);
		return studentInfo;
	}
	
	

}
