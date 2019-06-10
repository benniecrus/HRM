package iist.training.hrm.mapping;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import iist.training.hrm.dto.AccountDto;
import iist.training.hrm.model.Account;
import iist.training.hrm.utils.Constants;

public class AccountMapping {

	public static AccountDto buildAccountAuth(Account account) {
		List<GrantedAuthority> authorities = account.getRoles().stream()
				.map(role -> new SimpleGrantedAuthority(Constants.ROLE_PREFIX + role.getRoleName())).collect(Collectors.toList());
		return new AccountDto(account.getAccountId(), account.getUsername(), account.getPassword(), authorities);
	}

	public static AccountDto accountMapping(Account account) {
		if(account != null) {
			AccountDto accountDto = new AccountDto();
			accountDto.setAccountId(account.getAccountId());
			accountDto.setRoles(account.getRoles());
			accountDto.setPassword(account.getPassword());
			accountDto.setUsername(account.getUsername());
			List<GrantedAuthority> authorities = account.getRoles().stream()
					.map(role -> new SimpleGrantedAuthority(Constants.ROLE_PREFIX + role.getRoleName())).collect(Collectors.toList());
			accountDto.setAuthorities(authorities);
			return accountDto;
		}
		return null;
	}

}
