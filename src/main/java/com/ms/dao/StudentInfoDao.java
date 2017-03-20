/**
 * 
 */
package com.ms.dao;

import com.ms.entity.StudentInfo;

/**
 * @author Amit.Agnihotri
 *
 */




public class StudentInfoDao extends GenericDao<Integer, StudentInfo> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * @param studentInfo
	 */
	public void save(StudentInfo studentInfo) {
		if (studentInfo.getId() == null) {
			persist(studentInfo);
		} else {
			merge(studentInfo);
		}

	}
	
}