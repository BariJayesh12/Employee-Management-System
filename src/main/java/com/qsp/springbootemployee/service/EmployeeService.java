package com.qsp.springbootemployee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.qsp.springbootemployee.dao.EmployeeDao;
import com.qsp.springbootemployee.dto.Employee;
import com.qsp.springbootemployee.exception.EmailNotFound;
import com.qsp.springbootemployee.exception.IdNotFound;
import com.qsp.springbootemployee.exception.PhoneNotFound;
import com.qsp.springbootemployee.exception.SalaryNotFound;
import com.qsp.springbootemployee.util.ResponseStructure;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeDao dao;

	public ResponseEntity<ResponseStructure<Employee>> saveEmployee(Employee employee) {
		double salary = employee.getSalary();
		if (salary < 10000) {
			employee.setGrade('A');
		} else if (salary >= 10000 && salary < 20000) {
			employee.setGrade('B');
		} else if (salary >= 20000 && salary < 40000) {
			employee.setGrade('C');
		} else {
			employee.setGrade('D');
		}
		ResponseStructure<Employee> structure = new ResponseStructure<Employee>();
		structure.setMessage("Saved Successfully");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(dao.saveEmployee(employee));
		return new ResponseEntity<ResponseStructure<Employee>>(structure, HttpStatus.CREATED);

	}

	public ResponseEntity<ResponseStructure<Employee>> findEmployee(int id) {
		Employee employee = dao.findEmployee(id);
		ResponseStructure<Employee> structure = new ResponseStructure<Employee>();
		if (employee != null) {

			structure.setMessage("Found Successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(dao.findEmployee(id));
			return new ResponseEntity<ResponseStructure<Employee>>(structure, HttpStatus.FOUND);

		} else {

			/*structure.setMessage("Not Found");
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setData(dao.findEmployee(id));
			return new ResponseEntity<ResponseStructure<Employee>>(structure, HttpStatus.NOT_FOUND);*/
			
			throw new IdNotFound("Id Not Found");
		}

	}

	public ResponseEntity<ResponseStructure<Employee>> deleteEmployee(int id) {

		Employee employee = dao.findEmployee(id);
		ResponseStructure<Employee> structure = new ResponseStructure<Employee>();
		if (employee != null) {

			structure.setMessage("Delete Successfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dao.deleteEmployee(id));
			return new ResponseEntity<ResponseStructure<Employee>>(structure, HttpStatus.OK);

		} else {

			throw new IdNotFound("Id Not Found");
		}

	}

	public ResponseEntity<ResponseStructure<List<Employee>>> findAllEmployee() {

		List<Employee> list = dao.findAllEmployee();
		ResponseStructure<List<Employee>> structure = new ResponseStructure<List<Employee>>();

		if (list.isEmpty()) {
			structure.setMessage("Not Found");
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setData(list);
			return new ResponseEntity<ResponseStructure<List<Employee>>>(structure, HttpStatus.NOT_FOUND);

		} else {

			structure.setMessage("Found Successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(list);
			return new ResponseEntity<ResponseStructure<List<Employee>>>(structure, HttpStatus.FOUND);

		}

	}

	public ResponseEntity<ResponseStructure<Employee>> updateEmployee(int id, Employee employee) {

		Employee employee1 = dao.findEmployee(id);
		ResponseStructure<Employee> structure = new ResponseStructure<Employee>();
		if (employee1 != null) {

			double salary = employee.getSalary();
			if (salary < 10000) {
				employee.setGrade('A');
			} else if (salary >= 10000 && salary < 20000) {
				employee.setGrade('B');
			} else if (salary >= 20000 && salary < 40000) {
				employee.setGrade('C');
			} else {
				employee.setGrade('D');
			}

			structure.setMessage("found Successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(dao.updateEmployee(id, employee));
			return new ResponseEntity<ResponseStructure<Employee>>(structure, HttpStatus.FOUND);
		} else {
			throw new IdNotFound("Id Not Found");
		}

	}

	public ResponseEntity<ResponseStructure<Employee>> updateEmail(int id, String email) {

		Employee employee = dao.findEmployee(id);
		ResponseStructure<Employee> structure = new ResponseStructure<Employee>();
		if (employee != null) {
			employee.setEmail(email);
			structure.setMessage("found Successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(dao.updateEmployee(id, employee));
			return new ResponseEntity<ResponseStructure<Employee>>(structure, HttpStatus.FOUND);

		} else {

			throw new IdNotFound("Id Not Found");

		}

	}

	public ResponseEntity<ResponseStructure<Employee>> updateSalary(int id, double salary) {

		Employee employee = dao.findEmployee(id);
		ResponseStructure<Employee> structure = new ResponseStructure<Employee>();
		if (employee != null) {
			employee.setSalary(salary);
			if (salary < 10000) {
				employee.setGrade('A');
			} else if (salary >= 10000 && salary < 20000) {
				employee.setGrade('B');
			} else if (salary >= 20000 && salary < 40000) {
				employee.setGrade('C');
			} else {
				employee.setGrade('D');
			}
			structure.setMessage("found Successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(dao.updateEmployee(id, employee));
			return new ResponseEntity<ResponseStructure<Employee>>(structure, HttpStatus.FOUND);

		} else {

			throw new IdNotFound("Id Not Found");

		}

	}

	public ResponseEntity<ResponseStructure<Employee>>  updateAddress(int id, String address) {

		Employee employee = dao.findEmployee(id);
		ResponseStructure<Employee> structure = new ResponseStructure<Employee>();
		if (employee != null) {
			employee.setAddress(address);
			structure.setMessage("found Successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(dao.updateEmployee(id, employee));
			return new ResponseEntity<ResponseStructure<Employee>>(structure, HttpStatus.FOUND);

		} else {

			throw new IdNotFound("Id Not Found");

		}

		

	}

	public ResponseEntity<ResponseStructure<Employee>>  findByEmail(String email) {

		Employee employee = dao.findByEmail(email);
		ResponseStructure<Employee> structure = new ResponseStructure<Employee>();
		if (employee != null) {

			structure.setMessage("Found Successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(dao.findByEmail(email));
			return new ResponseEntity<ResponseStructure<Employee>>(structure, HttpStatus.FOUND);
		} else {

			throw new EmailNotFound("Email Not Found");
		}

		

	}

	public ResponseEntity<ResponseStructure<Employee>>  getByPhone(long phone) {

		Employee employee = dao.getByPhone(phone);
		ResponseStructure<Employee> structure = new ResponseStructure<Employee>();
		if (employee != null) {

			structure.setMessage("Found Successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(dao.getByPhone(phone));
			return new ResponseEntity<ResponseStructure<Employee>>(structure, HttpStatus.FOUND);
		} else {

			throw new PhoneNotFound("PHONE NOT FOUND");

		}

		

	}

	public ResponseEntity<ResponseStructure<List<Employee>>> findSalaryGreaterThan(long salary) {

		List<Employee> list = dao.findSalaryGreaterThan(salary);
		ResponseStructure<List<Employee>> structure = new ResponseStructure<List<Employee>>();

		if (list.isEmpty()) {
			throw new SalaryNotFound("SALARY NOT FOUND");
		} else {

			structure.setMessage("Found Successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(list);
			return new ResponseEntity<ResponseStructure<List<Employee>>>(structure, HttpStatus.FOUND);
		}

		

	}

	public ResponseEntity<ResponseStructure<List<Employee>>>  findSalaryLessThan(long salary) {

		List<Employee> list = dao.findSalaryLessThan(salary);
		ResponseStructure<List<Employee>> structure = new ResponseStructure<List<Employee>>();

		if (list.isEmpty()) {
			throw new SalaryNotFound("SALARY NOT FOUND");

		} else {

			structure.setMessage("Found Successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(list);
			return new ResponseEntity<ResponseStructure<List<Employee>>>(structure, HttpStatus.FOUND);
		}

		
	}
}
