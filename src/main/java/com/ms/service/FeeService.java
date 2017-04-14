/**
 * 
 */
package com.ms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ms.dao.FeeSlipDao;
import com.ms.dao.FeeStructureDao;
import com.ms.dao.PaidFeeSummaryDao;
import com.ms.entity.FeeSlip;
import com.ms.entity.FeeStructure;
import com.ms.entity.PaidFeeSummary;
import com.ms.util.MSException;

/*
 * @author Amit.Agnihotri
 *
 */
@Service
public class FeeService {
	@Autowired
	private FeeStructureDao feeStructureDao;
	
	@Autowired
	private FeeSlipDao feeSlipDao; 

	
	@Autowired
	private PaidFeeSummaryDao paidFeeSummaryDao;

	public List<FeeStructure> findFeeForClassAndSession(Byte selClass,Byte session){
		return feeStructureDao.findFeeForClassAndSession(selClass, session);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public void save(FeeSlip feeSlip) {
		 feeSlipDao.save(feeSlip);
	}

	@Transactional(rollbackFor = Exception.class)
	public void save(PaidFeeSummary paidFeeSummary) {
		paidFeeSummaryDao.save(paidFeeSummary);
	}
	public List<FeeSlip> findFeeSlips(String ids) throws MSException {
		return feeSlipDao.findFeeSlips(ids);
	}
	
	public PaidFeeSummary findByStudentId(Integer studentId) throws MSException {
		return paidFeeSummaryDao.findByStudentId(studentId);
	}
	
	public List<Object> generateFeeSlipData(String paymentId) throws MSException {
		return  feeSlipDao.generateFeeSlipData(paymentId);
	}
	
}
