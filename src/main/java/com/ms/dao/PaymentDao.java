/**
 * 
 */
package com.ms.dao;

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
	
}