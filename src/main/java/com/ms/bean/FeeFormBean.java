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
	private Byte selMonth;
	private List<Month> monthList;
	private List<FeeDTO> monthlyFeeList;
	private List<FeeDTO> quarterlyFeeList;
	private List<FeeDTO> halfyearlyFeeList;
	private List<FeeDTO> anualFeeList;
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
	

}
