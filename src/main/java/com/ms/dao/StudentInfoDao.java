/**
 * 
 */
package com.ms.dao;

import java.util.List;

import javax.persistence.Query;

import com.ms.entity.FeeStructure;
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
	
	
	public List<StudentInfo> findStudentsByName(String studentName){
		Query query = getEntityManager().createQuery("Select st from StudentInfo st where st.firstName like ('"+studentName+"%')");
		@SuppressWarnings("unchecked")
		List<StudentInfo> list = query.getResultList();
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}

	
}