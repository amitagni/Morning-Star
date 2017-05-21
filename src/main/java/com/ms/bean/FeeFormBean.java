/**
 * 
 */
package com.ms.bean;

import java.util.List;

import com.ms.dto.FeeDTO;
import com.ms.dto.FeeMonthsDTO;
import com.ms.enums.Month;

/**
 * @author Amit.Agnihotri
 *
 */
public class FeeFormBean extends FormBean{
	private Integer studentId;
	private Integer feeSummaryId;
	private Byte[] selMonth;
	private List<FeeMonthsDTO> monthList;
	private List<FeeDTO> monthlyFeeList;
	private List<FeeDTO> quarterlyFeeList;
	private List<FeeDTO> halfyearlyFeeList;
	private List<FeeDTO> anualFeeList;
	private String totalAmt;
	private String totalDiscAmt;
	private String totalPaidAmt;
	
	private String studentMSId;
	private String studentName;
	private String studentClass;
	private String months;
	/**
	 * @return the monthList
	 */
	
	/**
	 * @return the monthlyFeeList
	 */
	public List<FeeDTO> getMonthlyFeeList() {
		return monthlyFeeList;
	}
	public List<FeeMonthsDTO> getMonthList() {
		return monthList;
	}
	public void setMonthList(List<FeeMonthsDTO> monthList) {
		this.monthList = monthList;
	}
	/**
	 * @param monthlyFeeList the monthlyFeeList to set
	 */
	public void setMonthlyFeeList(List<FeeDTO> monthlyFeeList) {
		this.monthlyFeeList = monthlyFeeList;
	}
	/**
	 * @return the quarterlyFeeList
	 */
	public List<FeeDTO> getQuarterlyFeeList() {
		return quarterlyFeeList;
	}
	/**
	 * @param quarterlyFeeList the quarterlyFeeList to set
	 */
	public void setQuarterlyFeeList(List<FeeDTO> quarterlyFeeList) {
		this.quarterlyFeeList = quarterlyFeeList;
	}
	/**
	 * @return the halfyearlyFeeList
	 */
	public List<FeeDTO> getHalfyearlyFeeList() {
		return halfyearlyFeeList;
	}
	/**
	 * @param halfyearlyFeeList the halfyearlyFeeList to set
	 */
	public void setHalfyearlyFeeList(List<FeeDTO> halfyearlyFeeList) {
		this.halfyearlyFeeList = halfyearlyFeeList;
	}
	/**
	 * @return the anualFeeList
	 */
	public List<FeeDTO> getAnualFeeList() {
		return anualFeeList;
	}
	/**
	 * @param anualFeeList the anualFeeList to set
	 */
	public void setAnualFeeList(List<FeeDTO> anualFeeList) {
		this.anualFeeList = anualFeeList;
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
	 * @return the totalAmt
	 */
	public String getTotalAmt() {
		return totalAmt;
	}
	/**
	 * @param totalAmt the totalAmt to set
	 */
	public void setTotalAmt(String totalAmt) {
		this.totalAmt = totalAmt;
	}
	/**
	 * @return the totalDiscAmt
	 */
	public String getTotalDiscAmt() {
		return totalDiscAmt;
	}
	/**
	 * @param totalDiscAmt the totalDiscAmt to set
	 */
	public void setTotalDiscAmt(String totalDiscAmt) {
		this.totalDiscAmt = totalDiscAmt;
	}
	/**
	 * @return the totalPaidAmt
	 */
	public String getTotalPaidAmt() {
		return totalPaidAmt;
	}
	/**
	 * @param totalPaidAmt the totalPaidAmt to set
	 */
	public void setTotalPaidAmt(String totalPaidAmt) {
		this.totalPaidAmt = totalPaidAmt;
	}
	/**
	 * @return the selMonth
	 */
	public Byte[] getSelMonth() {
		return selMonth;
	}
	/**
	 * @param selMonth the selMonth to set
	 */
	public void setSelMonth(Byte[] selMonth) {
		this.selMonth = selMonth;
	}
	/**
	 * @return the studentMSId
	 */
	public String getStudentMSId() {
		return studentMSId;
	}
	/**
	 * @param studentMSId the studentMSId to set
	 */
	public void setStudentMSId(String studentMSId) {
		this.studentMSId = studentMSId;
	}
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
	 * @return the studentClass
	 */
	public String getStudentClass() {
		return studentClass;
	}
	/**
	 * @param studentClass the studentClass to set
	 */
	public void setStudentClass(String studentClass) {
		this.studentClass = studentClass;
	}
	/**
	 * @return the months
	 */
	public String getMonths() {
		return months;
	}
	/**
	 * @param months the months to set
	 */
	public void setMonths(String months) {
		this.months = months;
	}
	

}
