
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ms.bean.AdmissionFormBean;
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
