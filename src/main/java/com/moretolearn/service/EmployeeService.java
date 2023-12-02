package com.moretolearn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.moretolearn.model.Employee;
import com.moretolearn.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	public List<Employee> getEmployees() {
		return employeeRepository.findAll();
	}
	
	public Employee getEmployee(Integer empId) {
		return employeeRepository.findById(empId).get();
	}
	
	public Employee updateEmployee(Integer empId, Employee employee) {
//		Employee employee2 = employeeRepository.findById(empId).get();
		return employeeRepository.save(employee);
		
	}
	
	public String deleteEmployee(Integer empId) {
		employeeRepository.deleteById(empId);
		return "delete";
	}
	
	public List<Employee> getEmployeeByPageAndSort(Integer pageNo, Integer pageSize){
		Sort sort = Sort.by("empId").and(Sort.by("empName").reverse()).descending();
		Pageable paging =  PageRequest.of(pageNo, pageSize, sort);
        Page<Employee> pagedResult = employeeRepository.findAll(paging);
       
        System.out.println("total element.... "  +   pagedResult.getTotalElements());
        System.out.println("total pages.... "  +   pagedResult.getTotalPages());
        System.out.println("current page.... "  +   pagedResult.getNumber());
        System.out.println("no of elements in a page.... "  +   pagedResult.getNumberOfElements());
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return List.of();
        }
	}
}
