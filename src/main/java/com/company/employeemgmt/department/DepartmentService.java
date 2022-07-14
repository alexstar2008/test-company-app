package com.company.employeemgmt.department;

import com.company.employeemgmt.common.UpsertEntityRes;
import com.company.employeemgmt.employee.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

@Service
@Transactional
public class DepartmentService {
    @Autowired
    DepartmentRepository departmentRepository;

    public UpsertEntityRes createDepartment(Department department) {
        Department storedDepartment = departmentRepository.save(department);
        return new UpsertEntityRes(storedDepartment.getId());
    }

    public List<Department> getDepartments() {
        return departmentRepository.findAll();
    }

    public Department getDepartment(Long id) {
        return departmentRepository.findById(id).get();
    }

    public Set<Employee> getDepartmentEmployees(Long id) {
        Department department = departmentRepository.findById(id).get();
        return department.getEmployees();
    }

    public UpsertEntityRes updateDepartment(Long id, Department department) {
        Department storedDepartment = departmentRepository.findById(id).get();
        storedDepartment.setName(department.getName());

        departmentRepository.save(storedDepartment);

        return new UpsertEntityRes(storedDepartment.getId());
    }

    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }

}
