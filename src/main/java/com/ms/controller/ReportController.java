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
import com.ms.enums.ReportType;
import com.ms.enums.StudentClass;
import com.ms.service.ReportService;
import com.ms.util.MSUtil;


/**
 * @author Amit Agnihotri
 *
 */
@Controller
@Scope("request")
public class ReportController {

	@Autowired
	private ReportService reportService;


	
	
	@RequestMapping(value = "/report", method = {RequestMethod.POST, RequestMethod.GET  })
	public ModelAndView report(@ModelAttribute("reportBean") @Validated ReportBean reportBean, BindingResult bindingResult, Model model,HttpServletRequest request) {
		if (request.getMethod().equalsIgnoreCase(RequestMethod.GET.name())) {
			reportBean.setReportType(ReportType.STUDENT.getCode().byteValue());
		}else{
			List<Object> objectList = null;
			if(reportBean.getReportType().byteValue() == ReportType.CLASSWISE.getCode().byteValue()){
				reportBean.setReportType(ReportType.STUDENT.getCode().byteValue());
				if(reportBean.getSelClass().byteValue() == -1)
					objectList = reportService.fetchAllStudentFeeReport();
				else
				 objectList = reportService.fetchAllStudentFeeReport(String.valueOf(reportBean.getCurrentClass()));
			}else if(reportBean.getReportType().byteValue() == ReportType.STUDENT.getCode().byteValue()){
			  objectList = reportService.fetchStudentFeeReport(String.valueOf(reportBean.getStudentId()));
			  reportBean.setReportType(ReportType.STUDENT.getCode().byteValue());
			}
			
			if(objectList != null){
				reportBean.setStudentDtoList((List<StudentFeeReportDTO>) objectList.get(0));
				reportBean.setTotalPaidAmount((String) objectList.get(1));
				reportBean.setTotalDiscAmount((String) objectList.get(2));
			}
			
		}
		reportBean.setStudentClassList(MSUtil.populateClassList());
		return new ModelAndView("report", "reportBean", reportBean);
	}
	
	
}
