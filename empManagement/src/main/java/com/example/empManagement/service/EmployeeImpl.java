 package com.example.empManagement.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.empManagement.model.Employee;
import com.example.empManagement.model.EmployeeAlreadyExistsException;
import com.example.empManagement.model.EmployeeNotFoundException;
import com.example.empManagement.repository.EmployeeRepository;


import jakarta.transaction.Transactional;

@Service
@Transactional
public class EmployeeImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		if (employeeAlreadyExists(employee.getEmail())) {
			throw new EmployeeAlreadyExistsException(employee.getEmail()+"already exists");
			
		}
		return employeeRepository.save(employee);
	}

	private boolean employeeAlreadyExists(String email) {
		// TODO Auto-generated method stub
		return employeeRepository.findByEmail(email).isPresent();
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

//	@Override
//	public Employee updateEmployee(Employee employee) {
//		// TODO Auto-generated method stubs
//		return employeeRepository.save(employee);
//		
//		
//	}

	@Override
	public Employee getEmployee(Long id) {
		// TODO Auto-generated method stub		
//				
//				Optional<Employee> optional = employeeRepository.findById(id);
//		if(optional.isPresent())
//			return optional.get();
//		else {
//			return null;
//		}
		return employeeRepository.findById(id).get();
	}

	@Override
	public void deleteEmployee(Long id) {
		// TODO Auto-generated method stub
		if(!employeeRepository.existsById(id)) {
			throw new EmployeeNotFoundException("sorry ,employee not found");
		}
		employeeRepository.deleteById(id);

	}

	@Override
	public Employee updateEmployee(Employee employee, Long id) {
		// TODO Auto-generated method stub
		
		Employee  getEmployee=employeeRepository.findById(id).get();
		getEmployee.setFirstName(employee.getLastName());
		getEmployee.setLastName(employee.getLastName());
		getEmployee.setEmail(employee.getEmail());
		getEmployee.setDepartment(employee.getDepartment());
		return employeeRepository.save(getEmployee);
		
		
	} 

	

}
