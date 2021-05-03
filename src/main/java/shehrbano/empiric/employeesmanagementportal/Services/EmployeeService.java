package shehrbano.empiric.employeesmanagementportal.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import shehrbano.empiric.employeesmanagementportal.Entities.Employee;
import shehrbano.empiric.employeesmanagementportal.Repository.EmployeesRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@Service
public class EmployeeService {

    @Autowired
    EmployeesRepository employeesRepository;
    private Employee employee;

   /* public List<Employee> sortByName(Employee employee){
        return employeesRepository.findAll(Sort.by(Sort.Direction.ASC,"firstName"));
    }*/

    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        employees = (List<Employee>) employeesRepository.findAll();
        return employees;
    }

    public Optional<Employee> getEmployee(int empId) {
        return employeesRepository.findById(Integer.toString(empId));
    }

    public Employee addEmployee(Employee employee) {
        return employeesRepository.save(employee);
    }

    public Employee updateEmployee(Employee employee) {
        return employeesRepository.save(employee);
    }

    public void deleteEmployee(String empId) {

        employeesRepository.deleteById(empId);
    }

    public Employee employeePension(Employee employee){

        long empYearsService = employee.yearsService;
// yearsservice>5
        //if 1stjob is true OR other jobs
        //years service >=20
        //emp pension+35,000
        //then emp +10,000
            if(employee.prevWork.equals("notworked") && employee.yearsService >=5){
                employee.employeePension=10000;
            }
            if(employee.prevWork.equals("notworked") && employee.yearsExp >=20 && employee.yearsService>=5){
                employee.employeePension=45000;
            }
            if(employee.prevWork.equals("worked")&& employee.yearsService>=20){
                employee.employeePension=35000;
            }
            else{
                employee.employeePension=empYearsService*1000L;
            }

        return employee;

        //firstjob --> 10,000
        //else-35
        //first job and 20 yeatrs 35+10
        //none then 1000xyears service

    }

    public List<Employee> getAllEmployeesP(Integer pageNo, Integer pageSize, String sortBy) {
        Pageable paging = PageRequest.of(pageNo,pageSize,Sort.by("firstName"));
        Page<Employee> pageResult = employeesRepository.findAll(paging);
        if(pageResult.hasContent()){
            return pageResult.getContent();
        }else{
            return new ArrayList<Employee>();
        }
    }
}
