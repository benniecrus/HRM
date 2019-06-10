package iist.training.hrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import iist.training.hrm.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
	@Query("select acc from Account acc where acc.username = :username")
	Account getAccounInfo(@Param("username") String username);
	
}
