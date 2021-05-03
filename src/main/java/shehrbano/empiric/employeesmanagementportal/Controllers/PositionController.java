package shehrbano.empiric.employeesmanagementportal.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import shehrbano.empiric.employeesmanagementportal.Entities.Position;
import shehrbano.empiric.employeesmanagementportal.Services.PositionService;
import shehrbano.empiric.employeesmanagementportal.dto.GetPositionDTO;

import java.util.List;
import java.util.Optional;

@RestController
public class PositionController {


    @Autowired
    private PositionService positionService;

    @RequestMapping("/positions")
    public List<Position> getAllPositions(){
        return positionService.getAllPositions();
    }

    @RequestMapping(method= RequestMethod.POST, value="/positions/getPositionById")
    public Optional<Position> getPosition(@RequestBody GetPositionDTO getPositionDTO){
        return positionService.getPosition(getPositionDTO.posId);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/positions/addPosition")
    public Position addPositions(@RequestBody Position position){
        return positionService.addPosition(position);
    }

    @RequestMapping(method=RequestMethod.PUT, value="/positions/updatePositions")
    public Position updatePositions(@RequestBody Position position){
        return positionService.updatePosition(position);
    }
    @RequestMapping(method=RequestMethod.DELETE, value="/positions/deletePositionsById")
    public void deletePositions(@RequestBody Position position) {
        positionService.deletePositions(position.positionId);
    } }