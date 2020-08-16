package com.bdb.employee.repository;

import com.bdb.employee.model.Employee;
import org.springframework.data.repository.CrudRepository;

public interface  EmployeeRepository extends CrudRepository<Employee, Long> {

    public Employee findEmployeeByFullNameLike(String fullName);

}
