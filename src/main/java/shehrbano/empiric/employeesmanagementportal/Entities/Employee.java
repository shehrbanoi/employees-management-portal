package shehrbano.empiric.employeesmanagementportal.Entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity(name = "Employee")
@Data
@Table(name = "Employee")
@EntityListeners(AuditingEntityListener.class)
@AllArgsConstructor
@NoArgsConstructor

public class Employee {
    @Id
//@NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public String empId;
    public String firstName;
    public String lastName;
    public String dob;
    public String cnic;
    @OneToOne
    @NotNull
    @JoinColumn(name="deptId")
    public Department department;

    @OneToOne
    @NotNull
    @JoinColumn(name="positionId")
    public Position position;
    public String salary;
    public long yearsExp;
    public long yearsService;
    public String startDate;
    public String contactInfo;
    public String location;
    public String prevWork;
    public long employeePension;

}
