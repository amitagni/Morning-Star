/*******************************************************************************
* Copyright (c) 2016 PWC Corporation and others.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the PWC License v1.0
*
* Contributors:
* PWC - initial API and implementation
*******************************************************************************/
package com.ms.dao;

import java.sql.Types;

import org.hibernate.Hibernate;
import org.hibernate.dialect.MySQLDialect;
import org.hibernate.dialect.function.StandardSQLFunction;

public class CustomeDialect extends MySQLDialect {
	/**
	 * 
	 */
	public CustomeDialect() {
		registerFunction("group_concat", new StandardSQLFunction("group_concat", Hibernate.STRING));
		registerFunction("coalesce", new StandardSQLFunction("coalesce", Hibernate.STRING));
		registerHibernateType(Types.LONGVARCHAR, Hibernate.TEXT.getName());

	}
}
