/**
 * 
 */
package com.ms.service;

/**
 * @author Amit.Agnihotri
 *
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ms.dao.PaymentDao;
import com.ms.entity.Payment;

/**
 * @author Amit.Agnihotri
 *
 */
@Service
public class PaymentService {
	
	@Autowired	
	public PaymentDao paymentDao;

	@Transactional(rollbackFor = Exception.class)
	public void save(Payment payment){
		paymentDao.save(payment);
	}

	public Payment findByStudentId(Integer studentId,Byte feeType) {
		return paymentDao.findByStudentId(studentId, feeType);
	}


	
}
