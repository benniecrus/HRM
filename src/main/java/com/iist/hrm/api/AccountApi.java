package com.iist.hrm.api;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iist.hrm.dto.AccountDto;
import com.iist.hrm.dto.CategoryDto;
import com.iist.hrm.dto.ProfileDto;
import com.iist.hrm.dto.RoleDto;
import com.iist.hrm.dto.request.ChangePasswordDto;
import com.iist.hrm.dto.response.ErrorCodes;
import com.iist.hrm.dto.response.ResponseDto;
import com.iist.hrm.exception.ProductException;
import com.iist.hrm.service.AccountService;
import com.iist.hrm.service.CategoryService;
import com.iist.hrm.utils.Constants;

@RestController
@RequestMapping("/api/account")
public class AccountApi {

	@Autowired
	AccountService accountService;

	@Autowired
	CategoryService categoryService;

	@PostMapping("/change-password")
	public ResponseEntity<ResponseDto<AccountDto>> changePassword(HttpServletRequest request,
			@RequestBody ChangePasswordDto changePasswordDto) {
		ResponseDto<AccountDto> responseDto = new ResponseDto<AccountDto>();

		if (StringUtils.isEmpty(request.getHeader(Constants.AUTHORIZATION_STRING))) {
			throw new ProductException("Token must be not null", ErrorCodes.TOKENERROR.getErrorCode());
		}

		String token = request.getHeader(Constants.AUTHORIZATION_STRING).replace(Constants.TOKEN_PREFIX, "").trim();

		AccountDto accountDto = accountService.changePassword(changePasswordDto, token);

		responseDto.setContent(accountDto);
		responseDto.setMessage(Constants.SUCCESS);

		return new ResponseEntity<ResponseDto<AccountDto>>(responseDto, HttpStatus.OK);
	}

	@GetMapping("/get-profile")
	public ResponseEntity<ResponseDto<ProfileDto>> getProfile(HttpServletRequest request) {
		ResponseDto<ProfileDto> responseDto = new ResponseDto<ProfileDto>();

		if (StringUtils.isEmpty(request.getHeader(Constants.AUTHORIZATION_STRING))) {
			throw new ProductException("Token must be not null", ErrorCodes.TOKENERROR.getErrorCode());
		}

		String token = request.getHeader(Constants.AUTHORIZATION_STRING).replace(Constants.TOKEN_PREFIX, "").trim();

		AccountDto accountDto = accountService.getProfile(token);

		Set<RoleDto> roles = accountDto.getRoles();
		String roleName = "";
		for (Iterator<RoleDto> it = roles.iterator(); it.hasNext();) {
			RoleDto dto = it.next();
			roleName = dto.getRoleName();
			break;
		}
		List<CategoryDto> listDto = categoryService.getCategoryByRole(roleName);

		ProfileDto profileDto = new ProfileDto();
		profileDto.setAccountDto(accountDto);
		profileDto.setCategories(listDto);
		responseDto.setContent(profileDto);

		responseDto.setMessage(Constants.SUCCESS);

		return new ResponseEntity<ResponseDto<ProfileDto>>(responseDto, HttpStatus.OK);
	}

}
