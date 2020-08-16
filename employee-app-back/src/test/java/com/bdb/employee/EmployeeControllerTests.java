package com.bdb.employee;

import com.bdb.employee.controller.EmployeeController;
import com.bdb.employee.dto.EmployeeDto;
import com.bdb.employee.model.Employee;
import com.bdb.employee.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class EmployeeControllerTests {

    @InjectMocks
    private EmployeeController employeeController;

    @Mock
    private EmployeeRepository employeeRepository;

    @Test
    void givenGetUsersReturn() {
        Employee employee = new Employee();
        employee.setFunctionEmployee("Ingenier");
        employee.setFullName("Yeisson");
        List<Employee> employees = new ArrayList<>();
        employees.add(employee);
        Mockito.when(employeeRepository.findAll()).thenReturn(employees);
        assertThat(employeeController.getAllUsers()).isNotEmpty();
    }

    @Test
    void givenGetUsersReturnEmpty() {
        List<Employee> employees = new ArrayList<>();
        Mockito.when(employeeRepository.findAll()).thenReturn(employees);
        assertThat(employeeController.getAllUsers()).isEmpty();
    }

    @Test
    void givenAddNewUserReturnTrue() {
        Employee employee = new Employee();
        employee.setFunctionEmployee("Ingenier");
        employee.setFullName("Yeisson");
        Mockito.when(employeeRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(employee));
        assertThat(employeeController.addNewUser(new EmployeeDto())).isTrue();
    }


}
