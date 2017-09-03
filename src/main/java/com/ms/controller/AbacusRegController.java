package com.ms.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ms.bean.AbacusRegBean;
import com.ms.bean.RegistrationFormBean;
import com.ms.service.AbacusRegService;
import com.ms.util.MSConstant;
import com.ms.util.SessionUtil;

@Controller
@Scope("request")
public class AbacusRegController {

	@Autowired
	AbacusRegService abacusRegService;
	@RequestMapping(value = "/abacusreg", method = { RequestMethod.POST, RequestMethod.GET })  
	    public ModelAndView abacusreg(@ModelAttribute("abacusreg") AbacusRegBean abacusRegBean, BindingResult bindingResult, Model model,HttpServletRequest request) {  
		SessionUtil.setPage(MSConstant.REGISTRATION);
		if (request.getMethod().equalsIgnoreCase(RequestMethod.GET.name())) {
			/*populateRegistrationFormBean(abacusRegBean);*/
			return new ModelAndView("abacusreg", "registrationFormBean", abacusRegBean);
		}else{
			try {
				Integer id = saveAbacusRegBean(abacusRegBean);
				
				return new ModelAndView("redirect:/reg-payment.do?id="+id);
			} catch (Exception e) {
				e.printStackTrace();
				return new ModelAndView("abacusreg", "registrationFormBean", abacusRegBean);
			}
			
		}
		
		
		
	        
	    }
	private Integer saveAbacusRegBean(AbacusRegBean abacusRegBean) {
		// TODO Auto-generated method stub
		return null;
	} 


}
