package com.jsp.medishop.verification;

import java.util.regex.Pattern;

public class EmailPasswordVerification {
	
	public String verifyEmail(String email) {
		
		boolean alphabet=Pattern.compile("[a-zA-Z]").matcher(email).find();
		boolean number=Pattern.compile("[0-9]").matcher(email).find();
		boolean special=Pattern.compile("[@,.]").matcher(email).find();
		
		if ((alphabet && number && special)) {
			return email;
			
		}else {
			return null;
		}
				
	
	
	}
	
	public String VerifyPassword(String password) {
		
		boolean alphabet=Pattern.compile("[a-zA-Z]").matcher(password).find();
		boolean number=Pattern.compile("[0-9]").matcher(password).find();
		boolean special=Pattern.compile("[@.#$%^&*!]").matcher(password).find();
		
		int length=password.length();
		
		if ((alphabet && number && special) && (length>=8 && length<=16)) {
			return password;
			
		}else {
			return null;
		}
		 
	}

}
