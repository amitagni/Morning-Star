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

import com.ms.bean.AbacusRegBean;
import com.ms.bean.AbacusSearchBean;
import com.ms.entity.AbacusRegEntity;
import com.ms.service.AbacusRegService;
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
		SessionUtil.setPage(MSConstant.REGISTRATION);
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
		try {
			AbacusRegEntity abacusRegEntity = abacusRegService.findId(Integer.parseInt(id));
			if(abacusRegEntity != null){
				abacusSearchBean.setName(abacusRegEntity.getFirstName()+" "+abacusRegEntity.getLastName());
				abacusSearchBean.setId(abacusRegEntity.getId());
				abacusSearchBean.setFatherName(abacusRegEntity.getFatherName());
			}
			return new ModelAndView("abacus-search", "abacusSearchBean", abacusSearchBean);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (MSException e) {
			e.printStackTrace();
		}
		return new ModelAndView("abacus-search");  
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
	}

}
