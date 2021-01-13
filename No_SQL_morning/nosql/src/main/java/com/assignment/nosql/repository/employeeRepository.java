package com.assignment.nosql.repository;

import com.assignment.nosql.model.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface employeeRepository extends CrudRepository<Employee, String> {

	List findByAddressAndPincode(String address, String pincode);
	   
}