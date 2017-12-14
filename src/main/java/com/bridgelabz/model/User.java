package com.bridgelabz.model;

import com.bridgelabz.annotation.Email;
import com.bridgelabz.annotation.Mobile;

public class User {
	
	@Email
	String email;

	@Mobile
	String mobileNumber;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

}
