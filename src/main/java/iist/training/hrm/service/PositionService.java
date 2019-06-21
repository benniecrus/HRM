package iist.training.hrm.service;

import java.util.List;

import iist.training.hrm.dto.PositionDto;
import iist.training.hrm.dto.request.NewPositionDto;
import iist.training.hrm.model.Position;

public interface PositionService {
	Position getPositionById(int positionId);
	PositionDto addNewPosition(NewPositionDto newPositionDto);
	PositionDto updatePosition(NewPositionDto updatePositionDto);
	List<PositionDto> getAllPosition();
}
