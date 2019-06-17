package iist.training.hrm.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import iist.training.hrm.dto.PositionDto;
import iist.training.hrm.dto.request.NewPositionDto;
import iist.training.hrm.dto.response.ResponseDto;
import iist.training.hrm.exception.ProductException;
import iist.training.hrm.service.PositionService;

@RestController
@RequestMapping("api/admin")
public class PositionApi {

	@Autowired
	private PositionService positionService;

	@PostMapping("/add-new-position")
	public ResponseEntity<ResponseDto<PositionDto>> addNewPosition(
			@RequestBody(required = true) NewPositionDto newPositionDto) {
		ResponseDto<PositionDto> response = new ResponseDto<PositionDto>();

		PositionDto positionDto = positionService.addNewPosition(newPositionDto);

		response.setContent(positionDto);
		response.setMessage("Success");

		return new ResponseEntity<ResponseDto<PositionDto>>(response, HttpStatus.OK);
	}

	@PostMapping("/update-position")
	public ResponseEntity<ResponseDto<PositionDto>> updatePosition(
			@RequestBody(required = true) NewPositionDto updatePositionDto) {
		if (updatePositionDto.getPositonId() <= 0) {
			throw new ProductException("update position failed!");
		}
		
		PositionDto positionDto = positionService.updatePosition(updatePositionDto);
		
		ResponseDto<PositionDto> response = new ResponseDto<PositionDto>();
		response.setContent(positionDto);
		response.setMessage("Success");
		
		return new ResponseEntity<ResponseDto<PositionDto>>(response, HttpStatus.OK);
	}
}
