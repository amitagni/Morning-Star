/*******************************************************************************
* Copyright (c) 2016 PWC Corporation and others.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the PWC License v1.0
*
* Contributors:
* PWC - initial API and implementation
*******************************************************************************/
package com.ms.controller;

import java.util.List;
import java.util.Map;

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

import com.ms.bean.ReportBean;
import com.ms.dto.StudentFeeReportDTO;
import com.ms.service.ReportService;


/**
 * @author Amit Agnihotri
 *
 */
@Controller
@Scope("request")
public class ReportController {

	@Autowired
	private ReportService reportService;


	
	
	@RequestMapping(value = "/report", method = {RequestMethod.GET })
	public ModelAndView loginPage(@ModelAttribute("reportBean") @Validated ReportBean reportBean, BindingResult bindingResult, Model model,HttpServletRequest request) {
		List<Object> objectList = reportService.fetchAllStudentFeeReport();
		if(objectList != null){
			reportBean.setStudentDtoList((List<StudentFeeReportDTO>) objectList.get(0));
			reportBean.setTotalPaidAmount((String) objectList.get(1));
			reportBean.setTotalDiscAmount((String) objectList.get(2));
		}
		return new ModelAndView("report", "reportBean", reportBean);
	}
	
	
}
