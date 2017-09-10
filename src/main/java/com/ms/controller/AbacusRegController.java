package com.ms.controller;

import java.util.ArrayList;
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

import com.ms.bean.AbacusRegBean;
import com.ms.bean.AbacusSearchBean;
import com.ms.dto.AbacusReceiptDTO;
import com.ms.dto.FeeMonthsDTO;
import com.ms.entity.AbacusFee;
import com.ms.entity.AbacusRegEntity;
import com.ms.enums.Month;
import com.ms.service.AbacusRegService;
import com.ms.util.DateUtils;
import com.ms.util.MSConstant;
import com.ms.util.MSException;
import com.ms.util.MSUtil;
import com.ms.util.SessionUtil;

@Controller
@Scope("request")
public class AbacusRegController {

	@Autowired
	AbacusRegService abacusRegService;
	
	@RequestMapping(value = "/abacusreg", method = { RequestMethod.POST, RequestMethod.GET })  
	public ModelAndView abacusreg(@ModelAttribute("abacusRegBean") AbacusRegBean abacusRegBean, BindingResult bindingResult, Model model, HttpServletRequest request) {
		SessionUtil.setPage(MSConstant.ABACUS);
		if (request.getMethod().equalsIgnoreCase(RequestMethod.GET.name())) {
			populateAbacusRegFormBean(abacusRegBean);
			return new ModelAndView("abacusreg", "abacusRegBean", abacusRegBean);
		} else {
			try {
				Integer id = saveAbacusRegBean(abacusRegBean);
				return new ModelAndView("redirect:/abacus-search.do?id=" + id);
			} catch (Exception e) {
				e.printStackTrace();
				return new ModelAndView("abacusreg", "abacusRegBean", abacusRegBean);
			}

		}
	}
	
