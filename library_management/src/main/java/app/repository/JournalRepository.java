package app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.entity.Journal;

public interface JournalRepository extends JpaRepository<Journal, Integer>{

}
