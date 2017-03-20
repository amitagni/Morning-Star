/**
 * 
 */
package com.ms.bean;

/**
 * @author Amit.Agnihotri
 *
 */
public class PaymentFormBean extends FormBean{
	
	private String amount;
	private String disAmount;
	private String paymentType;
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
	 * @return the paymentType
	 */
	public String getPaymentType() {
		return paymentType;
	}
	/**
	 * @param paymentType the paymentType to set
	 */
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	
}