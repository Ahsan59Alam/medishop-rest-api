package com.jsp.medishop.exception;

/**
 * @author Ahsan Alam
 */
@SuppressWarnings("serial")
public class InvalidUserCredentialException extends RuntimeException {

	public InvalidUserCredentialException() {
		super("Invailid user details!!! User data is not present in Database"
				+ " Or Please check your email and password");
	}

	public InvalidUserCredentialException(String str) {
		super(str);
	}
}
