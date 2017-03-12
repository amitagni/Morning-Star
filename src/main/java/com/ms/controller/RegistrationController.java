
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

import com.ms.bean.RegistrationFormBean;
import com.ms.service.RegistrationService;

/**
 * @author Amit Agnihotri
 *
 */
@Controller
@Scope("request")
public class RegistrationController {

	@Autowired
	 private RegistrationService registrationService;

	
	/**
	 * @param login
	 * @param bindingResult
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/registration", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView loginPage(@ModelAttribute("login") RegistrationFormBean registrationFormBean, BindingResult bindingResult, Model model,HttpServletRequest request) {
		if (request.getMethod().equalsIgnoreCase(RequestMethod.GET.name())) {
			registrationService.populateRegistrationFormBean(registrationFormBean);
			return new ModelAndView("registration", "registrationFormBean", registrationFormBean);
		}else{
			registrationService.saveRegistrationFormBean(registrationFormBean);
			return new ModelAndView("registration", "registrationFormBean", registrationFormBean);
		}
	}

}
