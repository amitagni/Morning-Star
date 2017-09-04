package com.ms.service;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ms.dao.AbacusRegDao;
import com.ms.entity.AbacusRegEntity;
import com.ms.util.MSException;

@Service
public class AbacusRegService {
	
	@Autowired
	private AbacusRegDao abacusRegDao;

	@Transactional(rollbackFor = Exception.class)
	public void saveAbacusRegBean(AbacusRegEntity abacusRegEntity)throws MSException{
		abacusRegDao.save(abacusRegEntity);
		
	}
	
	public AbacusRegEntity findId(Integer id) throws MSException {
		 AbacusRegEntity abacusRegEntity  = null;
		 try{
			 abacusRegEntity  =  abacusRegDao.findById(id, AbacusRegEntity.class);
		 }catch (NoResultException e) {
			
		}
		 return abacusRegEntity;
		
	}
	
}
