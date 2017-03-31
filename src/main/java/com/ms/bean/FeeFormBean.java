/**
 * 
 */
package com.ms.bean;

import java.util.List;

import com.ms.dto.FeeDTO;
import com.ms.enums.Month;

/**
 * @author Amit.Agnihotri
 *
 */
public class FeeFormBean extends FormBean{
	private Integer studentId;
	private Integer feeSummaryId;
	private Byte selMonth;
	private List<Month> monthList;
	private List<FeeDTO> monthlyFeeList;
	private List<FeeDTO> quarterlyFeeList;
	private List<FeeDTO> halfyearlyFeeList;
	private List<FeeDTO> anualFeeList;
	private String totalAmt;
	private String totalDiscAmt;
	private String totalPaidAmt;
	/**
	 * @return the monthList
	 */
	public List<Month> getMonthList() {
		return monthList;
	}
	/**
	 * @param monthList the monthList to set
	 */
	public void setMonthList(List<Month> monthList) {
		this.monthList = monthList;
	}
	/**
	 * @return the monthlyFeeList
	 */
	public List<FeeDTO> getMonthlyFeeList() {
		return monthlyFeeList;
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
	 * @return the selMonth
	 */
	public Byte getSelMonth() {
		return selMonth;
	}
	/**
	 * @param selMonth the selMonth to set
	 */
	public void setSelMonth(Byte selMonth) {
		this.selMonth = selMonth;
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
	

}
