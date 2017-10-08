package com.ms.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ms.bean.AccountBean;
import com.ms.bean.DayBookBean;
import com.ms.bean.LedgerBean;
import com.ms.dto.AccountDTO;
import com.ms.dto.DayBookDTO;
import com.ms.entity.Account;
import com.ms.entity.DayBook;
import com.ms.enums.TransactionType;
import com.ms.service.DayBookService;
import com.ms.util.MSConstant;
import com.ms.util.MSException;
import com.ms.util.SessionUtil;

@Controller
@Scope("request")
public class DaybookController {

	@Autowired
	private DayBookService dayBookService;

	@RequestMapping(value = "/daybook", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView daybook(@ModelAttribute("dayBookBean") DayBookBean dayBookBean, BindingResult bindingResult, Model model, HttpServletRequest request) {
		SessionUtil.setPage(MSConstant.DAYBOOK);
		if (request.getMethod().equalsIgnoreCase(RequestMethod.GET.name())) {
			dayBookBean.setAccountList(populateAccopuntList());
			dayBookBean.setUserAction(MSConstant.DAYBOOK_ACTION);
			//dayBookBean.setDayBookDTOList(populateCurrentDateDaybook());
			return new ModelAndView("daybook", "dayBookBean", dayBookBean);
		} else {
			try {
				if (dayBookBean.getUserAction().equals(MSConstant.ACCOUNT_ACTION)) {
					saveAccount(dayBookBean.getAccountBean());
					return new ModelAndView("redirect:/daybook.do");
				} else if (dayBookBean.getUserAction().equals(MSConstant.DAYBOOK_ACTION)) {
				    saveDayBook(dayBookBean);
				    
					return new ModelAndView("redirect:/daybook.do");
				}
				return new ModelAndView("redirect:/daybook.do");
			} catch (Exception e) {
				e.printStackTrace();
				return new ModelAndView("daybook", "dayBookBean", dayBookBean);
			}

		}
	}
	
	
	@RequestMapping(value = "/ledger", method = { RequestMethod.POST,RequestMethod.GET })
	public ModelAndView ledger(@ModelAttribute("ledgerBean") LedgerBean ledgerBean, BindingResult bindingResult, Model model, HttpServletRequest request) {
		SessionUtil.setPage(MSConstant.LEDGER);
		if (request.getMethod().equalsIgnoreCase(RequestMethod.GET.name())) {
			return new ModelAndView("ledger", "ledgerBean", ledgerBean);
		}else{
			return new ModelAndView("ledger", "ledgerBean", ledgerBean);
		}
	}
	
	/**
	 * @return
	 */
	private List<AccountDTO> populateAccopuntList() {
		List<Account> accounts  = dayBookService.findAllAccounts();
		List<AccountDTO> accountDTOList = new ArrayList<>();
		if(accounts != null){
			for (Account account : accounts) {
				AccountDTO accountDTO = new AccountDTO();
				accountDTO.setId(account.getId());
				accountDTO.setAccountName(account.getAccountName());
				accountDTOList.add(accountDTO);
			}
		}
		return accountDTOList;
	}

	@RequestMapping(value = "/delete-dBookEntry")
	public @ResponseBody boolean deleteDayBookEntry(HttpServletRequest request) {
		String id = request.getParameter("daybookId");
        return  dayBookService.deletDayBookEntry(Integer.parseInt(id));
	}
	
	/**
	 * 
	 */
	private List<DayBookDTO> populateCurrentDateDaybook() {
		Date date = new Date(System.currentTimeMillis());
		List<DayBook> dayBookEntries = dayBookService.findDayBookEntryByDate(date);
		
		List<DayBookDTO> dtoList = new ArrayList<>();
		if(dayBookEntries != null){
			for(DayBook dayBook:dayBookEntries){
				DayBookDTO dayBookDTO = new DayBookDTO();
				dayBookDTO.setId(dayBook.getId().toString());
				dayBookDTO.setAccountName(""+dayBook.getAccountId());
				dayBookDTO.setTransactionType(TransactionType.findNameByCode(dayBook.getTransactionType()));
				dayBookDTO.setAmount(dayBook.getAmount());
				dayBookDTO.setComment(dayBook.getComments());
				dtoList.add(dayBookDTO);
			}
		}
		return dtoList;
	}


	@RequestMapping(value = "/fetch-accountlist")
	public @ResponseBody List<AccountDTO> getStudentsList(HttpServletRequest request) {
		String accountName = request.getParameter("accoutName");
        List<AccountDTO> accountDTOList =  new ArrayList<AccountDTO>();
        List<Account> accountList = dayBookService.findAccountsByName(accountName);
        if(accountList != null){
        	for (Account account : accountList) {
        		AccountDTO accountDTO = new AccountDTO();	
        		accountDTO.setId(account.getId());
        		accountDTO.setAccountName(account.getAccountName());
        		accountList.add(account);
			}
        }
		return accountDTOList;
	}
	

	public void populateRegistrationFormBean(DayBookBean dayBookBean) {
		/*
		 * dayBookBean.setAccountName(accountName);
		 * dayBookBean.setTransactionType();
		 */

	}

	private Integer saveDayBook(DayBookBean dayBookBean) throws MSException {
		DayBook dayBook = populateDayBookInfo(dayBookBean);
		dayBookService.save(dayBook);
		return dayBook.getId();
	}

	private Integer saveAccount(AccountBean accountBean) throws MSException {
		Account account = new Account();
		account.setAccountName(accountBean.getName());
		account.setDescription(accountBean.getDescription());
		dayBookService.save(account);
		return account.getId();
	}

	public DayBook populateDayBookInfo(DayBookBean dayBookBean) {
		DayBook dayBookEntity = new DayBook();
		dayBookEntity.setTransactionType(dayBookBean.getTransactionType());
		dayBookEntity.setAccountId(dayBookBean.getAccountBean().getId());
		dayBookEntity.setPaymentType(dayBookBean.getPaymentType());
		dayBookEntity.setChequeEpayNo(dayBookBean.getChequeEpayNo());
		dayBookEntity.setAmount(dayBookBean.getAmount());
		dayBookEntity.setComments(dayBookBean.getComments());
		dayBookEntity.setActive((byte) 1);
		return dayBookEntity;
	}

}
