package com.ms.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ms.dao.AccountDao;
import com.ms.dao.DayBookDao;
import com.ms.entity.Account;
import com.ms.entity.DayBook;
import com.ms.entity.StudentInfo;
import com.ms.util.MSException;

@Service
public class DayBookService {
	
	@Autowired
	private DayBookDao dayBookDao;
	
	@Autowired
	private AccountDao accountDao;
	
	@Transactional(rollbackFor = Exception.class)
	public DayBook save(DayBook dayBookEntity) throws MSException {
		//dayBookDao.save(dayBookEntity);
		if(dayBookEntity.getId() == null || dayBookEntity.getId().intValue() <= 0){
			dayBookDao.persist(dayBookEntity);
		}else{
			dayBookEntity = dayBookDao.merge(dayBookEntity);
		}
		return dayBookEntity;
	}
	@Transactional(rollbackFor = Exception.class)
	public Account
	 save(Account account) throws MSException {
		//dayBookDao.save(dayBookEntity);
		if(account.getId() == null || account.getId().intValue() <= 0){
			accountDao.persist(account);
		}else{
			account = accountDao.merge(account);
		}
		return account;
	}
	
	@Transactional(rollbackFor = Exception.class)
	public boolean deletDayBookEntry(Integer id){
		DayBook  dayBook = dayBookDao.findById(id, DayBook.class);
		dayBook.setActive((byte) 0);
		dayBookDao.merge(dayBook);
		return true;
	}
	
	public List<Account> findAccountsByName(String accountName){
		return accountDao.findAccountsByName(accountName);
	}

	public List<DayBook> findDayBookEntryByDate(Date date){
		return dayBookDao.findDayBookEntryByDate(date);
	}
	
	public List<DayBook> findDayBookEntryByDateAndAccountId(String id,Date startDate,Date endDate){
		return dayBookDao.findDayBookEntryByDateAndAccountId(id,startDate,endDate);
	}
	
	
	public List<Account> findAllAccounts(){
		try {
			return accountDao.findAll(Account.class);
		} catch (MSException e) {
			e.printStackTrace();
			return null;
		}
	}

}
