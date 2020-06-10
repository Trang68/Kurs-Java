package app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entity.BookTypes;

@Repository
public interface BookTypesRepository extends JpaRepository<BookTypes, Integer>{
	
}
