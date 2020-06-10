package app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import app.entity.Clients;

@Repository
public interface ClientsRepository extends JpaRepository<Clients, Integer> {

	
	@Query(value = "SELECT * FROM clients c WHERE (BINARY c.ID = :id)", nativeQuery = true)
	Clients findClientById(@Param("id") Integer id);
	
	@Query(value = "SELECT * FROM clients c WHERE (BINARY c.PASSPORT_SERIA = :passportSeria)", nativeQuery = true)
	Clients findClientBySeria(@Param("passportSeria") String passportSeria);
	
	
//	@Query(value = "SELECT * FROM clients c", nativeQuery = true)
//	List<Clients> getAll();
//	
//	@Modifying
//	@Query(value = "INSERT into clients(FIRST_NAME, LAST_NAME, PATHER_NAME, PASSPORT_SERIA, PASSPORT_NUM) "
//			+ "values (:firstName,:lastName,:patherName,:passportSeria,:passportNum)", nativeQuery = true)
//	void insert(@Param("firstName") String firstName, @Param("lastName") String lastName, 
//			  @Param("patherName") String patherName, 
//			  @Param("passportSeria") String passportSeria,
//			  @Param("passportNum") String passportNum);
//	
//
//	@Modifying
//	@Query(value = "UPDATE clients SET FIRST_NAME =?, LAST_NAME=?, PATHER_NAME=?, PASSPORT_SERIA=?, PASSPORT_NUM=? where ID=? ", nativeQuery = true)
//	void update(String firstName,String lastName, 
//			  String patherName, String passportSeria,
//			  String passportNum, Integer id);
//	
//	@Query(value = "DELETE FROM clients c where (BINARY c.ID = :id)", nativeQuery = true)
//	void delete(@Param("id") Integer id);
}
