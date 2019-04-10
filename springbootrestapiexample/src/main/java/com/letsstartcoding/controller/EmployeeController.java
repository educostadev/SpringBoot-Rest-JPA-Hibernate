package com.letsstartcoding.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.letsstartcoding.dao.EmployeeDAO;
import com.letsstartcoding.model.Employee;

@RestController
@RequestMapping("/company")
public class EmployeeController {

	@Autowired
	EmployeeDAO employeeDAO;

	/* to save an employee */
	@PostMapping("/employees")
	public Employee createEmployee(@Valid @RequestBody Employee emp) {
		return employeeDAO.save(emp);
	}

	/* get all employees */
	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
		return employeeDAO.findAll();
	}

	/* get employee by id */
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long empid) {

		Optional<Employee> emp = employeeDAO.findById(empid);

		if (emp.isPresent()) {
			return ResponseEntity.ok().body(emp.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping
	public ModelAndView listAll() {
		List<Employee> all = employeeDAO.findAll();
		ModelAndView modelView = new ModelAndView("employees");
		modelView.addObject("employees", all);
		return modelView;
	}

	/* update an employee by empid */
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long empid,
			@Valid @RequestBody Employee empDetails) {

		Optional<Employee> empOpt = employeeDAO.findById(empid);
		if (!empOpt.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Employee emp = empOpt.get();
		emp.setName(empDetails.getName());
		emp.setDesignation(empDetails.getDesignation());
		emp.setExpertise(empDetails.getExpertise());

		Employee updateEmployee = employeeDAO.save(emp);
		return ResponseEntity.ok().body(updateEmployee);

	}

	/* Delete an employee */
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable(value = "id") Long empid) {

		Optional<Employee> empOpt = employeeDAO.findById(empid);

		if (!empOpt.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Employee emp = empOpt.get();
		employeeDAO.delete(emp);

		return ResponseEntity.ok().build();

	}

}