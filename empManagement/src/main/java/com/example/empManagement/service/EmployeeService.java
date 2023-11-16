package com.example.empManagement.service;



import java.util.List;

import com.example.empManagement.model.Employee;

public interface EmployeeService {
//	Employee addEmployee (Employee employee);
	List<Employee> getAllEmployees();
	Employee getEmployee(Long id);
	void deleteEmployee(Long id);
//	Employee updateEmployee(Employee employee);
	Employee saveEmployee(Employee employee);
	Employee updateEmployee(Employee employee, Long id);


	


}
