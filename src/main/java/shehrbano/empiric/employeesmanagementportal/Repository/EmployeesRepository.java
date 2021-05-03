package shehrbano.empiric.employeesmanagementportal.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import shehrbano.empiric.employeesmanagementportal.Entities.Employee;

import java.util.List;

@Repository
public interface EmployeesRepository extends PagingAndSortingRepository<Employee, String> {


    @Query(value = "SELECT * FROM Employee",
    countQuery = "SELECT count(*) FROM Employee", nativeQuery = true)
    Page<Employee> findByLastName(String lastName,Pageable pageable);

    @Query(value = "SELECT * from Employee WHERE lastName = ?1 ", nativeQuery = true)
    List<Employee> getUsersByLastName(String lastName);


    /*

    @Query(
            value = "SELECT * FROM Employee",
            countQuery = "SELECT count(*) FROM Employee",
            nativeQuery = true)
    Page<Employee> findAllUsersWithPagination(Pageable pageable);*/
}
