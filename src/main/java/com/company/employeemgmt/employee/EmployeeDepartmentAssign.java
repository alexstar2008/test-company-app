package com.company.employeemgmt.employee;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class EmployeeDepartmentAssign {
    @NotNull
    @Positive
    private Long employeeId;
    @NotNull
    @Positive
    private Long departmentId;

    public Long getEmployeeId() {
        return this.employeeId;
    }

    public Long getDepartmentId() {
        return this.departmentId;
    }
}
