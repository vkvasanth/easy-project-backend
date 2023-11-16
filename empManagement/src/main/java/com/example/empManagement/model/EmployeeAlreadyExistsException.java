package com.example.empManagement.model;

public class EmployeeAlreadyExistsException extends RuntimeException {

	public EmployeeAlreadyExistsException(String message)
	{
		super(message);
	}
}
