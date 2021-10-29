package com.wavelabs.ai.webservices.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.wavelabs.ai.webservices.exception.UserNotFoundException;
import com.wavelabs.ai.webservices.model.Employee;
import com.wavelabs.ai.webservices.model.UserRegistration;
import com.wavelabs.ai.webservices.service.EmployeeService;
import com.wavelabs.ai.webservices.service.UserRegistrationService;

@Controller
@ResponseBody
public class SampleController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private UserRegistrationService userRegistrationService;

	@GetMapping(path = "getemployee")
	public ResponseEntity<Object> getEmployee() {

		Employee employee = new Employee();
		employee.setAddress("Banaglore");
		employee.setEmail("Vinod@gmail.com");
		employee.setId(123);
		employee.setName("vinod");
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(employee.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@GetMapping(path = "employee/{empId}")
	public EntityModel<Employee> getEmployeeById(@PathVariable int empId) {
		Employee findById = employeeService.findById(empId);
		if (findById == null) {
			throw new UserNotFoundException("User doesn't exist ->" + empId);
		}
		EntityModel<Employee> entityModel = EntityModel.of(findById);
		WebMvcLinkBuilder linkTo = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getEmployee());
		entityModel.add(linkTo.withRel("AllUserdetails"));
		WebMvcLinkBuilder linkTo2 = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).saveEmployee(findById));
		entityModel.add(linkTo2.withRel("Save employee"));
		return entityModel;

	}
	
	@PostMapping(path = "employee/save")
	public ResponseEntity<Object> saveEmployee(@Valid @RequestBody Employee emp) {
		Employee saveEmployee = employeeService.saveEmployee(emp);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(saveEmployee).toUri();
		return ResponseEntity.created(uri).build();

	}
	
	@GetMapping("internalization")
	public ResponseEntity<List<String>> getMessage() {

		List<String> messages = new ArrayList<>();
		messages.add(
				messageSource.getMessage("good.morning", null, "Default Message", LocaleContextHolder.getLocale()));
		messages.add(
				messageSource.getMessage("good.afternoon", null, "Default Message", LocaleContextHolder.getLocale()));
		messages.add(messageSource.getMessage("How.are.u", null, "Default Message", LocaleContextHolder.getLocale()));
		return ResponseEntity.status(HttpStatus.OK).body(messages);

	}
	
	
// example of dynamic filter
	@GetMapping("getUsers")
	public ResponseEntity<MappingJacksonValue> getUserRegistration() {
		List<UserRegistration> allUsers = userRegistrationService.getAllUsers();
		MappingJacksonValue mapping=new MappingJacksonValue(allUsers);
		SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter.filterOutAllExcept("name","email","userName");
		FilterProvider filetr=new SimpleFilterProvider().addFilter("userRegistration", filter);
		
		mapping.setFilters(filetr);
		return ResponseEntity.status(HttpStatus.OK).body(mapping);
	}
	
	
	

}
