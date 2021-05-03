package shehrbano.empiric.employeesmanagementportal.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shehrbano.empiric.employeesmanagementportal.Entities.Position;

@Repository
public interface PositionsRepository extends JpaRepository<Position,String> {}