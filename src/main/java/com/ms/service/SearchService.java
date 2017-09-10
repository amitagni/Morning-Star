/**
 * 
 */
package com.ms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.dao.AbacusRegDao;
import com.ms.dao.StudentInfoDao;
import com.ms.entity.AbacusRegEntity;
import com.ms.entity.StudentInfo;
import com.ms.util.MSException;

/**
 * @author Amit.Agnihotri
 *
 */
@Service
public class SearchService {
	
	@Autowired
	private StudentInfoDao studentInfoDao;
	
	@Autowired
	private AbacusRegDao abacusRegDao;
	
	public List<StudentInfo> findStudentsByName(String studentName){
		return studentInfoDao.findStudentsByName(studentName);
	}

	public List<AbacusRegEntity> findAbacusStudentsByName(String studentName){
		try {
			return abacusRegDao.findStudentByName(studentName);
		} catch (MSException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	public StudentInfo findStudentsById(Integer id){
		List<StudentInfo> studentList = null;
		try {
			studentList = studentInfoDao.findByID(id, StudentInfo.class);
		} catch (MSException e) {
			e.printStackTrace();
		}
		if(studentList != null && studentList.size()>0){
			return studentList.get(0);
		}else{
			return null;
		}
	}
	
	
	
	public AbacusRegEntity findAbacusStudentsById(Integer id){
		List<AbacusRegEntity> studentList = null;
		try {
			studentList = abacusRegDao.findByID(id, AbacusRegEntity.class);
		} catch (MSException e) {
			e.printStackTrace();
		}
		if(studentList != null && studentList.size()>0){
			return studentList.get(0);
		}else{
			return null;
		}
	}
}
