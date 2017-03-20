/**
 * 
 */
package com.ms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ms.dao.StudentContactInfoDao;
import com.ms.dao.StudentInfoDao;
import com.ms.entity.StudentContactInfo;
import com.ms.entity.StudentInfo;
import com.ms.entity.StudentReg;
import com.ms.util.MSException;

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

	/**
	 * @param studentReg
	 * @param studentInfo
	 * @param studentContactInfo
	 */
	@Transactional(rollbackFor = Exception.class)
	public void save(StudentInfo studentInfo, StudentContactInfo studentContactInfo) throws MSException {
		studentInfoDao.save(studentInfo);
		studentContactInfo.setStudentId(studentInfo.getId());
		studentContactInfoDao.save(studentContactInfo);
		studentContactInfoDao.flush();
	}


}
