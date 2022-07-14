CREATE TABLE departments_employees (
  department_id BIGINT REFERENCES departments (id) ON UPDATE CASCADE ON DELETE CASCADE,
  employee_id BIGINT REFERENCES employees (id) ON UPDATE CASCADE,
  PRIMARY KEY (department_id, employee_id)
);