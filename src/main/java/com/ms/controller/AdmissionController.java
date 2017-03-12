
package com.ms.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ms.bean.Login;

/**
 * @author Amit Agnihotri
 *
 */
@Controller
@Scope("request")
public class AdmissionController {



	
	/**
	 * @param login
	 * @param bindingResult
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/admission", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView loginPage(@ModelAttribute("login") @Validated Login login, BindingResult bindingResult, Model model,HttpServletRequest request) {
		if (request.getMethod().equalsIgnoreCase(RequestMethod.GET.name())) {
			login = new Login();
			System.out.println();
			return new ModelAndView("login", "login", login);
		}else{
			login = new Login();
			return new ModelAndView("login", "login", login);
		}
	}

}
