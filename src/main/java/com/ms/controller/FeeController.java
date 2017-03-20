/**
 * 
 */
package com.ms.controller;

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

import com.ms.bean.FeeFormBean;
import com.ms.bean.PaymentFormBean;
import com.ms.dto.FeeDTO;
import com.ms.entity.FeeSlip;
import com.ms.entity.FeeStructure;
import com.ms.enums.FeeFreqType;
import com.ms.service.FeeService;
import com.ms.util.MSUtil;

@Controller
@Scope("request")
public class FeeController {
	
	@Autowired
	private FeeService feeService;
	
	@RequestMapping(value = "/fee", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView fee(@ModelAttribute("feeFormBean") FeeFormBean feeFormBean, BindingResult bindingResult, Model model,HttpServletRequest request) {
		if (request.getMethod().equalsIgnoreCase(RequestMethod.GET.name())) {
			populateFeeFormBean(feeFormBean);
			return new ModelAndView("fee", "feeFormBean", feeFormBean);
		}else{
			try {
				saveFeeFormBean(feeFormBean);
				return new ModelAndView("redirect:/fee-payment.do");
			} catch (Exception e) {
				e.printStackTrace();
				return new ModelAndView("fee", "feeFormBean", feeFormBean);
			}
			
		}
	}
	
	@RequestMapping(value = "/fee-payment", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView feePayment(@ModelAttribute("paymentFormBean") PaymentFormBean paymentFormBean, BindingResult bindingResult, Model model,HttpServletRequest request) {
		if (request.getMethod().equalsIgnoreCase(RequestMethod.GET.name())) {
			populatePaymentFormBean(paymentFormBean);
			return new ModelAndView("fee-payment", "paymentFormBean", paymentFormBean);
		}else{
			try {
				saveFeePaymentFormBean(paymentFormBean);
				return new ModelAndView("redirect:/fee-reciept.do");
			} catch (Exception e) {
				e.printStackTrace();
				return new ModelAndView("fee-payment", "paymentFormBean", paymentFormBean);
			}
			
		}
	}
	
	@RequestMapping(value = "/fee-reciept")
	public ModelAndView regReceipt(Model model,HttpServletRequest request) {
		return new ModelAndView("fee-reciept");
	}
	
	/**
	 * @param feeFormBean
	 */
	public void populateFeeFormBean(FeeFormBean feeFormBean) {
		List<FeeDTO> monthlyFeeList =  new ArrayList<>();
		List<FeeDTO> quarterlyFeeList =  new ArrayList<>();
		List<FeeDTO> halfyearlyFeeList =  new ArrayList<>();
		List<FeeDTO> anualFeeList =  new ArrayList<>();
		List<FeeStructure> feeStructureList = feeService.findFeeForClassAndSession((byte)2,(byte) 1);
		for (FeeStructure feeStructure : feeStructureList) {
			FeeDTO feeDTO = new FeeDTO();
			feeDTO.setId(feeStructure.getId());
			feeDTO.setName(feeStructure.getAbbrName());
			feeDTO.setAmount(feeStructure.getAmount());
			if(feeStructure.getFeeFreqType().byteValue() == FeeFreqType.MONTHLY.getCode())
				monthlyFeeList.add(feeDTO);
			else if(feeStructure.getFeeFreqType().byteValue() == FeeFreqType.QUARTERLY.getCode())
				quarterlyFeeList.add(feeDTO);
			else if(feeStructure.getFeeFreqType().byteValue() == FeeFreqType.HALFYEARLY.getCode())
				halfyearlyFeeList.add(feeDTO);
			else if(feeStructure.getFeeFreqType().byteValue() == FeeFreqType.ANUALLY.getCode())
				anualFeeList.add(feeDTO);
		}
		feeFormBean.setMonthlyFeeList(monthlyFeeList);
		feeFormBean.setQuarterlyFeeList(quarterlyFeeList);
		feeFormBean.setHalfyearlyFeeList(halfyearlyFeeList);
		feeFormBean.setAnualFeeList(anualFeeList);
		feeFormBean.setMonthList(MSUtil.populateMonthList());
	}

	/**
	 * @param feeFormBean
	 */
	public void saveFeeFormBean(FeeFormBean feeFormBean) {
		List<FeeSlip> feeSlipList = new ArrayList<>();
		for(FeeDTO feeDTO:feeFormBean.getMonthlyFeeList()){
			FeeSlip feeSlip = new FeeSlip();
			feeSlip.setStudentId(1);
			feeSlip.setFeeStructureId(feeDTO.getId());
			feeSlip.setMonth(feeFormBean.getSelMonth());
			feeSlip.setAmount(feeDTO.getPaidAmount());
			feeSlip.setDiscount(feeDTO.getDiscount());
			feeSlipList.add(feeSlip);
		}
		for(FeeDTO feeDTO:feeFormBean.getQuarterlyFeeList()){
			FeeSlip feeSlip = new FeeSlip();
			feeSlip.setStudentId(1);
			feeSlip.setFeeStructureId(feeDTO.getId());
			feeSlip.setMonth(feeFormBean.getSelMonth());
			feeSlip.setAmount(feeDTO.getPaidAmount());
			feeSlip.setDiscount(feeDTO.getDiscount());
			feeSlipList.add(feeSlip);
		}
		for(FeeDTO feeDTO:feeFormBean.getHalfyearlyFeeList()){
			FeeSlip feeSlip = new FeeSlip();
			feeSlip.setStudentId(1);
			feeSlip.setFeeStructureId(feeDTO.getId());
			feeSlip.setMonth(feeFormBean.getSelMonth());
			feeSlip.setAmount(feeDTO.getPaidAmount());
			feeSlip.setDiscount(feeDTO.getDiscount());
			feeSlipList.add(feeSlip);
		}
		for(FeeDTO feeDTO:feeFormBean.getAnualFeeList()){
			FeeSlip feeSlip = new FeeSlip();
			feeSlip.setStudentId(1);
			feeSlip.setFeeStructureId(feeDTO.getId());
			feeSlip.setMonth(feeFormBean.getSelMonth());
			feeSlip.setAmount(feeDTO.getPaidAmount());
			feeSlip.setDiscount(feeDTO.getDiscount());
			feeSlipList.add(feeSlip);
		}
		
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
	public void saveFeePaymentFormBean(PaymentFormBean paymentFormBean) {
		// TODO Auto-generated method stub
		
	}

}
