package iist.training.hrm.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import iist.training.hrm.dto.PositionDto;
import iist.training.hrm.dto.request.NewPositionDto;
import iist.training.hrm.exception.PositionNotFoundException;
import iist.training.hrm.exception.ProductException;
import iist.training.hrm.mapping.PositionMapping;
import iist.training.hrm.model.Position;
import iist.training.hrm.repository.PositionRepository;
import iist.training.hrm.service.PositionService;

@Service
@Transactional
public class PositionServiceImpl implements PositionService {

	@Autowired
	private PositionRepository positionRepository;

	public PositionDto addNewPosition(NewPositionDto newPositionDto) {
		if (newPositionDto == null) {
			throw new ProductException("new position cannot null");
		}

		if (checkExistPositionName(newPositionDto)) {
			throw new ProductException("Position name is exist");
		}

		Position position = new Position();
		position.setPositionName(newPositionDto.getPositionName());
		position.setDescription(newPositionDto.getPositionDescription());

		position = positionRepository.saveAndFlush(position);

		return PositionMapping.positionMapping(position);
	}

	public PositionDto updatePosition(NewPositionDto updatePositionDto) {
		if (updatePositionDto == null) {
			throw new ProductException("update position cannot null");
		}

		if (checkExistPositionName(updatePositionDto)) {
			throw new ProductException("Position name is exist");
		}

		Position position = getPositionById(updatePositionDto.getPositonId());
		position.setPositionName(updatePositionDto.getPositionName());
		position.setDescription(updatePositionDto.getPositionDescription());

		position = positionRepository.saveAndFlush(position);

		return PositionMapping.positionMapping(position);
	}

	private boolean checkExistPositionName(NewPositionDto positionDto) {
		Optional<Position> position = positionRepository.findById(positionDto.getPositonId());

		if (position.isPresent()) {
			if (position.get().getPositionId() == positionDto.getPositonId()) {
				return false;
			}
			return true;
		} else {
			return false;
		}

	}

	@Override
	public Position getPositionById(int positionId) {
		Optional<Position> position = positionRepository.findById(positionId);
		if (position.isPresent()) {
			return position.get();
		} else {
			throw new PositionNotFoundException("Position not found!");
		}
	}

}
