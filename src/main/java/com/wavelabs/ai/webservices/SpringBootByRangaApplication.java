package com.wavelabs.ai.webservices;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.ResourceUtils;

import com.wavelabs.ai.webservices.model.Employee;

@SpringBootApplication
public class SpringBootByRangaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootByRangaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(" strated run method");
		try {
			 File file=ResourceUtils.getFile("classpath:employee.csv");
		BufferedReader reader=new BufferedReader(new FileReader(file, StandardCharsets.UTF_8));
		String line=null;
		List<String> list=new ArrayList<>();
		reader.readLine();
		while ((line = reader.readLine()) != null) {
			String[] split = line.split(",");
			Employee emp=new Employee();
			emp.setId(Long.parseLong(split[0]));
			emp.setName(split[1]);
			emp.setEmail(split[2]);
			emp.setAddress(split[3]);
			emp.setGender(split[3]);
			
             System.out.println(emp);
		}
		reader.close();
		
		}catch (Exception e) {
		
			
		}
		
	}

}
