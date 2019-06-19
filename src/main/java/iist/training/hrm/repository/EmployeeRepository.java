package iist.training.hrm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import iist.training.hrm.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	@Query("select e from Employee e")
	List<Employee> getListEmployee();

	@Query("SELECT e FROM Employee e WHERE CONCAT(e.lastName, ' ', e.firstName) like %:searchString% or CONCAT(e.firstName, ' ', e.lastName) like %:searchString%")
	List<Employee> searchEmployeeByName(@Param("searchString") String searchString);
	
	@Query("SELECT e FROM Employee e WHERE e.position.positionId = :positionId")
	List<Employee> searchEmployeeByPositionId(@Param("positionId") int positionId);
	
}
