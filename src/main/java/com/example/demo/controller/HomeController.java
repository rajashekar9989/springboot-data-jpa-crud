package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;

@RestController
@RequestMapping("/Employee")
public class HomeController {
	
	
	@Autowired
	 private EmployeeRepository employeerepository;
	
	
	Employee employee;
	
	@GetMapping("/home")
	public String index() {
		
		return " welcome to spring boot crud application ! " ;
	}
	
	
	
	
	@PostMapping("/save")
	public Employee saveEmployee( @RequestBody  Employee employee) {
		
		employeerepository.save(employee);
		
		return employee;
		

	}
	
	
	@GetMapping("/getById/{empid}")
	public Employee getEmployeeByid(@PathVariable int empid) {
		
		
		Optional<Employee> emp =employeerepository.findById(empid);
		
		Employee emp1=emp.get();
		
		return emp1; 
		
		
		
	}
	
	
	@GetMapping("/get")
	public List<Employee> getAll(){
		
		List<Employee> emplist = employeerepository.findAll();
		
		return emplist;
		 
	}
	
	
	@DeleteMapping("/deleteEmployee/{empid}")
	public String deleteEmployee(@PathVariable int empid) {
		
		Employee employee =employeerepository.findById(empid).get();
		
		if(employee!=null) 
			
			employeerepository.delete(employee);
		
		return "Employee deleted succesfully";
		
		
		
}
	
	
	
	@PutMapping("/updateEmployee")
	public Employee updateEmployee(@RequestBody Employee employee) {
		
		employeerepository.save(employee);
		
		return employee;
		
		
	}
}
	
	
	
	
	
	


