
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ms.bean.PaymentFormBean;
import com.ms.bean.RegistrationFormBean;
import com.ms.entity.Payment;
import com.ms.entity.StudentContactInfo;
import com.ms.entity.StudentInfo;
import com.ms.entity.StudentReg;
import com.ms.enums.FeeType;
import com.ms.enums.PaymentType;
import com.ms.enums.StudentClass;
import com.ms.service.AdmissionService;
import com.ms.service.PaymentService;
import com.ms.service.RegistrationService;
import com.ms.util.DateUtils;
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
public class RegistrationController {

	 @Autowired
	 private RegistrationService registrationService;

	 @Autowired
	 private PaymentService paymentService;
	
	 
	@Autowired
	private AdmissionService admissionService;
	/**
	 * @param login
	 * @param bindingResult
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/registration", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView registration(@ModelAttribute("registrationFormBean") RegistrationFormBean registrationFormBean, BindingResult bindingResult, Model model,HttpServletRequest request) {
		SessionUtil.setPage(MSConstant.REGISTRATION);
		if (request.getMethod().equalsIgnoreCase(RequestMethod.GET.name())) {
			populateRegistrationFormBean(registrationFormBean);
			return new ModelAndView("registration", "registrationFormBean", registrationFormBean);
		}else{
			try {
				Integer id = saveRegistrationFormBean(registrationFormBean);
				return new ModelAndView("redirect:/reg-payment.do?id="+id);
			} catch (Exception e) {
				e.printStackTrace();
				return new ModelAndView("registration", "registrationFormBean", registrationFormBean);
			}
			
		}
		
	}
	
	@RequestMapping(value = "/reg-payment", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView regPayment(@ModelAttribute("paymentFormBean") PaymentFormBean paymentFormBean, BindingResult bindingResult, Model model,HttpServletRequest request) {
		SessionUtil.setPage(MSConstant.REGISTRATION);
		if (request.getMethod().equalsIgnoreCase(RequestMethod.GET.name())) {
			String studentId =  request.getParameter(MSConstant.ID);
			paymentFormBean.setStudentId(Integer.parseInt(studentId));
			populatePaymentFormBean(paymentFormBean);
			return new ModelAndView("reg-payment", "paymentFormBean", paymentFormBean);
		}else{
			try {
				savePaymentFormBean(paymentFormBean);
				return new ModelAndView("redirect:/reg-receipt.do?id="+paymentFormBean.getStudentId()+"&amt="+paymentFormBean.getAmount());
			} catch (Exception e) {
				e.printStackTrace();
				return new ModelAndView("reg-payment", "paymentFormBean", paymentFormBean);
			}
			
		}
	}
	
	@RequestMapping(value = "/reg-receipt")
	public ModelAndView regReceipt(Model model,HttpServletRequest request) {
		SessionUtil.setPage(MSConstant.REGISTRATION);
		String regDate = DateUtils.convertToStringObject(DateUtils.getCurrentDateTime(),"dd/MM/yyyy");
		String studentId =  request.getParameter(MSConstant.ID);
		StudentInfo studentInfo = admissionService.findStudentById(Integer.parseInt(studentId));
		String amount =  request.getParameter(MSConstant.AMOUNT);
		model.addAttribute(MSConstant.ID,studentInfo.getRegId());
		model.addAttribute(MSConstant.NAME,studentInfo.getFirstName() + MSConstant.SPACE + studentInfo.getLastName());
		model.addAttribute(MSConstant.STUDENTCLASS,StudentClass.findNameByCode(studentInfo.getCurrentClass()));
		model.addAttribute(MSConstant.DATE,regDate);
		model.addAttribute(MSConstant.AMOUNT, amount);
		return new ModelAndView("reg-receipt");
	}
	
	@RequestMapping(value = "/fetch-regid")
	public @ResponseBody Integer getRegistrationId(HttpServletRequest request) {
		String regNumber = request.getParameter("regId");
		int id = -1;
		try {
			StudentReg studentReg = registrationService.findId(Integer.parseInt(regNumber));
			if(studentReg != null)
				id = studentReg.getId();
		} catch (MSException e) {
			e.printStackTrace();
		}
		return id;
	}

	
	public void populateRegistrationFormBean(RegistrationFormBean registrationFormBean) {
			registrationFormBean.setCategoryList(MSUtil.populateCategoryList());
			registrationFormBean.setStateList(MSUtil.populateStateList());
			registrationFormBean.setStudentClassList(MSUtil.populateClassList());
	}
	
	
	private Integer saveRegistrationFormBean(RegistrationFormBean registrationFormBean) throws Exception {
		Integer studentId = saveStudentInfoAndContact(registrationFormBean);
		registrationFormBean.setCategoryList(MSUtil.populateCategoryList());
		registrationFormBean.setStateList(MSUtil.populateStateList());
		registrationFormBean.setStudentClassList(MSUtil.populateClassList());
		return studentId;
	} 
	
	
	private Integer saveStudentInfoAndContact(RegistrationFormBean registrationFormBean) throws MSException  {
		StudentReg studentReg = new StudentReg();
		studentReg.setFormNumber(registrationFormBean.getFormNum());
		studentReg.setRegDate(registrationFormBean.getDateOfIssue());
		studentReg.setLastClass(registrationFormBean.getLastClass());
		studentReg.setLastSchool(registrationFormBean.getLastSchool());
		studentReg.setResult(registrationFormBean.getLastClassResult());
		studentReg.setCreatedBy(SessionUtil.getUser().getId());
		StudentInfo studentInfo = MSUtil.populateStudentInfo(registrationFormBean.getStudentDetails());
		StudentContactInfo studentContactInfo  = MSUtil.populateContactInfo(registrationFormBean.getContactDetails());
		registrationService.save(studentReg,studentInfo,studentContactInfo);
		return studentInfo.getId();
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
		payment.setStudentId(paymentFormBean.getStudentId());
		payment.setAmount(paymentFormBean.getAmount());
		payment.setFeeType(FeeType.REGFEES.getCode());
		payment.setPaymentType(PaymentType.CASH.getCode());
		payment.setComment(paymentFormBean.getComment());
		payment.setCreatedBy(SessionUtil.getUser().getId());
		paymentService.save(payment);
		
	}
	
}
