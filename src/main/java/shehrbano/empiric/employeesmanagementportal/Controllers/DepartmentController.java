package shehrbano.empiric.employeesmanagementportal.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import shehrbano.empiric.employeesmanagementportal.Entities.Department;
import shehrbano.empiric.employeesmanagementportal.Services.DepartmentService;
import shehrbano.empiric.employeesmanagementportal.dto.GetDeptDTO;

import java.util.List;
import java.util.Optional;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

//specify method
    @RequestMapping("/departments")
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/departments/getDepartmentById")
    public Optional<Department> getDepartment(@RequestBody GetDeptDTO getDeptDTO) {
        return departmentService.getDepartment(getDeptDTO.deptid);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/departments/addDepartment")
    public Department addDepartment(@RequestBody Department department) {
        return departmentService.addDepartment(department);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/departments/updateDepartment")
    public Department updateDepartment(@RequestBody Department department) {
        return departmentService.updateDepartment(department);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/departments/deleteDepartmentById")
    public void deleteDepartment(@RequestBody Department department) {
        departmentService.deleteDepartment(department.deptId);
    }

}
