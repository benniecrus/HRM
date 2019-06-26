package com.iist.hrm.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iist.hrm.dto.PositionDto;
import com.iist.hrm.dto.request.NewPositionDto;
import com.iist.hrm.dto.response.ResponseDto;
import com.iist.hrm.exception.ProductException;
import com.iist.hrm.service.PositionService;

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
	
	@GetMapping("/get-all-position")
	public ResponseEntity<ResponseDto<List<PositionDto>>> getAllPosition() {
		ResponseDto<List<PositionDto>> response = new ResponseDto<List<PositionDto>>();
		
		List<PositionDto> positionDtos = positionService.getAllPosition();
		response.setContent(positionDtos);
		response.setMessage("Success");
		
		return new ResponseEntity<ResponseDto<List<PositionDto>>>(response, HttpStatus.OK);
	}
}
