/**
 * 
 */
package com.ms.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.StringTokenizer;

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

import com.ms.bean.FeeFormBean;
import com.ms.bean.PaymentFormBean;
import com.ms.dto.FeeDTO;
import com.ms.dto.FeeSummaryDTO;
import com.ms.entity.FeeSlip;
import com.ms.entity.FeeStructure;
import com.ms.entity.PaidFeeSummary;
import com.ms.entity.Payment;
import com.ms.entity.StudentInfo;
import com.ms.enums.FeeFreqType;
import com.ms.enums.FeeType;
import com.ms.enums.Month;
import com.ms.enums.PaymentType;
import com.ms.service.AdmissionService;
import com.ms.service.FeeService;
import com.ms.service.PaymentService;
import com.ms.util.MSConstant;
import com.ms.util.MSException;
import com.ms.util.MSUtil;
import com.ms.util.SessionUtil;

@Controller
@Scope("request")
public class FeeController {
	
	@Autowired
	private FeeService feeService;
	
	@Autowired
	private AdmissionService admissionService;

	
	 @Autowired
	 private PaymentService paymentService;

	@RequestMapping(value = "/fee", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView fee(@ModelAttribute("feeFormBean") FeeFormBean feeFormBean, BindingResult bindingResult, Model model,HttpServletRequest request) {
		SessionUtil.setPage(MSConstant.FEE);
		if (request.getMethod().equalsIgnoreCase(RequestMethod.GET.name())) {
			String studentId =  request.getParameter(MSConstant.ID);
			populateFeeFormBean(feeFormBean,studentId);
			return new ModelAndView("fee", "feeFormBean", feeFormBean);
		}else{
			try {
				Integer userId = SessionUtil.getUser().getId();
				FeeSummaryDTO feeSummaryDTO =  saveFeeFormBean(feeFormBean,userId);
				StringBuilder ids = new StringBuilder();
				for (FeeSlip feeSlip : feeSummaryDTO.getFeeSlipList()) {
					ids.append(feeSlip.getId()).append(",");
				}
				
				return new ModelAndView("redirect:/fee-payment.do?ids="+ids+"&id="+feeFormBean.getStudentId()+"&s="+feeFormBean.getFeeSummaryId()+"&m="+feeSummaryDTO.getMonthIds()+"&q="+feeSummaryDTO.getQuarterlyIds()+"&h="+feeSummaryDTO.getHalsyrlyIds()+"&a="+feeSummaryDTO.getAnuallyIds()+"&amt="+feeFormBean.getTotalAmt());
			} catch (Exception e) {
				e.printStackTrace();
				populateFeeFormBean(feeFormBean,String.valueOf(feeFormBean.getStudentId()));
				return new ModelAndView("fee", "feeFormBean", feeFormBean);
			}
			
		}
	}
	
	@RequestMapping(value = "/fee-payment", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView feePayment(@ModelAttribute("paymentFormBean") PaymentFormBean paymentFormBean, BindingResult bindingResult, Model model,HttpServletRequest request) {
		SessionUtil.setPage(MSConstant.FEE);
		if (request.getMethod().equalsIgnoreCase(RequestMethod.GET.name())) {
			Integer studentId =  Integer.parseInt(request.getParameter(MSConstant.ID));
			String feeSlipIds =  request.getParameter(MSConstant.IDS);
			paymentFormBean.setFeeSlipIds(feeSlipIds);
			paymentFormBean.setStudentId(studentId);
			if(request.getParameter("s") == null || request.getParameter("s").equals("null")){
				paymentFormBean.setFeeSummaryId(-1);
			}else{
				paymentFormBean.setFeeSummaryId(Integer.parseInt(request.getParameter("s")));
			}
			paymentFormBean.setMonthIds(request.getParameter("m"));
			paymentFormBean.setQuarterlyIds(request.getParameter("q"));
			paymentFormBean.setHalsyrlyIds(request.getParameter("h"));
			paymentFormBean.setAnuallyIds(request.getParameter("h"));
			paymentFormBean.setAmount(request.getParameter("amt"));
			populatePaymentFormBean(paymentFormBean);
			paymentFormBean.setPaymentType(PaymentType.CASH.getCode());
			return new ModelAndView("fee-payment", "paymentFormBean", paymentFormBean);
		}else{
			try {
				Integer paymentId = saveFeePaymentFormBean(paymentFormBean);
				Integer userId = SessionUtil.getUser().getId();
				updateFeeSlipWithPayment(paymentId,paymentFormBean.getFeeSlipIds());
				updateFeeSummary(paymentFormBean, userId);
				
				return new ModelAndView("redirect:/fee-reciept.do");
			} catch (Exception e) {
				e.printStackTrace();
				return new ModelAndView("fee-payment", "paymentFormBean", paymentFormBean);
			}
			
		}
	}

	/**
	 * @param paymentFormBean
	 * @param userId
	 */
	private void updateFeeSummary(PaymentFormBean paymentFormBean, Integer userId) {
		PaidFeeSummary paidFeeSummary = null;
		if(paymentFormBean.getFeeSummaryId() != null){
			try {
				 paidFeeSummary = feeService.findByStudentId(paymentFormBean.getStudentId());
			} catch (MSException e) {
				e.printStackTrace();
			}
		}
		if(paidFeeSummary == null){
			paidFeeSummary = new PaidFeeSummary();
			paidFeeSummary.setMonthlyFreq(paymentFormBean.getMonthIds());
			paidFeeSummary.setQuaterlyFreq(paymentFormBean.getQuarterlyIds());
			paidFeeSummary.setHalfyearlyFreq(paymentFormBean.getHalsyrlyIds());
			paidFeeSummary.setAnnuallyFreq(paymentFormBean.getAnuallyIds());
		}else{
			paidFeeSummary.setMonthlyFreq(paidFeeSummary.getMonthlyFreq()+paymentFormBean.getMonthIds());
			paidFeeSummary.setQuaterlyFreq(paidFeeSummary.getQuaterlyFreq()+paymentFormBean.getQuarterlyIds());
			paidFeeSummary.setHalfyearlyFreq(paidFeeSummary.getHalfyearlyFreq()+paymentFormBean.getHalsyrlyIds());
			paidFeeSummary.setAnnuallyFreq(paidFeeSummary.getAnnuallyFreq()+paymentFormBean.getAnuallyIds());
		}
		paidFeeSummary.setSessionName(SessionUtil.getCurrentSchoolSesseion());
		paidFeeSummary.setStudentId(paymentFormBean.getStudentId());
		paidFeeSummary.setUpdatedBy(userId);
		feeService.save(paidFeeSummary);
	}
	


	@RequestMapping(value = "/fee-reciept")
	public ModelAndView regReceipt(Model model,HttpServletRequest request) {
		SessionUtil.setPage(MSConstant.FEE);
		return new ModelAndView("fee-reciept");
	}
	
	/**
	 * @param feeFormBean
	 */
	public void populateFeeFormBean(FeeFormBean feeFormBean,String id) {
		List<FeeDTO> monthlyFeeList =  new ArrayList<>();
		List<FeeDTO> quarterlyFeeList =  new ArrayList<>();
		List<FeeDTO> halfyearlyFeeList =  new ArrayList<>();
		List<FeeDTO> anualFeeList =  new ArrayList<>();
		
		List<String> monthlyPaidFeeList =  new ArrayList<>();
		List<String> quarterlyPaidFeeList =  new ArrayList<>();
		List<String> halfYearlyPaidFeeList =  new ArrayList<>();
		List<String> anuallyPaidFeeList =  new ArrayList<>();
		
		
		Integer studentId = Integer.parseInt(id);
		feeFormBean.setStudentId(studentId);
		StudentInfo studentInfo = admissionService.findStudentById(studentId);
		try {
			PaidFeeSummary paidFeeSummary = feeService.findByStudentId(studentId);
			if(paidFeeSummary != null){
				feeFormBean.setFeeSummaryId(paidFeeSummary.getId());
				monthlyPaidFeeList = tokenizeList(paidFeeSummary.getMonthlyFreq());
				quarterlyPaidFeeList = tokenizeList(paidFeeSummary.getQuaterlyFreq());
				halfYearlyPaidFeeList =  tokenizeList(paidFeeSummary.getHalfyearlyFreq());
				anuallyPaidFeeList = tokenizeList(paidFeeSummary.getAnnuallyFreq());
			}
		} catch (MSException e) {
			e.printStackTrace();
		}
		if(studentInfo != null){
			List<FeeStructure> feeStructureList = feeService.findFeeForClassAndSession(studentInfo.getCurrentClass(),(byte)1);
			for (FeeStructure feeStructure : feeStructureList) {
				FeeDTO feeDTO = new FeeDTO();
				feeDTO.setId(feeStructure.getId());
				feeDTO.setName(feeStructure.getAbbrName());
				feeDTO.setAmount(feeStructure.getAmount());
				if(feeStructure.getFeeFreqType().byteValue() == FeeFreqType.MONTHLY.getCode()){
					monthlyFeeList.add(feeDTO);
				}
				else if(feeStructure.getFeeFreqType().byteValue() == FeeFreqType.QUARTERLY.getCode()){
					if(quarterlyPaidFeeList.contains(feeDTO.getId().toString())){
						feeDTO.setPaid(true);
					}
					quarterlyFeeList.add(feeDTO);
				}
				else if(feeStructure.getFeeFreqType().byteValue() == FeeFreqType.HALFYEARLY.getCode()){
					if(halfYearlyPaidFeeList.contains(feeDTO.getId().toString())){
						feeDTO.setPaid(true);
					}
					halfyearlyFeeList.add(feeDTO);
				}
				else if(feeStructure.getFeeFreqType().byteValue() == FeeFreqType.ANUALLY.getCode()){
					if(anuallyPaidFeeList.contains(feeDTO.getId().toString())){
						feeDTO.setPaid(true);
					}
					anualFeeList.add(feeDTO);
				}
			}
			feeFormBean.setMonthlyFeeList(monthlyFeeList);
			feeFormBean.setQuarterlyFeeList(quarterlyFeeList);
			feeFormBean.setHalfyearlyFeeList(halfyearlyFeeList);
			feeFormBean.setAnualFeeList(anualFeeList);
			List<Month> monthList = new ArrayList<>();
			for(Month month:MSUtil.populateMonthList()){
				if(!monthlyPaidFeeList.contains(month.getCode().toString()))
						monthList.add(month);
			}
			feeFormBean.setMonthList(monthList);
		}
		
	}

	/**
	 * @param quaterlyFreq
	 */
	private List<String> tokenizeList(String str) {
		List<String> retList = new ArrayList<>();
		StringTokenizer stringTokenizer = new StringTokenizer(str, MSConstant.COMMA);
		while (stringTokenizer.hasMoreElements()) {
			retList.add((String) stringTokenizer.nextElement());
			
		}
		return retList;
	}

	/**
	 * @param feeFormBean
	 */
	public FeeSummaryDTO saveFeeFormBean(FeeFormBean feeFormBean,Integer userId) {
		FeeSummaryDTO feeSummaryDTO = new FeeSummaryDTO();
		List<FeeSlip> feeSlipList = new ArrayList<>();
		StringBuilder monthIds =  new StringBuilder();
		StringBuilder quarterlyIds =  new StringBuilder();
		StringBuilder halsyrlyIds =  new StringBuilder();
		StringBuilder anuallyIds =  new StringBuilder();
		monthIds.append(feeFormBean.getSelMonth());
		monthIds.append(MSConstant.COMMA);
		if(feeFormBean.getMonthlyFeeList() != null){
			for(FeeDTO feeDTO:feeFormBean.getMonthlyFeeList()){
				if(!MSUtil.isEmpty(feeDTO.getPaidAmount())){
					FeeSlip feeSlip = new FeeSlip();
					feeSlip.setStudentId(feeFormBean.getStudentId());
					feeSlip.setFeeStructureId(feeDTO.getId());
					feeSlip.setMonth(feeFormBean.getSelMonth());
					feeSlip.setAmount(feeDTO.getPaidAmount());
					feeSlip.setDiscount(feeDTO.getDiscount());
					feeSlip.setCreatedBy(userId);
					feeSlipList.add(feeSlip);
				}
			}
		}
		if(feeFormBean.getQuarterlyFeeList() != null){
			for(FeeDTO feeDTO:feeFormBean.getQuarterlyFeeList()){
				if(!MSUtil.isEmpty(feeDTO.getPaidAmount())){
					FeeSlip feeSlip = new FeeSlip();
					feeSlip.setStudentId(feeFormBean.getStudentId());
					feeSlip.setFeeStructureId(feeDTO.getId());
					feeSlip.setMonth(feeFormBean.getSelMonth());
					feeSlip.setAmount(feeDTO.getPaidAmount());
					feeSlip.setDiscount(feeDTO.getDiscount());
					feeSlip.setCreatedBy(userId);
					feeSlipList.add(feeSlip);
					quarterlyIds.append(feeDTO.getId());
					quarterlyIds.append(MSConstant.COMMA);
				}
			}
		}
		if(feeFormBean.getHalfyearlyFeeList() != null){
			for(FeeDTO feeDTO:feeFormBean.getHalfyearlyFeeList()){
				if(!MSUtil.isEmpty(feeDTO.getPaidAmount())){
					FeeSlip feeSlip = new FeeSlip();
					feeSlip.setStudentId(feeFormBean.getStudentId());
					feeSlip.setFeeStructureId(feeDTO.getId());
					feeSlip.setMonth(feeFormBean.getSelMonth());
					feeSlip.setAmount(feeDTO.getPaidAmount());
					feeSlip.setDiscount(feeDTO.getDiscount());
					feeSlip.setCreatedBy(userId);
					feeSlipList.add(feeSlip);
					halsyrlyIds.append(feeDTO.getId());
					halsyrlyIds.append(MSConstant.COMMA);
				}
			}
		}
		if(feeFormBean.getAnualFeeList() != null){
			for(FeeDTO feeDTO:feeFormBean.getAnualFeeList()){
				if(!MSUtil.isEmpty(feeDTO.getPaidAmount())){
					FeeSlip feeSlip = new FeeSlip();
					feeSlip.setStudentId(feeFormBean.getStudentId());
					feeSlip.setFeeStructureId(feeDTO.getId());
					feeSlip.setMonth(feeFormBean.getSelMonth());
					feeSlip.setAmount(feeDTO.getPaidAmount());
					feeSlip.setDiscount(feeDTO.getDiscount());
					feeSlip.setCreatedBy(userId);
					feeSlipList.add(feeSlip);
					anuallyIds.append(feeDTO.getId());
					anuallyIds.append(MSConstant.COMMA);
				}
			}
		}
		
		for (FeeSlip feeSlip : feeSlipList) {
			 feeService.save(feeSlip);
		}
		feeSummaryDTO.setFeeSlipList(feeSlipList);
		feeSummaryDTO.setMonthIds(monthIds.toString());
		feeSummaryDTO.setQuarterlyIds(quarterlyIds.toString());
		feeSummaryDTO.setHalsyrlyIds(halsyrlyIds.toString());
		feeSummaryDTO.setAnuallyIds(anuallyIds.toString());
		return feeSummaryDTO;
	}

	/**
	 * @param paymentFormBean
	 */
	public void populatePaymentFormBean(PaymentFormBean paymentFormBean) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @param paymentFormBean
	 */
	private Integer saveFeePaymentFormBean(PaymentFormBean paymentFormBean) {
		Payment payment = new Payment();
		payment.setStudentId(paymentFormBean.getStudentId());
		payment.setAmount(paymentFormBean.getAmount());
		payment.setFeeType(FeeType.REGFEES.getCode());
		paymentService.save(payment);
		return payment.getId();
		
	}
	
	/**
	 * @param paymentId
	 * @param string 
	 */
	private void updateFeeSlipWithPayment(Integer paymentId, String ids) {
		try {
			if(!MSUtil.isEmpty(ids) && ids.length()>1){
				ids = ids.substring(0, ids.length()-1);
			}
			List<FeeSlip> feeSlips = feeService.findFeeSlips(ids);
			for (FeeSlip feeSlip : feeSlips) {
				feeSlip.setPaymentId(paymentId);
				feeService.save(feeSlip);
			}
		} catch (MSException e) {
			e.printStackTrace();
		}
		
	}
}
