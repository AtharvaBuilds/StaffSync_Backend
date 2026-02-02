package com.employee.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.model.Employee;
import com.employee.repository.EmployeeRepository;
import com.employee.servicei.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public void saveData(Employee e) {
		employeeRepository.save(e);
		
	}

	@Override
	public List<Employee> getallData() {
		List<Employee> emplist=(List<Employee>) employeeRepository.findAll();
		return emplist;
	}

	@Override
	public void deleteData(int id) {
		employeeRepository.deleteById(id);
		
	}

	@Override
	public Employee getEmployeebyId(int id) {
		Employee e= employeeRepository.findById(id).get();
		return e;
	}

}
