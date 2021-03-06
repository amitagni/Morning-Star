
package com.ms.dao;

import java.util.List;

import javax.persistence.Query;

import com.ms.entity.AbacusFee;
import com.ms.entity.AbacusRegEntity;
import com.ms.entity.User;
import com.ms.util.MSException;



public class AbacusFeeDao extends GenericDao<Integer, AbacusFee> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public void save(AbacusFee abacusFee) {
		if (abacusFee.getId() == null) {
			persist(abacusFee);
		} else {
			merge(abacusFee);
		}

	}
	@SuppressWarnings("unchecked")
	public List<AbacusFee> findByStudentId(Integer studentId) throws MSException {
		Query jpaQuery = getEntityManager().createQuery("Select af from AbacusFee af where af.studentId = :studentId  and af.status=1");
		jpaQuery.setParameter("studentId", studentId);
		List<AbacusFee> list = jpaQuery.getResultList();
		if (list.size() > 0) {
			return list;
		}
		return null;
	}
}