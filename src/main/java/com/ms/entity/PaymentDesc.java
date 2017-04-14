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
@Table(name = "payment_desc")
public class PaymentDesc extends BaseEntity<Integer> implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "details_1")
	private String details1;

	@Column(name = "details_2")
	private String details2;
	
	@Column(name = "details_3")
	private String details3;
	
	
	@Column(name = "created_by")
	private Integer createdBy;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at")
	private Date createdAt;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at")
	private Date updatedAt;

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
	 * @return the details1
	 */
	public String getDetails1() {
		return details1;
	}

	/**
	 * @param details1 the details1 to set
	 */
	public void setDetails1(String details1) {
		this.details1 = details1;
	}

	/**
	 * @return the details2
	 */
	public String getDetails2() {
		return details2;
	}

	/**
	 * @param details2 the details2 to set
	 */
	public void setDetails2(String details2) {
		this.details2 = details2;
	}

	/**
	 * @return the details3
	 */
	public String getDetails3() {
		return details3;
	}

	/**
	 * @param details3 the details3 to set
	 */
	public void setDetails3(String details3) {
		this.details3 = details3;
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

}
