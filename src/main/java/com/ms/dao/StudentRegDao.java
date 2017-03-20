/**
 * 
 */
package com.ms.dao;

import com.ms.entity.StudentReg;

/**
 * @author Amit.Agnihotri
 *
 */





public class StudentRegDao extends GenericDao<Integer, StudentReg> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * @param studentReg
	 */
	public void save(StudentReg studentReg) {
		if (studentReg.getId() == null) {
			persist(studentReg);
		} else {
			merge(studentReg);
		}

	}

	
}