package com.ms.dao;

import java.sql.Date;
import java.util.List;

import javax.persistence.Query;

import com.ms.entity.DayBook;



public class DayBookDao extends GenericDao<Integer, DayBook> {
	
private static final long serialVersionUID = 1L;



	public List<DayBook> findDayBookEntryByDate(Date date){
		Query query = getEntityManager().createQuery("Select db from DayBook db where db.active = 1 and db.createdAt > "+date);
		@SuppressWarnings("unchecked")
		List<DayBook> list = query.getResultList();
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}
	
	public List<DayBook> findDayBookEntryByDateAndAccountId(String id,Date startDate,Date endDate){
		Query query = getEntityManager().createQuery("Select db from DayBook db where id = :id db.active = 1 and db.createdAt between  :startDate and :endDate");
		query.setParameter("id", id);
		query.setParameter("startDate", startDate);
		query.setParameter("endDate", endDate);
		@SuppressWarnings("unchecked")
		List<DayBook> list = query.getResultList();
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}

	
}
