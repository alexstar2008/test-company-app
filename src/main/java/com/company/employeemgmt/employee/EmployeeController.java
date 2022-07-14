package com.company.employeemgmt.employee;

import com.company.employeemgmt.common.UpsertEntityRes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.validation.Valid;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping()
    public List<Employee> getEmployees() {
        return employeeService.getEmployees();
    }

    @PostMapping()
    public UpsertEntityRes createEmployee(@Valid @RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }

    @PutMapping(value = "/{id}")
    public UpsertEntityRes updateEmployee(@PathVariable(value = "id") Long id, @Valid @RequestBody Employee employee) {
        return employeeService.updateEmployee(id, employee);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteEmployee(@PathVariable(value = "id") Long id) {
        employeeService.deleteEmployee(id);
    }

    @PostMapping(value = "/assign-to-department")
    public void assignEmployeeToDepartment(@Valid @RequestBody EmployeeDepartmentAssign employeeDepartmentAssign) {
        employeeService.assignEmployeeToDepartment(employeeDepartmentAssign);
    }
}
