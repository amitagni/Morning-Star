/**
 * 
 */
package com.ms.service;

import java.util.List;

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
	
	
	@Transactional(rollbackFor = Exception.class)
	public void save(StudentInfo studentInfo) throws MSException {
		studentInfoDao.save(studentInfo);
	}
	
	
	public StudentInfo findStudentById(Integer id) {
		try {
			List<StudentInfo> studentInfoList = studentInfoDao.findByID(id, StudentInfo.class);
			if(studentInfoList != null && studentInfoList.size()>0){
				return studentInfoList.get(0);
			}else{
				return null;
			}
		} catch (MSException e) {
			e.printStackTrace();
			return null;
		}
	}

	
	public StudentInfo findStudentByRegNum(String regNum) {
		StudentInfo studentInfo = null;
		try {
			 studentInfo = studentInfoDao.findStudentByRegNum(regNum);
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return studentInfo;
	}
	
	public StudentContactInfo findStudentContactInfoByStudentId(Integer studentId) {
		StudentContactInfo studentContactInfo = null;
		try {
			studentContactInfo = studentContactInfoDao.findStudentContactInfoByStudentId(studentId);
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return studentContactInfo;
	}


}
