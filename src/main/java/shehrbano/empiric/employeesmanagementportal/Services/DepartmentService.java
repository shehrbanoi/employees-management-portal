package shehrbano.empiric.employeesmanagementportal.Services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import shehrbano.empiric.employeesmanagementportal.Entities.Department;
import shehrbano.empiric.employeesmanagementportal.Repository.DepartmentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@Service
public class DepartmentService {
    @Autowired
    DepartmentRepository departmentRepository;



    public List<Department> getAllDepartments() {
        List<Department> departments = new ArrayList<>();
        departments = (List<Department>) departmentRepository.findAll();
        return departments;
    }

    public Optional<Department> getDepartment(int deptid) {
        return departmentRepository.findById(Integer.toString(deptid));

    }

    public Department addDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public Department updateDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public void deleteDepartment(String deptId) {

        departmentRepository.deleteById(deptId);
    }


}
