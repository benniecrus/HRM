package com.iist.hrm.mapping;

import com.iist.hrm.dto.PositionDto;
import com.iist.hrm.model.Position;

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
