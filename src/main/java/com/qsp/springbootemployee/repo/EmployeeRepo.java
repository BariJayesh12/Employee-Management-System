package com.qsp.springbootemployee.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.qsp.springbootemployee.dto.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
	
	Employee findEmployeeByEmail(String email);
	
	//Employee getEmployeeByPhone(long phone);
	
	@Query("select e from Employee e where e.phone=?1")
	Employee empByPhone(long phone);
	
	List<Employee> findEmployeeBySalaryGreaterThan(double salary);
	
	//List<Employee> findEmployeeBySalaryLessThan(double salary); //LessThan (key word)
	
	@Query("select e from Employee e where e.salary<=?1")
	List<Employee> findEmployeeBySalaryLesssThan(double salary);// custom query writing as your own expectation


}
