
package com.ms.dao;

import java.util.List;

import javax.persistence.Query;

import com.ms.entity.FeeSlip;
import com.ms.entity.User;
import com.ms.util.MSException;



public class FeeSlipDao extends GenericDao<Integer, FeeSlip> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void save(FeeSlip feeSlip) {
		if (feeSlip.getId() == null) {
			persist(feeSlip);
		} else {
			merge(feeSlip);
		}

	}
	
	@SuppressWarnings("unchecked")
	public List<FeeSlip> findFeeSlips(String ids) throws MSException {
		Query jpaQuery = getEntityManager().createQuery("Select f from FeeSlip f where f.id in("+ids+")");
		List<FeeSlip> list = jpaQuery.getResultList();
		return list;
	}
}