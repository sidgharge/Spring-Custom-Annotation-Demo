package com.bridgelabz.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.bridgelabz.annotation.Mobile;

public class MobileValidator implements ConstraintValidator<Mobile, String> {

	@Override
	public void initialize(Mobile constraintAnnotation) {
		
	}

	@Override
	public boolean isValid(String mobile, ConstraintValidatorContext context) {
		context.buildConstraintViolationWithTemplate("Error in mobile number").addConstraintViolation();
		context.disableDefaultConstraintViolation();
		return validateMobile(mobile);
	}
	
	private boolean validateMobile(String mobile) {
		Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[0-9]{10}$", Pattern.CASE_INSENSITIVE);
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(mobile);
		return matcher.find();
	}

}
