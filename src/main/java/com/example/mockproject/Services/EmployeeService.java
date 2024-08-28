package com.example.mockproject.Services;

import java.util.List;

import com.example.mockproject.model.Employee;

public interface EmployeeService {

	String createEmployee(Employee employee);
	List<Employee> readEmployees();
	boolean deleteEmployee(Long id);
	String updateEmployee(Long id, Employee employee);
	Employee readEmployee(Long id);
}
