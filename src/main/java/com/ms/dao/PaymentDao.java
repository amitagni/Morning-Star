/**
 * 
 */
package com.ms.dao;


import javax.persistence.Query;

import com.ms.entity.Payment;




public class PaymentDao extends GenericDao<Integer, Payment> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void save(Payment payment) {
		if (payment.getId() == null) {
			persist(payment);
		} else {
			merge(payment);
		}

	}
	

	public Payment findByStudentId(Integer studentId,Byte feeType) {
		Query jpaQuery = getEntityManager().createQuery("Select p from Payment p where p.studentId = "+studentId + " and p.feeType = "+feeType);
		Payment payment = (Payment) jpaQuery.getSingleResult();
		return payment;

	}
	

}