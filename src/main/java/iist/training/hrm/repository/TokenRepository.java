package iist.training.hrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import iist.training.hrm.model.Token;

@Repository
public interface TokenRepository extends JpaRepository<Token, Integer> {
	Token findByToken(String token);
}
