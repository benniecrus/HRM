package com.iist.hrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iist.hrm.model.Position;

@Repository
public interface PositionRepository extends JpaRepository<Position, Integer> {
	Position findByPositionName(String positionName);
}
