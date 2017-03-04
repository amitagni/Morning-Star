/*******************************************************************************
* Copyright (c) 2016 PWC Corporation and others.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the PWC License v1.0
*
* Contributors:
* PWC - initial API and implementation
*******************************************************************************/
package com.ms.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ms.bean.Login;

/**
 * @author Manu
 *
 */
@Controller
@Scope("request")
public class LoginController {



	/*@Autowired
	@Qualifier("loginValidator")
	private Validator validator;*/

	
	/**
	 * @param binder
	 */
	/*@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}
*/
	/**
	 * @param request
	 * @param response
	 * @throws IOException
	 */

	/**
	 * @return
	 */
	@RequestMapping("/login")
	public ModelAndView loginPage() {
		Login login = new Login();
		return new ModelAndView("login", "login", login);
	}

	

}
