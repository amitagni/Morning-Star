package com.ms.util;

/**
 * @author Om Yadav 
 * PwcException- General purpose exception class
 */
public class MSException extends java.lang.Exception {

	private static final long serialVersionUID = -4581740387522086879L;

	public MSException(String message, Throwable cause) {
		super(message, cause);
	}

	public MSException(Throwable cause) {
		super(cause);
	}

	public MSException(String message) {
		super(message);
	}
}
