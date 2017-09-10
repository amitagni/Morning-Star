/**
 * 
 */
package com.ms.dao;

import java.util.List;

import javax.persistence.Query;

import com.ms.entity.AbacusRegEntity;
import com.ms.entity.StudentReg;
import com.ms.util.MSException;

/**
 * @author Amit.Agnihotri
 *
 */


public class AbacusRegDao extends GenericDao<Integer, AbacusRegEntity> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * @param studentReg
	 */
	public void save(AbacusRegEntity abacusRegEntity) {
		if (abacusRegEntity.getId() == null) {
			persist(abacusRegEntity);
		} else {
			merge(abacusRegEntity);
		}

	}
	
	public  StudentReg findIdByNumber(String regNumber) throws MSException {
		Query jpaQuery = getEntityManager().createQuery("Select r from StudentReg r where r.regNumber = "+regNumber);
		StudentReg studentReg = (StudentReg) jpaQuery.getSingleResult();
		return studentReg;
		
	}
	
	public List<AbacusRegEntity> findStudentByName(String studentName) throws MSException {
		Query jpaQuery = getEntityManager().createQuery("Select r from AbacusRegEntity r where r.firstName like ('"+studentName+"%')");
		List<AbacusRegEntity> studentList =  jpaQuery.getResultList();
		return studentList;
		
	}

	
}