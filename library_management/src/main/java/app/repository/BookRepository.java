package app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.entity.Books;

public interface BookRepository extends JpaRepository<Books, Integer>{

}
