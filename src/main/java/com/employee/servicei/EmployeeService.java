package com.employee.servicei;

import java.util.List;

import com.employee.model.Employee;

public interface EmployeeService {
	
	public void saveData(Employee e);
	
	public List<Employee> getallData();
	
	public void deleteData(int id);
	
	public Employee getEmployeebyId(int id);

}
