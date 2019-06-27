package com.iist.hrm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iist.hrm.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	@Query("select e from Employee e")
	List<Employee> getListEmployee();

	@Query("SELECT e FROM Employee e WHERE e.position.positionId = :positionId")
	List<Employee> searchEmployeeByPositionId(@Param("positionId") int positionId);

	@Query(value = "SELECT e.* FROM Employee e LEFT JOIN ACCOUNT a ON e.EMPLOYEE_ID = a.employee_id WHERE MATCH(e.last_name, e.FIRST_NAME, e.EMAIL) AGAINST (:ss IN NATURAL LANGUAGE MODE) OR MATCH(a.username) AGAINST (:ss)", nativeQuery = true)
	List<Employee> searchEmployeeFullText(@Param("ss") String searchString);
}
