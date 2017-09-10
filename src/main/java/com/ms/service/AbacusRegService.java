package com.ms.service;

import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ms.dao.AbacusFeeDao;
import com.ms.dao.AbacusRegDao;
import com.ms.entity.AbacusFee;
import com.ms.entity.AbacusRegEntity;
import com.ms.util.MSException;

@Service
public class AbacusRegService {
	
	@Autowired
	private AbacusRegDao abacusRegDao;
	
	@Autowired
	private AbacusFeeDao abacusFeeDao;

	@Transactional(rollbackFor = Exception.class)
	public void saveAbacusRegBean(AbacusRegEntity abacusRegEntity)throws MSException{
		abacusRegDao.save(abacusRegEntity);
		
	}
	
	@Transactional(rollbackFor = Exception.class)
	public void saveAbacusFee(AbacusFee abacusFee)throws MSException{
		abacusFeeDao.save(abacusFee);
		
	}
	
	public AbacusRegEntity findId(Integer id) throws MSException {
		 AbacusRegEntity abacusRegEntity  = null;
		 try{
			 abacusRegEntity  =  abacusRegDao.findById(id, AbacusRegEntity.class);
		 }catch (NoResultException e) {
			
		}
		 return abacusRegEntity;
		
	}
	
	public AbacusFee findFeeById(Integer id) throws MSException {
		 AbacusFee  abacusFee = null;
		 try{
			  abacusFee=  abacusFeeDao.findById(id, AbacusFee.class);
		 }catch (NoResultException e) {
			
		}
		 return abacusFee;
		
	}
	
	public List<AbacusFee> findByStudentId(Integer studentId) throws MSException {
		List<AbacusFee> abacusFeeList  = null;
		 try{
			 abacusFeeList  =  abacusFeeDao.findByStudentId(studentId);
		 }catch (NoResultException e) {
			
		}
		 return abacusFeeList;
		
	}
	
}
