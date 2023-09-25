package com.qsp.springbootemployee.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//import com.qsp.springbootemployee.dao.EmployeeDao;
import com.qsp.springbootemployee.dto.Employee;
import com.qsp.springbootemployee.service.EmployeeService;
import com.qsp.springbootemployee.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class EmployeeController {
	// @Autowired
	// private EmployeeDao dao;

	@Autowired
	private EmployeeService service;

	@PostMapping("/save")
	@ApiOperation(value = "Save Employee", notes = "This Api Is Used to Save the Employee data in Database")
	@ApiResponses(value = {@ApiResponse(code=201,message="Data Saved Successfull")})
	public ResponseEntity<ResponseStructure<Employee>> saveEmployee(@Valid @RequestBody Employee employee) {
		return service.saveEmployee(employee);

	}

	@GetMapping("/find")
	@ApiOperation(value = "Find the Employee", notes = "This Api Is Used to find the Employee data in Database")
	@ApiResponses(value = {@ApiResponse(code=302,message="Data Found Successfull")})
	public ResponseEntity<ResponseStructure<Employee>> findEmployee(@RequestParam int id) {
		return service.findEmployee(id);
	}

	@GetMapping("/findall")
	public ResponseEntity<ResponseStructure<List<Employee>>> findAllEmployee() {
		return service.findAllEmployee();

	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ResponseStructure<Employee>> deleteEmployee(@PathVariable int id) {

		return service.deleteEmployee(id);
	}

	/*
	 * @DeleteMapping("/delete") public Employee deleteEmployee(@RequestParam int
	 * id) { return dao.deleteEmployee(id); }
	 */

	@PutMapping("/update")
	public ResponseEntity<ResponseStructure<Employee>> updateEmployee(@RequestParam int id,
			@RequestBody Employee employee) {
		return service.updateEmployee(id, employee);
	}

	@PatchMapping("/updateemail/{id}")
	public ResponseEntity<ResponseStructure<Employee>> updateEmail(@PathVariable int id, @RequestParam String email) {

		return service.updateEmail(id, email);
	}

	@PatchMapping("/updatesalary/{id}")
	public ResponseEntity<ResponseStructure<Employee>> updateSalary(@PathVariable int id, @RequestParam double salary) {
		return service.updateSalary(id, salary);
	}

	@PatchMapping("/updateaddress/{id}")
	public ResponseEntity<ResponseStructure<Employee>> updateAddress(@PathVariable int id,
			@RequestParam String address) {

		return service.updateAddress(id, address);

	}

	@GetMapping("/findByEmail")
	public ResponseEntity<ResponseStructure<Employee>> findByEmail(@RequestParam String email) {
		return service.findByEmail(email);

	}

	@GetMapping("/getByPhone")
	public ResponseEntity<ResponseStructure<Employee>> getByPhone(@RequestParam long phone) {
		return service.getByPhone(phone);
	}

	@GetMapping("/greaterthan")
	public ResponseEntity<ResponseStructure<List<Employee>>> findSalaryGreaterThan(@RequestParam long salary) {
		return service.findSalaryGreaterThan(salary);
	}

	@GetMapping("/lessthan")
	public ResponseEntity<ResponseStructure<List<Employee>>> findSalaryLessThan(@RequestParam long salary) {
		return service.findSalaryLessThan(salary);
	}
}
