package shehrbano.empiric.employeesmanagementportal.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import shehrbano.empiric.employeesmanagementportal.Entities.Position;
import shehrbano.empiric.employeesmanagementportal.Repository.PositionsRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@Service
public class PositionService {

    @Autowired
    PositionsRepository positionsRepository;



    public List<Position> getAllPositions() {
        List<Position> positions = new ArrayList<>();
        positions= (List<Position>) positionsRepository.findAll();
        return positions;
    }

    public Optional<Position> getPosition(int posId) {

        return positionsRepository.findById(Integer.toString(posId));
    }

    public Position addPosition(Position position) {
        return positionsRepository.save(position);
    }

    public Position updatePosition(Position position) {
        return positionsRepository.save(position);
    }

    public void deletePositions(String positionId) {
        positionsRepository.deleteById(positionId);
    }
}
