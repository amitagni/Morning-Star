package com.ms.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ms.bean.DayBookBean;
import com.ms.bean.FeeFormBean;
import com.ms.dto.FeeSummaryDTO;
import com.ms.entity.FeeSlip;
import com.ms.util.MSConstant;
import com.ms.util.SessionUtil;

@Controller
@Scope("request")
public class DaybookController {

	
	
	@RequestMapping(value = "/day-book", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView fee(@ModelAttribute("dayBookBean") DayBookBean dayBookBean, BindingResult bindingResult, Model model,HttpServletRequest request) {
		SessionUtil.setPage(MSConstant.DAYBOOK);
		if (request.getMethod().equalsIgnoreCase(RequestMethod.GET.name())) {
			
			
			
			
			return new ModelAndView("daybook", "dayBookBean", dayBookBean);
		}else{
			
				return new ModelAndView("daybook", "dayBookBean", dayBookBean);
			}
			
		}
	}

	
