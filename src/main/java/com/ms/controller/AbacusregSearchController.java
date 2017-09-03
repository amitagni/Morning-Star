package com.ms.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Scope("request")
public class AbacusregSearchController {

	@RequestMapping(value = "/abacussearch", method = { RequestMethod.POST, RequestMethod.GET })  
    public ModelAndView abacussearch() {  
        
        return new ModelAndView("abacussearch");  
    }
}
