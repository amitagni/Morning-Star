/**
 * 
 */
package com.ms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.dao.FeeStructureDao;
import com.ms.entity.FeeStructure;

/**
 * @author Amit.Agnihotri
 *
 */
@Service
public class FeeService {
	@Autowired
	private FeeStructureDao feeStructureDao; 

	public List<FeeStructure> findFeeForClassAndSession(Byte selClass,Byte session){
		return feeStructureDao.findFeeForClassAndSession(selClass, session);
	}


}
