package com.app.Department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    private DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public List<Department> getDepartments() {
        return departmentRepository.findAll();
    }

    public Department saveDepartment(Department department) {
        return departmentRepository.saveAndFlush(department);
    }

    public List<Department> saveDepartments(List<Department> departments) {
        return departmentRepository.saveAllAndFlush(departments);
    }

    public void deleteAll() {
        departmentRepository.deleteAll();
    }
}
