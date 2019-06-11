package iist.training.hrm.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iist.training.hrm.exception.PositionNotFoundException;
import iist.training.hrm.model.Position;
import iist.training.hrm.repository.PositionRepository;
import iist.training.hrm.service.PositionService;

@Service
public class PositionServiceImpl implements PositionService {
	
	@Autowired
	private PositionRepository positionRepository;
	
	@Override
	public Position getPositionById(int positionId) {
		Optional<Position> position = positionRepository.findById(positionId);
		if(position.isPresent()) {
			return position.get();
		} else {
			throw new PositionNotFoundException("Position not found!");
		}
	}

}
