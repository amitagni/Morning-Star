/**
 * 
 */
package com.ms.bean;

import java.util.List;

import com.ms.dto.StudentFeeReportDTO;
import com.ms.enums.StudentClass;

/**
 * @author Amit.Agnihotri
 *
 */
public class ReportBean {
	private List<StudentFeeReportDTO> studentDtoList;
	private String totalPaidAmount;
	private String totalDiscAmount;
	private Byte reportType;
	private Byte currentClass;
	private Integer studentId;
	private Byte selClass;
	private List<StudentClass> studentClassList;
	
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
	/**
	 * @return the reportType
	 */
	public Byte getReportType() {
		return reportType;
	}
	/**
	 * @param reportType the reportType to set
	 */
	public void setReportType(Byte reportType) {
		this.reportType = reportType;
	}
	/**
	 * @return the currentClass
	 */
	public Byte getCurrentClass() {
		return currentClass;
	}
	/**
	 * @param currentClass the currentClass to set
	 */
	public void setCurrentClass(Byte currentClass) {
		this.currentClass = currentClass;
	}
	
	/**
	 * @return the studentClassList
	 */
	public List<StudentClass> getStudentClassList() {
		return studentClassList;
	}
	/**
	 * @param studentClassList the studentClassList to set
	 */
	public void setStudentClassList(List<StudentClass> studentClassList) {
		this.studentClassList = studentClassList;
	}
	/**
	 * @return the selClass
	 */
	public Byte getSelClass() {
		return selClass;
	}
	/**
	 * @param selClass the selClass to set
	 */
	public void setSelClass(Byte selClass) {
		this.selClass = selClass;
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
	
}
