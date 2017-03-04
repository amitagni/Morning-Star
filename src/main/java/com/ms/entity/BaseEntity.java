/*******************************************************************************
 * Copyright (c) 2016 PWC Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the PWC License v1.0
 *
 * Contributors:
 *   PWC - initial API and implementation
 *******************************************************************************/
package com.ms.entity;

import java.io.Serializable;

public abstract class BaseEntity<K> implements Serializable {
	protected static final long serialVersionUID = 1L;
	protected String message;
	protected String error;

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public boolean equals(Object object) {
		if (object == this) {
			return true;
		}

		if (object == null || object.getClass() != this.getClass()) {
			return false;
		}

		if (getId() == null) {
			return false;
		}

		return getId().equals(((BaseEntity<K>) object).getId());
	}

	/**
	 * @return
	 */
	public abstract K getId();

	/**
	 * @param id
	 */
	public abstract void setId(K id);

	/**
	 * @return
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return
	 */
	public String getError() {
		return error;
	}

	/**
	 * @param error
	 */
	public void setError(String error) {
		this.error = error;
	}
}
