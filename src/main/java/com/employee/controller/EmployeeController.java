package com.employee.controller;

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

import com.employee.model.Employee;
import com.employee.servicei.EmployeeService;

@CrossOrigin("*")
@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/getAllData")
	public List<Employee> getAllData(){
		List<Employee> emplist= employeeService.getallData();
		return emplist;
	}
	
	@GetMapping("/getsingleData/{id}")
	public Employee getsingleData(@PathVariable int id)
	{
		Employee e= employeeService.getEmployeebyId(id);
		return e;
	}
	
	@PostMapping("/addData")
	public Employee addData(@RequestBody Employee e)
	{
		employeeService.saveData(e);
		return e;
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteData(@PathVariable int id) {
		employeeService.deleteData(id);
		
	}
	
	@PutMapping("/update/{id}")
	public Employee updateData(@RequestBody Employee e, @PathVariable int id) {
		Employee updateEmp=  employeeService.getEmployeebyId(id);
		updateEmp.setName(e.getName());
		updateEmp.setEmail(e.getEmail());
		updateEmp.setContact(e.getContact());
		updateEmp.setSalary(e.getSalary());
		
		employeeService.saveData(updateEmp);
		return updateEmp;
	}

}
