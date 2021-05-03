package shehrbano.empiric.employeesmanagementportal.Entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Table(name = "Position")
@EntityListeners(AuditingEntityListener.class)
@AllArgsConstructor
@NoArgsConstructor
public class Position {

    @Id
//@NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public String positionId;
    public String positionName;
    @OneToOne
    @NotNull
    @JoinColumn(name="deptId")
    public Department department;

    public String positionType;
    public String positionSalary;

}
