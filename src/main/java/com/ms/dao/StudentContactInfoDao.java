/**
 * 
 */
package com.ms.dao;

/**
 * @author Amit.Agnihotri
 *
 */

import com.ms.entity.StudentContactInfo;



public class StudentContactInfoDao extends GenericDao<Integer, StudentContactInfo> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param studentContactInfo
	 */
	public void save(StudentContactInfo studentContactInfo) {
		if (studentContactInfo.getId() == null) {
			persist(studentContactInfo);
		} else {
			merge(studentContactInfo);
		}

	}
}