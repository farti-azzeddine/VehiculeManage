package com.vehicule.manage.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vehicule.manage.models.Employee;
import com.vehicule.manage.repositories.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
//	return list of Employee 
	public List<Employee> getEmployee(){
		return employeeRepository.findAll();
	}

	//save a new Employee
	public void save(Employee employee) {
		employeeRepository.save(employee);
	}
	
//	find country by id
	public Optional<Employee> findById(int id) {
		return employeeRepository.findById(id); 
	}

	public void delete(int id) {
		employeeRepository.deleteById(id);
		
	}

	public Employee findByUsername(String un) {
		// TODO Auto-generated method stub
		return employeeRepository.findByUsername(un);
	}

}
