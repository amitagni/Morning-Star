package com.ms.dao;

import java.util.List;

import javax.persistence.Query;

import com.ms.entity.Account;

public class AccountDao  extends GenericDao<Integer, Account> {
		
	private static final long serialVersionUID = 1L;

	public List<Account> findAccountsByName(String accountName){
		Query query = getEntityManager().createQuery("Select ac from Account st where ac.accountName like ('"+accountName+"%')");
		@SuppressWarnings("unchecked")
		List<Account> list = query.getResultList();
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}
	

}
	

