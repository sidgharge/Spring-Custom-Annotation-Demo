package com.bridgelabz.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.model.User;

@RestController
public class HomeController {

	@RequestMapping(value = "/user", method = {RequestMethod.POST, RequestMethod.GET})
	public void test(@RequestBody @Valid User user2) {
	}
}
