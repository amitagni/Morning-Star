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
@Table(name = "day_book")
public class DayBook extends BaseEntity<Integer> implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "account_Id")
	private Integer accountId;
	
	@Column(name = "transaction_type")
	private Byte transactionType;


	@Column(name = "payment_type")
	private Byte paymentType;
	
	@Column(name = "cheque_epay_no")
	private String chequeEpayNo;
	
	
	@Column(name = "amount")
	private String amount;
	
	@Column(name = "comment")
	private String comments;
	
	@Column(name = "active")
	private Byte active;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at")
	private Date createdAt;
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	/**
	 * @return the accountId
	 */
	public Integer getAccountId() {
		return accountId;
	}

	/**
	 * @param accountId the accountId to set
	 */
	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
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

	/**
	 * @return the paymentType
	 */
	public Byte getPaymentType() {
		return paymentType;
	}

	/**
	 * @param paymentType the paymentType to set
	 */
	public void setPaymentType(Byte paymentType) {
		this.paymentType = paymentType;
	}

	/**
	 * @return the chequeEpayNo
	 */
	public String getChequeEpayNo() {
		return chequeEpayNo;
	}

	/**
	 * @param chequeEpayNo the chequeEpayNo to set
	 */
	public void setChequeEpayNo(String chequeEpayNo) {
		this.chequeEpayNo = chequeEpayNo;
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
	 * @return the active
	 */
	public Byte getActive() {
		return active;
	}

	/**
	 * @param active the active to set
	 */
	public void setActive(Byte active) {
		this.active = active;
	}

	
	
}
