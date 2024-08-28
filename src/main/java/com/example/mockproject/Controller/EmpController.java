package com.example.mockproject.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.mockproject.Services.EmployeeService;
import com.example.mockproject.model.Employee;

@RestController
@CrossOrigin("http://localhost:8080/index.html")
public class EmpController {
//	List<Employee> employees = new ArrayList<>();
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("employees")
	public List<Employee> getAllEmployees() {
		
		return employeeService.readEmployees();
	}
	
	@GetMapping("employees/{id}")
	public Employee getEmployeesById(@PathVariable Long id) {
		
		return employeeService.readEmployee(id);
	}
	
	@PostMapping("employees")
	public String createEmployee(@RequestBody Employee employee) {
		
		if (employee == null) {
			System.out.println("Employee Data is missing...");
		}
		//employees.add(employee);
		return employeeService.createEmployee(employee);
		
	}	
	
	@DeleteMapping("employees/{id}")
	public String deleteEmployee(@PathVariable Long id) {
		if(employeeService.deleteEmployee(id)) {
			return "Deleted Successfully...";
		}
		
		return "Not Found";
	}
	
	@PutMapping("employees/{id}")
	public String putMethodName(@PathVariable Long id, @RequestBody Employee employee) {
		
		return employeeService.updateEmployee(id, employee);
	}
	
	
}
