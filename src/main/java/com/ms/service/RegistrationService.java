/**
 * 
 */
package com.ms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ms.bean.ContactDetails;
import com.ms.bean.PaymentFormBean;
import com.ms.bean.RegistrationFormBean;
import com.ms.bean.StudentDetails;
import com.ms.dao.StudentContactInfoDao;
import com.ms.dao.StudentInfoDao;
import com.ms.dao.StudentRegDao;
import com.ms.entity.StudentContactInfo;
import com.ms.entity.StudentInfo;
import com.ms.entity.StudentReg;
import com.ms.enums.Category;
import com.ms.enums.StudentClass;
import com.ms.util.MSException;
import com.ms.util.MSUtil;

/**
 * @author Amit.Agnihotri
 *
 */
@Service
public class RegistrationService {

	@Autowired
	private StudentRegDao studentRegDao;
	
	@Autowired
	private StudentInfoDao studentInfoDao;
	
	@Autowired
	private StudentContactInfoDao studentContactInfoDao;
	
	
	
	/**
	 * @param studentReg
	 * @param studentInfo
	 * @param studentContactInfo
	 */
	@Transactional(rollbackFor = Exception.class)
	public void save(StudentReg studentReg, StudentInfo studentInfo, StudentContactInfo studentContactInfo) throws MSException {
		studentRegDao.save(studentReg);
		studentInfo.setRegId(studentReg.getId());
		studentInfoDao.save(studentInfo);
		studentContactInfo.setStudentId(studentInfo.getId());
		studentContactInfoDao.save(studentContactInfo);
		studentContactInfoDao.flush();
	}

}
