package com.iist.hrm.mapping;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.iist.hrm.dto.AccountDto;
import com.iist.hrm.dto.RoleDto;
import com.iist.hrm.model.Account;
import com.iist.hrm.utils.Constants;

public class AccountMapping {

	public static AccountDto buildAccountAuth(Account account) {
		if (account != null) {
			List<GrantedAuthority> authorities = account.getRoles().stream()
					.map(role -> new SimpleGrantedAuthority(Constants.ROLE_PREFIX + role.getRoleName()))
					.collect(Collectors.toList());
			return new AccountDto(account.getAccountId(), account.getUsername(), account.getPassword(),
					account.getStatus(), authorities);
		}
		return null;
	}

	public static AccountDto accountMapping(Account account) {
		if (account != null) {
			AccountDto accountDto = new AccountDto();
			accountDto.setAccountId(account.getAccountId());
			accountDto.setRoles(account.getRoles().stream()
					.map(role -> new RoleDto(role.getRoleId(), role.getRoleName(), role.getDescription()))
					.collect(Collectors.toSet()));
			accountDto.setPassword(account.getPassword());
			accountDto.setUsername(account.getUsername());
			accountDto.setStatus(account.getStatus());
			List<GrantedAuthority> authorities = account.getRoles().stream()
					.map(role -> new SimpleGrantedAuthority(Constants.ROLE_PREFIX + role.getRoleName()))
					.collect(Collectors.toList());
			accountDto.setAuthorities(authorities);
			return accountDto;
		}
		return null;
	}

}
