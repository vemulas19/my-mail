package com.facebook.validation;

public class Validation {

	public boolean nullCheck(String text) {
		System.out.println("Entered into nullCheck :: Validation");
		if(text == null) {
			return true;
		}
		
		System.out.println("Exiting from nullCheck :: Validation");
		return false;
	}
}
