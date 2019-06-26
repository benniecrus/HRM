package com.iist.hrm.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.iist.hrm.model.Token;

@Repository
public interface TokenRepository extends JpaRepository<Token, Integer> {
	Token findByToken(String token);
	
	@Query("Select t from Token t Where t.expiredTime < :date or t.isActive = false")
	List<Token> findTokenExpiredOrInactive(Date date);
}
