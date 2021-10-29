package com.wavelabs.ai.webservices.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.wavelabs.ai.webservices.model.UserRegistration;

@Service
public class UserRegistrationService {

	private static List<UserRegistration> userList = new ArrayList<>();

	static {
		userList.add(new UserRegistration("vinod", "vinodkj", "vinod123", "vinod@123"));
		userList.add(new UserRegistration("vino", "vino", "vino123", "vind@123"));
		userList.add(new UserRegistration("rajo", "raj", "raj", "raj@123"));
		userList.add(new UserRegistration("kumar", "kumi", "kumi123", "kumi@gmail.com"));

	}

	public List<UserRegistration> getAllUsers() {
		return userList;

	}

}
