package com.moretolearn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moretolearn.model.Employee;
import com.moretolearn.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@PostMapping
	public Employee saveEmployee(@RequestBody Employee employee) {
		return employeeService.saveEmployee(employee);
	}

	@GetMapping
	public List<Employee> getEmployees() {
		return employeeService.getEmployees();
	}

	@GetMapping("/{empId}")
	public Employee getEmployee(@PathVariable Integer empId) {
		return employeeService.getEmployee(empId);
	}

	@PutMapping("/{empId}")
	public Employee updateEmployee(@PathVariable Integer empId, @RequestBody Employee employee) {
		return employeeService.updateEmployee(empId, employee);
	}

	@DeleteMapping("/{empId}")
	public String deleteEmployee(@PathVariable Integer empId) {
		return employeeService.deleteEmployee(empId);
	}

	@GetMapping("/emp/{pageNo}")
	public List<Employee> getUserList(@PathVariable("pageNo") int pageNo) {
		List<Employee> users = employeeService.getEmployeeByPageAndSort(pageNo - 1, 5);
		return users;
	}
}
