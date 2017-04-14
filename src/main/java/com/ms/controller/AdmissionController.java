
package com.ms.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

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
import com.ms.service.AdmissionService;
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
		if (request.getMethod().equalsIgnoreCase(RequestMethod.GET.name())) {
			String regId = request.getParameter("regId");
			
			if(regId != null){
				StudentInfo studentInfo = admissionService.findStudentByRegNum(regId);
				StudentContactInfo studentContactInfo = null;
				if(studentInfo != null)
					studentContactInfo = admissionService.findStudentContactInfoByStudentId(studentInfo.getId());
				
				populateAdmissionFormBeanWithStudentData(studentInfo,studentContactInfo,admissionFormBean);
				
			}
			populateAdmissionFormBean(admissionFormBean);
			return new ModelAndView("admission", "admissionFormBean", admissionFormBean);
		}else{
			try {
				
				StudentInfo studentInfo = saveAdmissionFormBean(admissionFormBean);
				String path = MSUtil.getStudentDocDirectoryPath();
				System.out.println("Path:::"+path);
				byte[] bytes = null;
				BufferedOutputStream bout = null;
				String studentPhotoPath = null;
				String studentTcPath  = null;
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
				studentInfo.setPhoto(studentPhotoPath);
				studentInfo.setTcPath(studentTcPath);
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
	 * @param studentInfo
	 * @param studentContactInfo
	 * @param admissionFormBean
	 */
	private void populateAdmissionFormBeanWithStudentData(StudentInfo studentInfo, StudentContactInfo studentContactInfo, AdmissionFormBean admissionFormBean) {
		StudentDetails studentDetails =  null;
	    ContactDetails contactDetails = null;
	    if(studentInfo != null){
	    	studentDetails = new StudentDetails();
	    	studentDetails.setFirstName(studentInfo.getFirstName());
	    	studentDetails.setLastName(studentInfo.getLastName());
	    	studentDetails.setDob(studentInfo.getDob());
	    	studentDetails.setGender(studentInfo.getGender());
	    	studentDetails.setFatherName(studentInfo.getFatherName());
	    	studentDetails.setMotherName(studentInfo.getMotherName());
	    	studentDetails.setStudentClass(studentInfo.getCurrentClass()==null?-1:studentInfo.getCurrentClass());
	    	studentDetails.setSection(studentInfo.getSection()==null?-1:studentInfo.getSection());
	    	studentDetails.setCategory(String.valueOf(studentInfo.getCategory()));
	    	studentDetails.setReligion(studentInfo.getReligion());
	    	studentDetails.setCaste(studentInfo.getCaste());
	    	if(studentInfo.getPhoto() != null){
	    		admissionFormBean.setStudentPhotoPath(MSConstant.HTTPPATH + "/" + MSConstant.UPLOADDIR + "/" + studentInfo.getPhoto());
	    		System.out.println(admissionFormBean.getStudentPhotoPath());
	    	}
	    }
	    if(studentContactInfo != null){
	    	contactDetails = new ContactDetails();
	    	contactDetails.setAddress1(studentContactInfo.getAddress1());
	    	contactDetails.setAddress2(studentContactInfo.getAddress2());
	    	contactDetails.setArea(studentContactInfo.getArea());
	    	contactDetails.setCity(studentContactInfo.getCity());
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
		admissionFormBean.setHouseList(MSUtil.populateHouseList());
		admissionFormBean.setSectionList(MSUtil.populateSectionList());
		
	}

	/**
	 * @param admissionFormBean
	 * @throws MSException 
	 */
	public StudentInfo saveAdmissionFormBean(AdmissionFormBean admissionFormBean) throws MSException {
		StudentInfo studentInfo = MSUtil.populateStudentInfo(admissionFormBean.getStudentDetails());
		StudentContactInfo studentContactInfo  = MSUtil.populateContactInfo(admissionFormBean.getContactDetails());
		admissionService.save(studentInfo, studentContactInfo);
		return studentInfo;
	}
	
	

}
