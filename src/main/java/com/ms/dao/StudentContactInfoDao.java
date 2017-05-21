/**
 * 
 */
package com.ms.dao;

import javax.persistence.Query;

/**
 * @author Amit.Agnihotri
 *
 */

import com.ms.entity.StudentContactInfo;
import com.ms.entity.StudentInfo;



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
	
	public StudentContactInfo findStudentContactInfoByStudentId(Integer studentId) {
		Query query = getEntityManager().createQuery("Select st from StudentContactInfo st where st.studentId ="+studentId);
		StudentContactInfo studentContactInfo = (StudentContactInfo) query.getSingleResult();
		return studentContactInfo;
	}
}