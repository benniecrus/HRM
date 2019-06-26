package com.iist.hrm.service;

import java.util.List;

import com.iist.hrm.dto.PositionDto;
import com.iist.hrm.dto.request.NewPositionDto;
import com.iist.hrm.model.Position;

public interface PositionService {
	Position getPositionById(int positionId);
	PositionDto addNewPosition(NewPositionDto newPositionDto);
	PositionDto updatePosition(NewPositionDto updatePositionDto);
	List<PositionDto> getAllPosition();
}
