package com.bridgelabz.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.bridgelabz.annotation.ValidUser;
import com.bridgelabz.model.User;

public class UserValidator implements ConstraintValidator<ValidUser, User> {

	@Override
	public void initialize(ValidUser constraintAnnotation) {
		
		
	}

	@Override
	public boolean isValid(User user, ConstraintValidatorContext context) {
		boolean isValid = true;
		context.disableDefaultConstraintViolation();
		if (!validateEmail(user.getEmail())) {
			context.buildConstraintViolationWithTemplate("Invalid email id").addConstraintViolation();
			isValid = false;
		}
		if (!validateMobile(user.getMobileNumber())) {
			context.buildConstraintViolationWithTemplate("Invalid mobile number").addConstraintViolation();
			isValid = false;
		}
		return isValid;
	}
	
	private boolean validateEmail(String email) {
		Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
		return matcher.find();
	}
	
	private boolean validateMobile(String mobile) {
		Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[0-9]{10}$", Pattern.CASE_INSENSITIVE);
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(mobile);
		return matcher.find();
	}

}
