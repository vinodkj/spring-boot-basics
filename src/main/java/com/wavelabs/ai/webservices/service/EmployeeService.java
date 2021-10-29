package com.wavelabs.ai.webservices.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.wavelabs.ai.webservices.model.Employee;

@Service
public class EmployeeService {

	private static List<Employee> empList = new ArrayList<>();

	static {
		empList.add(new Employee(123, "vinod", "vinodrajkj@gmail.com", "banagalore", "male"));
	}

	public Employee findById(int id) {
		for (Employee emp : empList) {
			if (emp.getId() == id) {
				return emp;
			} 
		}
	return null;

	}
	
	public Employee saveEmployee(Employee emp) {
		empList.add(emp);
		return emp;

	}
}	

