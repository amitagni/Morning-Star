
package com.ms.dao;

import java.util.List;

import javax.persistence.Query;

import com.ms.entity.FeeSlip;
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
	
	@SuppressWarnings("unchecked")
	public List<Object> generateFeeSlipData(String paymentId) throws MSException {
		Query jpaQuery = getEntityManager().createNativeQuery("select fs.amount,fs.discount,fst.fee_freq_type,fst.abbr_name,fst.amount,fs.month from fee_slip fs,fee_structure fst,payment py where fs.fee_structure_id = fst.id && py.id = fs.payment_id && py.id = "+paymentId);
		List<Object> list = jpaQuery.getResultList();
		return list;
	}
}