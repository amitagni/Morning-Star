package com.ms.entity;
/**
 * 
 */


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ms.entity.BaseEntity;

/**
 * @author Amit.Agnihotri
 *
 */
@Entity
@Table(name = "paid_fee_summary")
public class PaidFeeSummary extends BaseEntity<Integer> implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "student_id")
	private Integer studentId;
	
	@Column(name = "session")
	private Byte sessionName;
	
	@Column(name = "monthly_freq")
	private String monthlyFreq;
	
	@Column(name = "quaterly_freq")
	private String quaterlyFreq;
	
	@Column(name = "halfyearly_freq")
	private String halfyearlyFreq;
	
	@Column(name = "annually_freq")
	private String annuallyFreq;
	
	@Column(name = "updated_by")
	private Integer updatedBy;

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
	 * @return the sessionName
	 */
	public Byte getSessionName() {
		return sessionName;
	}

	/**
	 * @param sessionName the sessionName to set
	 */
	public void setSessionName(Byte sessionName) {
		this.sessionName = sessionName;
	}

	/**
	 * @return the monthlyFreq
	 */
	public String getMonthlyFreq() {
		return monthlyFreq;
	}

	/**
	 * @param monthlyFreq the monthlyFreq to set
	 */
	public void setMonthlyFreq(String monthlyFreq) {
		this.monthlyFreq = monthlyFreq;
	}

	/**
	 * @return the quaterlyFreq
	 */
	public String getQuaterlyFreq() {
		return quaterlyFreq;
	}

	/**
	 * @param quaterlyFreq the quaterlyFreq to set
	 */
	public void setQuaterlyFreq(String quaterlyFreq) {
		this.quaterlyFreq = quaterlyFreq;
	}

	/**
	 * @return the halfyearlyFreq
	 */
	public String getHalfyearlyFreq() {
		return halfyearlyFreq;
	}

	/**
	 * @param halfyearlyFreq the halfyearlyFreq to set
	 */
	public void setHalfyearlyFreq(String halfyearlyFreq) {
		this.halfyearlyFreq = halfyearlyFreq;
	}

	/**
	 * @return the annuallyFreq
	 */
	public String getAnnuallyFreq() {
		return annuallyFreq;
	}

	/**
	 * @param annuallyFreq the annuallyFreq to set
	 */
	public void setAnnuallyFreq(String annuallyFreq) {
		this.annuallyFreq = annuallyFreq;
	}

	/**
	 * @return the updatedBy
	 */
	public Integer getUpdatedBy() {
		return updatedBy;
	}

	/**
	 * @param updatedBy the updatedBy to set
	 */
	public void setUpdatedBy(Integer updatedBy) {
		this.updatedBy = updatedBy;
	}
	
	
}