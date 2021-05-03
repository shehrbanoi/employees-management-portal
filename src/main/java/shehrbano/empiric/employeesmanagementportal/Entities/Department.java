package shehrbano.empiric.employeesmanagementportal.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Department")
@EntityListeners(AuditingEntityListener.class)
@AllArgsConstructor
@NoArgsConstructor
public class Department {

    @Id
//@NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public String deptId;
    public String deptName;
    public String numEmployees;
    public String deptManager;
}