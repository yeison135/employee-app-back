package com.bdb.employee.repository;

import com.bdb.employee.model.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface  EmployeeRepository extends CrudRepository<Employee, Long> {

    @Override
    Optional<Employee> findById(Long aLong);

    Optional<Employee> findEmployeeByFullName(String fullName);

}
