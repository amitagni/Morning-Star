/*******************************************************************************
* Copyright (c) 2016 PWC Corporation and others.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the PWC License v1.0
*
* Contributors:
* PWC - initial API and implementation
*******************************************************************************/
/**
 * 
 */
package com.ms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ms.bean.Login;
import com.ms.dao.UserDao;
import com.ms.entity.User;
import com.ms.util.EncryptionUtil;
import com.ms.util.MSException;



/**
 * @author Apple
 *
 */

@Service
public class LoginService {

	@Autowired
	private UserDao userDao;

	/**
	 * @param login
	 * @return
	 * @throws PwcException
	 */
	public User authenticate(Login login) throws MSException {
		return userDao.findByEmailAndPassword(login.getEmail(), EncryptionUtil.md5Encrypt(login.getPassword()));

	}

}
