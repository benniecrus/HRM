package iist.training.hrm.mapping;

import iist.training.hrm.dto.PositionDto;
import iist.training.hrm.model.Position;

public class PositionMapping {
	public static PositionDto positionMapping(Position position) {
		if (position != null) {
			PositionDto positionDto = new PositionDto();
			positionDto.setPositionId(position.getPositionId());
			positionDto.setPositionName(position.getPositionName());
			positionDto.setDescription(position.getDescription());
			return positionDto;
		}
		return null;
	}
}
