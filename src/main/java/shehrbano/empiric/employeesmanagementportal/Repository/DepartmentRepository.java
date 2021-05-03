package shehrbano.empiric.employeesmanagementportal.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shehrbano.empiric.employeesmanagementportal.Entities.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,String> {}