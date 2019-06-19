package iist.training.hrm.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import iist.training.hrm.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
	@Query("select acc from Account acc where acc.username = :username and acc.status = 1")
	Account getAccounInfo(@Param("username") String username);
	
	@Query("select count(acc.accountId) from Account acc where acc.accountName = :accountName")
	int countNumberAccountName(@Param("accountName") String accountName);
	
	Optional<Account> findByUsername(String username);
}
