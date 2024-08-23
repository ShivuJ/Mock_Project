package com.example.mockproject.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.example.mockproject.Repository.EmployeeRepository;
import com.example.mockproject.Services.EmployeeService;
import com.example.mockproject.model.Employee;
import com.example.mockproject.model.EmployeeEntity;

@Service
public class EmloyeeServiceImpl implements EmployeeService {

//	List<Employee> employees = new ArrayList<>();
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public String createEmployee(Employee employee) {
		
		EmployeeEntity employeeEntity = new EmployeeEntity();
		BeanUtils.copyProperties(employee, employeeEntity);
		
		employeeRepository.save(employeeEntity);
		
//		employees.add(employee);
		return "Saved Successfully...";
	}

	@Override
	public List<Employee> readEmployees() {
		List<EmployeeEntity> employeesList = employeeRepository.findAll();
		List<Employee> employees = new ArrayList<>();
		
		for (EmployeeEntity employeeEntity : employeesList) {
			Employee emp = new Employee();
			
			emp.setId(employeeEntity.getId());
			emp.setName(employeeEntity.getName());
			emp.setEmail(employeeEntity.getEmail());
			emp.setPhone(employeeEntity.getPhone());
			employees.add(emp);
		}
		return employees;

	}

	@Override
	public boolean deleteEmployee(Long id) {
//		employees.remove(id);
		return true;
	}

}
