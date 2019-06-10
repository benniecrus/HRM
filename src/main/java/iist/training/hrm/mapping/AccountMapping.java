package iist.training.hrm.mapping;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import iist.training.hrm.dto.AccountDto;
import iist.training.hrm.model.Account;

public class AccountMapping {

	public static AccountDto buildAccountAuth(Account account) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		GrantedAuthority authority = new SimpleGrantedAuthority(account.getRole().getRoleName());
		authorities.add(authority);
		return new AccountDto(account.getAccountId(), account.getUsername(), account.getPassword(),
				account.getRole().getRoleName(), authorities);
	}

	public static AccountDto accountMapping(Account account) {
		AccountDto accountDto = new AccountDto();
		accountDto.setAccountId(account.getAccountId());
		accountDto.setPassword(account.getPassword());
		accountDto.setRoleName(account.getRole().getRoleName());
		accountDto.setUsername(account.getUsername());
		return accountDto;
	}

}
