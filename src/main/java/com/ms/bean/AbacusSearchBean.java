package com.ms.bean;

import java.util.List;

import com.ms.dto.FeeMonthsDTO;

public class AbacusSearchBean extends FormBean{

	
	private int id;
	private String name;
	private String fatherName;
	private byte regFee;
	private List<FeeMonthsDTO> monthList;
	private String selMonth;
	private Integer regAmt;
	private Integer monthlyAmt;
	private Integer totalAmt;
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the fatherName
	 */
	public String getFatherName() {
		return fatherName;
	}
	/**
	 * @param fatherName the fatherName to set
	 */
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}


	/**
	 * @return the monthList
	 */
	public List<FeeMonthsDTO> getMonthList() {
		return monthList;
	}
	/**
	 * @param monthList the monthList to set
	 */
	public void setMonthList(List<FeeMonthsDTO> monthList) {
		this.monthList = monthList;
	}
	/**
	 * @return the selMonth
	 */
	public String getSelMonth() {
		return selMonth;
	}
	/**
	 * @param selMonth the selMonth to set
	 */
	public void setSelMonth(String selMonth) {
		this.selMonth = selMonth;
	}
	/**
	 * @return the totalAmt
	 */
	public Integer getTotalAmt() {
		return totalAmt;
	}
	/**
	 * @param totalAmt the totalAmt to set
	 */
	public void setTotalAmt(Integer totalAmt) {
		this.totalAmt = totalAmt;
	}
	/**
	 * @return the regFee
	 */
	public byte getRegFee() {
		return regFee;
	}
	/**
	 * @param regFee the regFee to set
	 */
	public void setRegFee(byte regFee) {
		this.regFee = regFee;
	}
	/**
	 * @return the regAmt
	 */
	public Integer getRegAmt() {
		return regAmt;
	}
	/**
	 * @param regAmt the regAmt to set
	 */
	public void setRegAmt(Integer regAmt) {
		this.regAmt = regAmt;
	}
	/**
	 * @return the monthlyAmt
	 */
	public Integer getMonthlyAmt() {
		return monthlyAmt;
	}
	/**
	 * @param monthlyAmt the monthlyAmt to set
	 */
	public void setMonthlyAmt(Integer monthlyAmt) {
		this.monthlyAmt = monthlyAmt;
	}
	
	
	
	
}
