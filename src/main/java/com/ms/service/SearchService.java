/**
 * 
 */
package com.ms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.dao.StudentInfoDao;
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
	
	public List<StudentInfo> findStudentsByName(String studentName){
		return studentInfoDao.findStudentsByName(studentName);
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
}
