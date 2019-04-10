package com.letsstartcoding.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.letsstartcoding.model.Employee;
import com.letsstartcoding.repository.EmployeeRepository;

@Service
public class EmployeeDAO {

	@Autowired
	EmployeeRepository employeeRepository;

	public Employee save(Employee emp) {
		return employeeRepository.save(emp);
	}

	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	public Optional<Employee> findById(Long empid) {
		return employeeRepository.findById(empid);
	}

	public void delete(Employee emp) {
		employeeRepository.delete(emp);
	}

}