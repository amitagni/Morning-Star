/**
 * 
 */
package com.ms.dao;

import java.util.List;

import javax.persistence.Query;

import com.ms.entity.FeeStructure;



public class FeeStructureDao extends GenericDao<Integer, FeeStructure> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public List<FeeStructure> findFeeForClassAndSession(Byte selClass,Byte session){
		Query query = getEntityManager().createQuery("Select x from FeeStructure x where x.className= :className and x.sessionName =:sessionName");
		query.setParameter("className", selClass);
		query.setParameter("sessionName", session);

		@SuppressWarnings("unchecked")
		List<FeeStructure> list = query.getResultList();
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}

	
}