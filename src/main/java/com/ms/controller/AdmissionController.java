
package com.ms.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ms.bean.AdmissionFormBean;
import com.ms.bean.Login;
import com.ms.bean.RegistrationFormBean;
import com.ms.entity.StudentContactInfo;
import com.ms.entity.StudentInfo;
import com.ms.service.AdmissionService;
import com.ms.util.MSException;
import com.ms.util.MSUtil;

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
	public ModelAndView registration(@ModelAttribute("admissionFormBean") AdmissionFormBean admissionFormBean, BindingResult bindingResult, Model model,HttpServletRequest request) {
		if (request.getMethod().equalsIgnoreCase(RequestMethod.GET.name())) {
			populateAdmissionFormBean(admissionFormBean);
			return new ModelAndView("admission", "admissionFormBean", admissionFormBean);
		}else{
			try {
				saveAdmissionFormBean(admissionFormBean);
				return new ModelAndView("redirect:/fee.do");
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
	public void saveAdmissionFormBean(AdmissionFormBean admissionFormBean) throws MSException {
		StudentInfo studentInfo = MSUtil.populateStudentInfo(admissionFormBean.getStudentDetails());
		StudentContactInfo studentContactInfo  = MSUtil.populateContactInfo(admissionFormBean.getContactDetails());
		admissionService.save(studentInfo, studentContactInfo);
	}
	
	

}
