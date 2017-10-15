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

import com.ms.bean.AccountBean;
import com.ms.bean.FeeFormBean;
import com.ms.bean.InventoryCateoryBean;
import com.ms.dto.FeeSummaryDTO;
import com.ms.entity.Account;
import com.ms.entity.FeeSlip;
import com.ms.util.MSConstant;
import com.ms.util.MSException;
import com.ms.util.SessionUtil;

@Controller
@Scope("request")
public class inventoryCategoryController {
	
	
	@RequestMapping(value = "/inventoryCategory", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView inventoryCategoryController(@ModelAttribute("feeFormBean") InventoryCateoryBean inventoryCateoryBean, BindingResult bindingResult, Model model,HttpServletRequest request) {
		SessionUtil.setPage(MSConstant.INVENTORY);
	if (request.getMethod().equalsIgnoreCase(RequestMethod.GET.name())) {
			/*String studentId =  request.getParameter(MSConstant.ID);
			populateFeeFormBean(feeFormBean,studentId);*/
			return new ModelAndView("inventoryCategory", "inventoryCateoryBean", inventoryCateoryBean);
		}else{
			
			
				return new ModelAndView("inventoryCategory", "inventoryCateoryBean", inventoryCateoryBean);
			
	
	}
	}
	
	/*private Integer saveAccount(InventoryCateoryBean inventoryCateoryBean) throws MSException {
		Account account = new Account();
		account.setAccountName(accountBean.getName());
		account.setDescription(accountBean.getDescription());
		dayBookService.save(account);
		return 	"asd";
	}*/
	
}