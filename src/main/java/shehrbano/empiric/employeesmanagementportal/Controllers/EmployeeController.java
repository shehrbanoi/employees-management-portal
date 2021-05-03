package shehrbano.empiric.employeesmanagementportal.Controllers;


import jdk.nashorn.internal.runtime.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import shehrbano.empiric.employeesmanagementportal.Entities.Employee;
import shehrbano.empiric.employeesmanagementportal.Repository.EmployeesRepository;
import shehrbano.empiric.employeesmanagementportal.Services.EmployeeService;
import shehrbano.empiric.employeesmanagementportal.dto.GetEmpDTO;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeesRepository employeesRepository;

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<Employee>>getAllEmployeesP(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "3") Integer pageSize,
            @RequestParam(defaultValue = "employeeId") String sortBy){
        List<Employee> list = employeeService.getAllEmployeesP(pageNo, pageSize, sortBy);
        return new ResponseEntity<List<Employee>>(list, new HttpHeaders(), HttpStatus.OK);
    }



   /* @RequestMapping("/employees/byLastName/?1")
    public List<Employee> FindByFirstName(@RequestBody Employee employee){
        return employeesRepository.byLastName(employee.firstName);
    }

    @RequestMapping("/employees/sortName")
    public List<Employee> sortEmployee(@RequestBody Employee employee) {
        return employeesRepository.sortName(Sort.by("firstName"));
    }
*/
    @RequestMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @RequestMapping(method= RequestMethod.POST, value="/employees/getEmployeeById")
    public Optional<Employee> getEmployee(@RequestBody GetEmpDTO getEmpDTO){
        return employeeService.getEmployee(getEmpDTO.empId);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/employees/addEmployee")
    public Employee addEmployee(@RequestBody Employee employee){
        Employee newEmp=employeesRepository.save(employee);
        employeeService.employeePension(newEmp);
        return newEmp;
    }

    @RequestMapping(method=RequestMethod.PUT, value="/employees/updateEmployee")
    public Employee updateEmployee(@RequestBody Employee employee){
        return employeeService.updateEmployee(employee);
    }

    @RequestMapping(method=RequestMethod.DELETE, value="/employees/deleteEmployeeById")
    public void deleteEmployee(@RequestBody Employee employee){
        employeeService.deleteEmployee(employee.empId);
    }
/**
 @RequestMapping(method = RequestMethod.POST, value="/departments/addDepartmentfor__")
 public Department addDept4(@RequestBody Department department){
 return departmentService.addDepartment4(department);
 }
 **/
}

/*    public Employee addEmployee(@RequestBody Employee employee){
        return employeeService.addEmployee(employee);
    }
*/