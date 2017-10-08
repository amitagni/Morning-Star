package com.ms.bean;

import java.util.List;

import com.ms.dto.DayBookDTO;


public class LedgerBean extends FormBean {

	private Integer id;
	private Byte transactionType;
    private String startDate;
    private String endDate;
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
	 * @return the startDate
	 */
	public String getStartDate() {
		return startDate;
	}
	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	/**
	 * @return the endDate
	 */
	public String getEndDate() {
		return endDate;
	}
	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
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
	

}