	@RequestMapping(value = "/abacus-search", method = { RequestMethod.POST, RequestMethod.GET })  
    public ModelAndView abacussearch(@ModelAttribute("abacusSearchBean") AbacusSearchBean abacusSearchBean, BindingResult bindingResult, Model model, HttpServletRequest request) {  
		String id = request.getParameter("id");
		List<String> monthlyPaidFeeList = new ArrayList<>();
		try {
			if(id != null){
				AbacusRegEntity abacusRegEntity = abacusRegService.findId(Integer.parseInt(id));
				List<AbacusFee> abacusFeeList = abacusRegService.findByStudentId(Integer.parseInt(id));
				
				if(abacusRegEntity != null){
					abacusSearchBean.setName(abacusRegEntity.getFirstName()+" "+abacusRegEntity.getLastName());
					abacusSearchBean.setId(abacusRegEntity.getId());
					abacusSearchBean.setFatherName(abacusRegEntity.getFatherName());
				}
				
				if(abacusFeeList != null && abacusFeeList.size()>0 ){
					abacusSearchBean.setRegFee((byte) 0);
					abacusSearchBean.setTotalAmt(0);
					for (AbacusFee abacusFee : abacusFeeList) {
						monthlyPaidFeeList.addAll(MSUtil.tokenizeList(abacusFee.getMonths()));
					}
				}else{
					
					abacusSearchBean.setTotalAmt(1000);
					abacusSearchBean.setRegFee((byte) 1);
				}
			}
			
			List<FeeMonthsDTO> monthList = new ArrayList<>();
			for(Month month:MSUtil.populateMonthList()){
				FeeMonthsDTO feeMonthsDTO = new FeeMonthsDTO();
				feeMonthsDTO.setCode(month.getCode());
				feeMonthsDTO.setName(month.getName());
				if(monthlyPaidFeeList.contains(month.getCode().toString())){
					feeMonthsDTO.setPaid(true);
					feeMonthsDTO.setName(month.getName() + "  --  PAID");
				}
				monthList.add(feeMonthsDTO);
			}
			
			abacusSearchBean.setMonthList(monthList);
			return new ModelAndView("abacus-search", "abacusSearchBean", abacusSearchBean);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (MSException e) {
			e.printStackTrace();
		}
		return new ModelAndView("abacus-search");  
    }
	
	
	@RequestMapping(value = "/abacus-fee.do", method = { RequestMethod.POST , RequestMethod.GET })  
	public ModelAndView abacusFee(@ModelAttribute("abacusSearchBean") AbacusSearchBean abacusSearchBean, BindingResult bindingResult, Model model, HttpServletRequest request) {
		SessionUtil.setPage(MSConstant.ABACUS);
		Integer id = null;
		try {
		    id = saveAbacusFee(abacusSearchBean);
			return new ModelAndView("redirect:/abacus-reciept.do?id="+id+"&studentId="+abacusSearchBean.getId());
		} catch (Exception e) {
			e.printStackTrace();
			return new ModelAndView("redirect:/abacus-reciept.do?id="+id+"&studentId="+abacusSearchBean.getId());
		}

	}
	
	

	@RequestMapping(value = "/abacus-reciept.do", method = { RequestMethod.POST, RequestMethod.GET  })  
	public ModelAndView abacusReceipt(@ModelAttribute("AbacusReceiptDTO") AbacusReceiptDTO abacusReceiptDTO, BindingResult bindingResult, Model model, HttpServletRequest request) {
		SessionUtil.setPage(MSConstant.ABACUS);
		try {
			String id = request.getParameter("id");
			String studentId = request.getParameter("studentId");
			fetchRecieptData(id,studentId,abacusReceiptDTO);
			//Integer id = saveAbacusRegBean(abacusRegBean);
			return new ModelAndView("abacus-reciept", "abacusReceiptDTO", abacusReceiptDTO);
		} catch (Exception e) {
			e.printStackTrace();
			return new ModelAndView("abacus-reciept", "abacusReceiptDTO", abacusReceiptDTO);
		}

	}
	
	/**
	 * 
	 */
	private AbacusReceiptDTO fetchRecieptData(String id,String studentId,AbacusReceiptDTO abacusReceiptDTO) {
		try {
			AbacusFee  abacusFee = abacusRegService.findFeeById(Integer.parseInt(id));
			AbacusRegEntity abacusRegEntity = abacusRegService.findId(Integer.parseInt(studentId));
			abacusReceiptDTO.setRecieptId(""+abacusFee.getId());
			abacusReceiptDTO.setName(abacusRegEntity.getFirstName() + " "+ abacusRegEntity.getLastName() );
			abacusReceiptDTO.setFatherName(abacusRegEntity.getFatherName());
			abacusReceiptDTO.setDate(DateUtils.convertToStringObject(abacusFee.getCreatedAt(), "MM/dd/yyyy"));
			List<String> monthList = MSUtil.tokenizeList(abacusFee.getMonths());
			StringBuilder months = new StringBuilder();
			for (String month : monthList) {
				months.append(Month.findNameByCode(Byte.parseByte(month)));
				months.append(',');
			}
			abacusReceiptDTO.setMonths(months.substring(0, months.length()-1));
			if(abacusFee.getRegfee() == 1){
				abacusReceiptDTO.setRegAmount("1000");
				abacusReceiptDTO.setAmount(String.valueOf(Integer.parseInt(abacusFee.getAmount())- 1000));
			}else{
				abacusReceiptDTO.setAmount(abacusFee.getAmount());
			}
			abacusReceiptDTO.setTotalAmount(abacusFee.getAmount());
		} catch (MSException e) {
			e.printStackTrace();
		}
		return abacusReceiptDTO;
	}

	/**
	 * @param abacusSearchBean
	 * @return
	 */
	private Integer saveAbacusFee(AbacusSearchBean abacusSearchBean) {
			AbacusFee abacusFee = new AbacusFee();
			abacusFee.setStudentId(abacusSearchBean.getId());
			abacusFee.setAmount(abacusSearchBean.getTotalAmt().toString());
			abacusFee.setMonths(abacusSearchBean.getSelMonth());
			abacusFee.setStatus((byte)1);
			abacusFee.setRegfee(abacusSearchBean.getRegFee());
			try {
				abacusRegService.saveAbacusFee(abacusFee);
			} catch (MSException e) {
				e.printStackTrace();
			}
		return abacusFee.getId();
	}
	
	private Integer saveAbacusRegBean(AbacusRegBean abacusRegBean) {
		AbacusRegEntity abacusRegEntity = new AbacusRegEntity();
		abacusRegEntity.setFirstName(abacusRegBean.getFirstName());
		abacusRegEntity.setLastName(abacusRegBean.getLastName());
		abacusRegEntity.setNickName(abacusRegBean.getNickName());
		abacusRegEntity.setDateOfBirth(abacusRegBean.getDateOfBirth());
		abacusRegEntity.setFatherName(abacusRegBean.getFatherName());
		abacusRegEntity.setMotherName(abacusRegBean.getMotherName());
		abacusRegEntity.setSchoolName(abacusRegBean.getSchoolname());
		abacusRegEntity.setGender(abacusRegBean.getGender());
		abacusRegEntity.setAddress1(abacusRegBean.getAddress1());
		abacusRegEntity.setAddress2(abacusRegBean.getAddress2());
		abacusRegEntity.setArea(abacusRegBean.getArea());
		abacusRegEntity.setCity(abacusRegBean.getCity());
		abacusRegEntity.setState(abacusRegBean.getCity());
		try {
			abacusRegService.saveAbacusRegBean(abacusRegEntity);
			return abacusRegEntity.getId();
		} catch (MSException e) {
			e.printStackTrace();
		}
		return null;
	} 

	public void populateAbacusRegFormBean(AbacusRegBean abacusRegBean) {
		abacusRegBean.setStateList(MSUtil.populateStateList());
		abacusRegBean.setStudentClassList(MSUtil.populateClassList());
	}

}
