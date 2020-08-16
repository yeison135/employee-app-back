package com.bdb.employee.controller;

import com.bdb.employee.dto.EmployeeDto;
import com.bdb.employee.model.Employee;
import com.bdb.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(path = "/employee")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<Employee> getAllUsers() {
        return employeeRepository.findAll();
    }

    @PostMapping(path = "/add")
    public @ResponseBody
    boolean addNewUser(@RequestBody EmployeeDto employeeDto) {
        Employee employee = new Employee();
        employee.setFullName(employeeDto.getFullName());
        employee.setFunctionEmployee(employeeDto.getFunctionEmployee());
        employeeRepository.save(employee);
        return true;
    }

    @PostMapping(path = "/delete")
    public @ResponseBody
    boolean deleteUser(@RequestBody EmployeeDto employeeDto) {
        Optional<Employee> employee = employeeRepository.findById(employeeDto.getId());
        if (employee.isPresent()) {
            employeeRepository.delete(employee.get());
            return true;
        } else {
            return false;
        }
    }

    @PostMapping(path = "/update")
    public @ResponseBody
    boolean UpdateUser(@RequestBody EmployeeDto employeeDto) {
        Optional<Employee> employee = employeeRepository.findById(employeeDto.getId());
        if (employee.isPresent()) {
            employeeRepository.save(employee.get());
            return true;
        } else {
            return false;
        }
    }
}
