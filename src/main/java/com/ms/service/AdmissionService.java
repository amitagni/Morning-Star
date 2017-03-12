/**
 * 
 */
package com.ms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.dao.StudentContactInfoDao;
import com.ms.dao.StudentInfoDao;

/**
 * @author Amit.Agnihotri
 *
 */
@Service
public class AdmissionService {
	
	@Autowired
	public StudentInfoDao studentInfoDao;
	
	@Autowired
	public StudentContactInfoDao studentContactInfoDao;

}
