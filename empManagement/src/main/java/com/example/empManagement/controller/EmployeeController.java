package com.example.empManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.empManagement.model.Employee;
import com.example.empManagement.model.ErrorClazz;
import com.example.empManagement.service.EmployeeService;



@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	@GetMapping("/all")
	public  List<Employee> getAllEmployees(){
		return  employeeService.getAllEmployees();
	}
	
	@PostMapping("/add")
	public Employee saveEmployee(@RequestBody Employee employee) {
		return employeeService.saveEmployee(employee);
		
	}
	@PutMapping("/update/{id}")
	public Employee updateEmployee( @RequestBody Employee employee, @PathVariable Long id)
	{
		
	 return	employeeService.updateEmployee(employee,id);
	}
	
	@DeleteMapping("/{id}")
	public void deleteEmployee(@PathVariable Long id)
	{
	
		  employeeService.deleteEmployee(id);
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> getProduct(@PathVariable Long id) {
		Employee employee = employeeService.getEmployee(id);
		if (employee == null) {
			ErrorClazz errorclazz = new ErrorClazz(202, "Employee doesnt exist");
			return new ResponseEntity<ErrorClazz>(errorclazz, HttpStatus.OK);
		} else
			return new ResponseEntity<Employee>(employee, HttpStatus.OK);

	}
	

}
