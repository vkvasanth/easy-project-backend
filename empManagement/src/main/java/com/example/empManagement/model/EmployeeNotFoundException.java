package com.example.empManagement.model;

public class EmployeeNotFoundException extends RuntimeException {

	public EmployeeNotFoundException(String message)
	{
		super(message);
	}
}
