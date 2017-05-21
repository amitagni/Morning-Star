/**
 * 
 */
package com.ms.dto;

import java.util.List;

import com.ms.entity.FeeSlip;

/**
 * @author Amit.Agnihotri
 *
 */
public class FeeSummaryDTO {
	private List<FeeSlip> feeSlipList ;
	private String monthIds ;
	private String quarterlyIds ;
	private String halsyrlyIds;
	private String anuallyIds;
	/**
	 * @return the feeSlipList
	 */
	public List<FeeSlip> getFeeSlipList() {
		return feeSlipList;
	}
	/**
	 * @param feeSlipList the feeSlipList to set
	 */
	public void setFeeSlipList(List<FeeSlip> feeSlipList) {
		this.feeSlipList = feeSlipList;
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
}
