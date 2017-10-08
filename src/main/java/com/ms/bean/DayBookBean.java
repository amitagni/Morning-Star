package com.ms.bean;

import java.util.List;

import com.ms.dto.AccountDTO;
import com.ms.dto.DayBookDTO;

/**
 * @author Jyotsna
 *
 */
public class DayBookBean extends FormBean {

	private Integer id;
	private String userAction;
	private Byte transactionType;
	private Byte paymentType;
	private String chequeEpayNo;
	private String amount;
	private String comments;
	private List<AccountDTO> accountList;
	private AccountBean accountBean;
	private List<DayBookDTO> dayBookDTOList;
	
	
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	
	
	/**
	 * @return the comments
	 */
	public String getComments() {
		return comments;
	}
	/**
	 * @param comments the comments to set
	 */
	public void setComments(String comments) {
		this.comments = comments;
	}
	/**
	 * @return the userAction
	 */
	public String getUserAction() {
		return userAction;
	}
	/**
	 * @param userAction the userAction to set
	 */
	public void setUserAction(String userAction) {
		this.userAction = userAction;
	}
	/**
	 * @return the accountBean
	 */
	public AccountBean getAccountBean() {
		return accountBean;
	}
	/**
	 * @param accountBean the accountBean to set
	 */
	public void setAccountBean(AccountBean accountBean) {
		this.accountBean = accountBean;
	}
	/**
	 * @return the transactionType
	 */
	public Byte getTransactionType() {
		return transactionType;
	}
	/**
	 * @param transactionType the transactionType to set
	 */
	public void setTransactionType(Byte transactionType) {
		this.transactionType = transactionType;
	}
	/**
	 * @return the paymentType
	 */
	public Byte getPaymentType() {
		return paymentType;
	}
	/**
	 * @param paymentType the paymentType to set
	 */
	public void setPaymentType(Byte paymentType) {
		this.paymentType = paymentType;
	}
	/**
	 * @return the chequeEpayNo
	 */
	public String getChequeEpayNo() {
		return chequeEpayNo;
	}
	/**
	 * @param chequeEpayNo the chequeEpayNo to set
	 */
	public void setChequeEpayNo(String chequeEpayNo) {
		this.chequeEpayNo = chequeEpayNo;
	}
	/**
	 * @return the amount
	 */
	public String getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(String amount) {
		this.amount = amount;
	}
	/**
	 * @return the dayBookDTOList
	 */
	public List<DayBookDTO> getDayBookDTOList() {
		return dayBookDTOList;
	}
	/**
	 * @param dayBookDTOList the dayBookDTOList to set
	 */
	public void setDayBookDTOList(List<DayBookDTO> dayBookDTOList) {
		this.dayBookDTOList = dayBookDTOList;
	}
	/**
	 * @return the accountList
	 */
	public List<AccountDTO> getAccountList() {
		return accountList;
	}
	/**
	 * @param accountList the accountList to set
	 */
	public void setAccountList(List<AccountDTO> accountList) {
		this.accountList = accountList;
	}
	
	
	
}
