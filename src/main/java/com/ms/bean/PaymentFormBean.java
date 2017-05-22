/**
 * 
 */
package com.ms.bean;

/**
 * @author Amit.Agnihotri
 *
 */
public class PaymentFormBean extends FormBean{
	
	private Integer paymentId;
	
	private String feeSlipIds;
	private Integer studentId;
	private String amount;
	private String disAmount;
	private Byte paymentType;
	private String chkDDNo;
	private String bankName;
	private String issueDate;
	private String challanNum;
	private String depositDate;
	private String comment;
	
	private Integer feeSummaryId ;
	private String monthIds ;
	private String quarterlyIds ;
	private String halsyrlyIds;
	private String anuallyIds;
	
	
	
	/**
	 * @return the paymentId
	 */
	public Integer getPaymentId() {
		return paymentId;
	}
	/**
	 * @param paymentId the paymentId to set
	 */
	public void setPaymentId(Integer paymentId) {
		this.paymentId = paymentId;
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
	 * @return the disAmount
	 */
	public String getDisAmount() {
		return disAmount;
	}
	/**
	 * @param disAmount the disAmount to set
	 */
	public void setDisAmount(String disAmount) {
		this.disAmount = disAmount;
	}
	
	/**
	 * @return the feeSlipIds
	 */
	public String getFeeSlipIds() {
		return feeSlipIds;
	}
	/**
	 * @param feeSlipIds the feeSlipIds to set
	 */
	public void setFeeSlipIds(String feeSlipIds) {
		this.feeSlipIds = feeSlipIds;
	}
	/**
	 * @return the chkDDNo
	 */
	public String getChkDDNo() {
		return chkDDNo;
	}
	/**
	 * @param chkDDNo the chkDDNo to set
	 */
	public void setChkDDNo(String chkDDNo) {
		this.chkDDNo = chkDDNo;
	}
	/**
	 * @return the bankName
	 */
	public String getBankName() {
		return bankName;
	}
	/**
	 * @param bankName the bankName to set
	 */
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	/**
	 * @return the issueDate
	 */
	public String getIssueDate() {
		return issueDate;
	}
	/**
	 * @param issueDate the issueDate to set
	 */
	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}
	/**
	 * @return the challanNum
	 */
	public String getChallanNum() {
		return challanNum;
	}
	/**
	 * @param challanNum the challanNum to set
	 */
	public void setChallanNum(String challanNum) {
		this.challanNum = challanNum;
	}
	/**
	 * @return the depositDate
	 */
	public String getDepositDate() {
		return depositDate;
	}
	/**
	 * @param depositDate the depositDate to set
	 */
	public void setDepositDate(String depositDate) {
		this.depositDate = depositDate;
	}
	
	/**
	 * @return the monthIds
	 */
	public String getMonthIds() {
		return monthIds;
	}
	/**
	 * @param monthIds the monthIds to set
	 */
	public void setMonthIds(String monthIds) {
		this.monthIds = monthIds;
	}
	/**
	 * @return the quarterlyIds
	 */
	public String getQuarterlyIds() {
		return quarterlyIds;
	}
	/**
	 * @param quarterlyIds the quarterlyIds to set
	 */
	public void setQuarterlyIds(String quarterlyIds) {
		this.quarterlyIds = quarterlyIds;
	}
	/**
	 * @return the halsyrlyIds
	 */
	public String getHalsyrlyIds() {
		return halsyrlyIds;
	}
	/**
	 * @param halsyrlyIds the halsyrlyIds to set
	 */
	public void setHalsyrlyIds(String halsyrlyIds) {
		this.halsyrlyIds = halsyrlyIds;
	}
	/**
	 * @return the anuallyIds
	 */
	public String getAnuallyIds() {
		return anuallyIds;
	}
	/**
	 * @param anuallyIds the anuallyIds to set
	 */
	public void setAnuallyIds(String anuallyIds) {
		this.anuallyIds = anuallyIds;
	}
	/**
	 * @return the feeSummaryId
	 */
	public Integer getFeeSummaryId() {
		return feeSummaryId;
	}
	/**
	 * @param feeSummaryId the feeSummaryId to set
	 */
	public void setFeeSummaryId(Integer feeSummaryId) {
		this.feeSummaryId = feeSummaryId;
	}
	/**
	 * @return the studentId
	 */
	public Integer getStudentId() {
		return studentId;
	}
	/**
	 * @param studentId the studentId to set
	 */
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
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
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}
	/**
	 * @param comment the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	
}