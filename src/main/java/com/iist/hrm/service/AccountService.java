package com.iist.hrm.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.iist.hrm.dto.AccountDto;
import com.iist.hrm.dto.request.ChangeAccountRoleDto;
import com.iist.hrm.dto.request.ChangeAccountStatusDto;
import com.iist.hrm.dto.request.ChangePasswordDto;
import com.iist.hrm.model.Employee;

public interface AccountService extends UserDetailsService {
	AccountDto getAccountByUsername(String username);
	AccountDto getAccountInfo(String username);
	AccountDto addNewAccount(String username, String password);
	AccountDto generateAccount(Employee employee);
	AccountDto changePassword(ChangePasswordDto changePasswordDto, String token);
	AccountDto updateAccountRole(ChangeAccountRoleDto changeAccountRoleDto);
	AccountDto updateAccountStatus(ChangeAccountStatusDto changeAccountStatusDto);
	AccountDto getProfile(String token);
}
