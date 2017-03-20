
package com.ms.controller;

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

import com.ms.bean.ContactDetails;
import com.ms.bean.PaymentFormBean;
import com.ms.bean.RegistrationFormBean;
import com.ms.bean.StudentDetails;
import com.ms.entity.Payment;
import com.ms.entity.StudentContactInfo;
import com.ms.entity.StudentInfo;
import com.ms.entity.StudentReg;
import com.ms.enums.Category;
import com.ms.enums.FeeType;
import com.ms.enums.StudentClass;
import com.ms.service.PaymentService;
import com.ms.service.RegistrationService;
import com.ms.util.MSException;
import com.ms.util.MSUtil;

/**
 * @author Amit Agnihotri
 *
 */
@Controller
@Scope("request")
public class RegistrationController {

	 @Autowired
	 private RegistrationService registrationService;

	 @Autowired
	 private PaymentService paymentService;
	
	/**
	 * @param login
	 * @param bindingResult
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/registration", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView registration(@ModelAttribute("registrationFormBean") RegistrationFormBean registrationFormBean, BindingResult bindingResult, Model model,HttpServletRequest request) {
		if (request.getMethod().equalsIgnoreCase(RequestMethod.GET.name())) {
			populateRegistrationFormBean(registrationFormBean);
			return new ModelAndView("registration", "registrationFormBean", registrationFormBean);
		}else{
			try {
				saveRegistrationFormBean(registrationFormBean);
				return new ModelAndView("redirect:/reg-payment.do");
			} catch (Exception e) {
				e.printStackTrace();
				return new ModelAndView("registration", "registrationFormBean", registrationFormBean);
			}
			
		}
	}
	
	@RequestMapping(value = "/reg-payment", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView regPayment(@ModelAttribute("paymentFormBean") PaymentFormBean paymentFormBean, BindingResult bindingResult, Model model,HttpServletRequest request) {
		if (request.getMethod().equalsIgnoreCase(RequestMethod.GET.name())) {
			populatePaymentFormBean(paymentFormBean);
			return new ModelAndView("reg-payment", "paymentFormBean", paymentFormBean);
		}else{
			try {
				savePaymentFormBean(paymentFormBean);
				return new ModelAndView("redirect:/reg-receipt.do");
			} catch (Exception e) {
				e.printStackTrace();
				return new ModelAndView("reg-payment", "paymentFormBean", paymentFormBean);
			}
			
		}
	}
	
	@RequestMapping(value = "/reg-receipt")
	public ModelAndView regReceipt(Model model,HttpServletRequest request) {
		return new ModelAndView("reg-receipt");
	}

	
	public void populateRegistrationFormBean(RegistrationFormBean registrationFormBean) {
			registrationFormBean.setCategoryList(MSUtil.populateCategoryList());
			registrationFormBean.setStateList(MSUtil.populateStateList());
			registrationFormBean.setStudentClassList(MSUtil.populateClassList());
	}
	
	
	private void saveRegistrationFormBean(RegistrationFormBean registrationFormBean) throws Exception {
		saveStudentInfoAndContact(registrationFormBean);
		registrationFormBean.setCategoryList(MSUtil.populateCategoryList());
		registrationFormBean.setStateList(MSUtil.populateStateList());
		registrationFormBean.setStudentClassList(MSUtil.populateClassList());
	}
	
	
	private void saveStudentInfoAndContact(RegistrationFormBean registrationFormBean) throws MSException  {
		StudentReg studentReg = new StudentReg();
		studentReg.setFormNumber(registrationFormBean.getFormNum());
		studentReg.setRegDate(registrationFormBean.getDateOfIssue());
		studentReg.setRegNumber(registrationFormBean.getRegNum());
		studentReg.setLastClass(StudentClass.findCodeByName(registrationFormBean.getLastClass()));
		studentReg.setLastSchool(registrationFormBean.getLastSchool());
		studentReg.setResult(registrationFormBean.getLastClassResult());
		studentReg.setCreatedBy(1);
		StudentInfo studentInfo = MSUtil.populateStudentInfo(registrationFormBean.getStudentDetails());
		StudentContactInfo studentContactInfo  = MSUtil.populateContactInfo(registrationFormBean.getContactDetails());
		registrationService.save(studentReg,studentInfo,studentContactInfo);
		
	}
	





	/**
	 * @param paymentFormBean
	 */
	private void populatePaymentFormBean(PaymentFormBean paymentFormBean) {
		// TODO Auto-generated method stub
		
	}


	/**
	 * @param paymentFormBean
	 */
	private void savePaymentFormBean(PaymentFormBean paymentFormBean) {
		Payment payment = new Payment();
		payment.setStudentId(1);
		payment.setAmount(paymentFormBean.getAmount());
		payment.setFeeType(FeeType.REGFEES.getCode());
		paymentService.save(payment);
		
	}
	
}
