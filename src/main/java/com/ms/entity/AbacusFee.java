package com.ms.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "abacus_fee")
public class AbacusFee extends BaseEntity<Integer> implements Serializable {
	private static final long serialVersionUID = -5952231633736953084L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@Column(name = "student_id")
	private Integer studentId;


	@Column(name = "months")
	private String months;

	@Column(name = "amount")
	private String amount;
	
	@Column(name = "status")
	private byte status;

	@Column(name = "regfee")
	private String regfee;
	
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at")
	private Date createdAt;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at")
	private Date updatedAt;

	/* (non-Javadoc)
	 * @see com.ms.entity.BaseEntity#getId()
	 */
	@Override
	public Integer getId() {
			return this.id;
	}

	
	@Override
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
	 * @return the amount
	 */
	public String getAmount() {
		return amount;
	}


	/**
	 * @param amount the amount to set
	 */
	public void setAmount(String amount) {
		this.amount = amount;
	}


	/**
	 * @return the createdAt
	 */
	public Date getCreatedAt() {
		return createdAt;
	}


	/**
	 * @param createdAt the createdAt to set
	 */
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}


	/**
	 * @return the updatedAt
	 */
	public Date getUpdatedAt() {
		return updatedAt;
	}


	/**
	 * @param updatedAt the updatedAt to set
	 */
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}


	/**
	 * @return the status
	 */
	public byte getStatus() {
		return status;
	}


	/**
	 * @param status the status to set
	 */
	public void setStatus(byte status) {
		this.status = status;
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


	/**
	 * @return the regfee
	 */
	public String getRegfee() {
		return regfee;
	}


	/**
	 * @param regfee the regfee to set
	 */
	public void setRegfee(String regfee) {
		this.regfee = regfee;
	}




}
