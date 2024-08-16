package com.example.mockproject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmpController {

	@GetMapping("employees")
	public String getAllEmployees() {
		return "";
	}
}
