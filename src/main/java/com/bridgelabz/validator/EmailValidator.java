package com.bridgelabz.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.bridgelabz.annotation.Email;

public class EmailValidator implements ConstraintValidator<Email, String> {

	@Override
	public void initialize(Email arg0) {
		
	}

	@Override
	public boolean isValid(String email, ConstraintValidatorContext context) {
		return validateEmail(email);
	}
	
	private boolean validateEmail(String email) {
		Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
		return matcher.find();
	}

}
