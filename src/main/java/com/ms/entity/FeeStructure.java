/**
 * 
 */
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

/**
 * @author Amit.Agnihotri
 *
 */
@Entity
@Table(name = "fee_structure")
public class FeeStructure extends BaseEntity<Integer> implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;


	@Column(name = "fee_freq_type")
	private Byte feeFreqType;
	
	@Column(name = "abbr_name")
	private String abbrName;
	
	@Column(name = "class")
	private Byte className;
	
	
	@Column(name = "amount")
	private String amount;
	
	@Column(name = "session")
	private Byte sessionName;
	
	@Column(name = "created_by")
	private Integer createdBy;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at")
	private Date createdAt;

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
	 * @return the feeFreqType
	 */
	public Byte getFeeFreqType() {
		return feeFreqType;
	}

	/**
	 * @param feeFreqType the feeFreqType to set
	 */
	public void setFeeFreqType(Byte feeFreqType) {
		this.feeFreqType = feeFreqType;
	}

	/**
	 * @return the abbrName
	 */
	public String getAbbrName() {
		return abbrName;
	}

	/**
	 * @param abbrName the abbrName to set
	 */
	public void setAbbrName(String abbrName) {
		this.abbrName = abbrName;
	}

	/**
	 * @return the className
	 */
	public Byte getClassName() {
		return className;
	}

	/**
	 * @param className the className to set
	 */
	public void setClassName(Byte className) {
		this.className = className;
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
	 * @return the createdBy
	 */
	public Integer getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
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


}
