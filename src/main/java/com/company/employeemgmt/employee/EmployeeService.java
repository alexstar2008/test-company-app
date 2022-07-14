package com.company.employeemgmt.employee;

import com.company.employeemgmt.common.UpsertEntityRes;
import com.company.employeemgmt.department.Department;
import com.company.employeemgmt.department.DepartmentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

@Service
@Transactional
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    DepartmentService departmentService;

    public UpsertEntityRes createEmployee(Employee employee) {
        Employee storedEmployee = employeeRepository.save(employee);
        return new UpsertEntityRes(storedEmployee.getId());
    }

    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    public UpsertEntityRes updateEmployee(Long id, Employee employee) {
        Employee storedEmployee = employeeRepository.findById(id).get();
        storedEmployee.setFirstName(employee.getFirstName());
        storedEmployee.setLastName(employee.getLastName());
        storedEmployee.setEmail(employee.getEmail());

        employeeRepository.save(storedEmployee);

        return new UpsertEntityRes(id);
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    public void assignEmployeeToDepartment(EmployeeDepartmentAssign employeeDepartmentAssign) {
        Employee employee = employeeRepository.findById(employeeDepartmentAssign.getEmployeeId()).get();
        Department department = departmentService.getDepartment(employeeDepartmentAssign.getDepartmentId());

        Set<Department> departments = new HashSet<>();
        departments.add(department);

        employee.setDepartments(departments);
        employeeRepository.save(employee);
    }
}
