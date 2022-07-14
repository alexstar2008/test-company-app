package com.company.employeemgmt.department;

import com.company.employeemgmt.common.UpsertEntityRes;
import com.company.employeemgmt.employee.Employee;

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
import java.util.Set;

import javax.validation.Valid;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;

    @GetMapping()
    public List<Department> getDepartments() {
        return departmentService.getDepartments();
    }

    @PostMapping()
    public UpsertEntityRes createDepartment(@Valid @RequestBody Department department) {
        return departmentService.createDepartment(department);
    }

    @PutMapping(value = "/{id}")
    public UpsertEntityRes updateDepartment(
        @PathVariable(value = "id") Long id,
        @Valid @RequestBody Department department
    ) {
        return departmentService.updateDepartment(id, department);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteEmployee(@PathVariable(value = "id") Long id) {
        departmentService.deleteDepartment(id);
    }

    @GetMapping(value = "/{id}/employees")
    public Set<Employee> getDepartmentEmployees(@PathVariable(value = "id") Long id) {
        return departmentService.getDepartmentEmployees(id);
    }
}
