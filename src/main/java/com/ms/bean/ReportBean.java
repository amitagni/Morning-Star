/**
 * 
 */
package com.ms.bean;

import java.util.List;

import com.ms.dto.StudentFeeReportDTO;

/**
 * @author Amit.Agnihotri
 *
 */
public class ReportBean {
	private List<StudentFeeReportDTO> studentDtoList;
	private String totalPaidAmount;
	private String totalDiscAmount;
	
	/**
	 * @return the studentDtoList
	 */
	public List<StudentFeeReportDTO> getStudentDtoList() {
		return studentDtoList;
	}
	/**
	 * @param studentDtoList the studentDtoList to set
	 */
	public void setStudentDtoList(List<StudentFeeReportDTO> studentDtoList) {
		this.studentDtoList = studentDtoList;
	}
	/**
	 * @return the totalPaidAmount
	 */
	public String getTotalPaidAmount() {
		return totalPaidAmount;
	}
	/**
	 * @param totalPaidAmount the totalPaidAmount to set
	 */
	public void setTotalPaidAmount(String totalPaidAmount) {
		this.totalPaidAmount = totalPaidAmount;
	}
	/**
	 * @return the totalDiscAmount
	 */
	public String getTotalDiscAmount() {
		return totalDiscAmount;
	}
	/**
	 * @param totalDiscAmount the totalDiscAmount to set
	 */
	public void setTotalDiscAmount(String totalDiscAmount) {
		this.totalDiscAmount = totalDiscAmount;
	}

}
