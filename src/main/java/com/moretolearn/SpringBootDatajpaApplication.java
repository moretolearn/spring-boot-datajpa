package com.moretolearn;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.moretolearn.model.Employee;
import com.moretolearn.service.EmployeeService;

@SpringBootApplication
public class SpringBootDatajpaApplication implements CommandLineRunner{
	
	@Autowired
	EmployeeService employeeService;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDatajpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		for (int i = 1; i <= 30; i++) {
			employeeService.saveEmployee(new Employee(i, "Ram"+i, 23423.0+i, "desc"+i));
		}
		
	}

}
