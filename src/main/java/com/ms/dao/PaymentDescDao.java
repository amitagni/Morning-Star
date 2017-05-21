/**
 * 
 */
package com.ms.dao;

import com.ms.entity.PaymentDesc;



public class PaymentDescDao extends GenericDao<Integer, PaymentDesc> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void save(PaymentDesc paymentDesc) {
		if (paymentDesc.getId() == null) {
			persist(paymentDesc);
		} else {
			merge(paymentDesc);
		}
	}
	
}