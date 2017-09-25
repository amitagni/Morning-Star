/**
 * 
 */
package com.ms.dto;

import java.io.Serializable;

/**
 * @author Amit.Agnihotri
 *
 */
public class StudentFeeReportDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String studentName;
	private String studentFatherName;
	private String paidAmount;
	private String discAmount;
	private String monthlyPaid;
	private String quterlyPaid;
	private String halfyearlyPaid;
	private String anuallyPaid;
	/**
	 * @return the studentName
	 */
	public String getStudentName() {
		return studentName;
	}
	/**
	 * @param studentName the studentName to set
	 */
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	/**
	 * @return the studentFatherName
	 */
	public String getStudentFatherName() {
		return studentFatherName;
	}
	/**
	 * @param studentFatherName the studentFatherName to set
	 */
	public void setStudentFatherName(String studentFatherName) {
		this.studentFatherName = studentFatherName;
	}
	/**
	 * @return the paidAmount
	 */
	public String getPaidAmount() {
		return paidAmount;
	}
	/**
	 * @param paidAmount the paidAmount to set
	 */
	public void setPaidAmount(String paidAmount) {
		this.paidAmount = paidAmount;
	}
	/**
	 * @return the discAmount
	 */
	public String getDiscAmount() {
		return discAmount;
	}
	/**
	 * @param discAmount the discAmount to set
	 */
	public void setDiscAmount(String discAmount) {
		this.discAmount = discAmount;
	}
	/**
	 * @return the monthlyPaid
	 */
	public String getMonthlyPaid() {
		return monthlyPaid;
	}
	/**
	 * @param monthlyPaid the monthlyPaid to set
	 */
	public void setMonthlyPaid(String monthlyPaid) {
		this.monthlyPaid = monthlyPaid;
	}
	/**
	 * @return the quterlyPaid
	 */
	public String getQuterlyPaid() {
		return quterlyPaid;
	}
	/**
	 * @param quterlyPaid the quterlyPaid to set
	 */
	public void setQuterlyPaid(String quterlyPaid) {
		this.quterlyPaid = quterlyPaid;
	}
	/**
	 * @return the halfyearlyPaid
	 */
	public String getHalfyearlyPaid() {
		return halfyearlyPaid;
	}
	/**
	 * @param halfyearlyPaid the halfyearlyPaid to set
	 */
	public void setHalfyearlyPaid(String halfyearlyPaid) {
		this.halfyearlyPaid = halfyearlyPaid;
	}
	/**
	 * @return the anuallyPaid
	 */
	public String getAnuallyPaid() {
		return anuallyPaid;
	}
	/**
	 * @param anuallyPaid the anuallyPaid to set
	 */
	public void setAnuallyPaid(String anuallyPaid) {
		this.anuallyPaid = anuallyPaid;
	}
	
	

}
