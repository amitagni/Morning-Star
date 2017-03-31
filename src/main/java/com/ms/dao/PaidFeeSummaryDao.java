
package com.ms.dao;

import java.util.List;

import javax.persistence.Query;

import com.ms.entity.PaidFeeSummary;
import com.ms.entity.User;
import com.ms.util.MSException;



public class PaidFeeSummaryDao extends GenericDao<Integer, PaidFeeSummary> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void save(PaidFeeSummary paidFeeSummary) {
		if (paidFeeSummary.getId() == null) {
			persist(paidFeeSummary);
		} else {
			merge(paidFeeSummary);
		}

	}
	
	
	@SuppressWarnings("unchecked")
	public PaidFeeSummary findByStudentId(Integer studentId) throws MSException {
		Query jpaQuery = getEntityManager().createQuery("Select fs from PaidFeeSummary fs where fs.studentId = :studentId");
		jpaQuery.setParameter("studentId", studentId);
		List<PaidFeeSummary> list = jpaQuery.getResultList();
		if (list.size() > 0) {
			return list.get(0);
		}
		return null;
	}
	
	
	
}