package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Journal;
import app.repository.JournalRepository;

@Service
public class JournalServiceImpl {

	@Autowired
	private JournalRepository journalsRepository;
	
	public List<Journal> getAllJournal() {
		return journalsRepository.findAll();
	}
	
	public Journal getJournalById(Integer id) {
		if (id == null) return null;
		return journalsRepository.getOne(id);
	}
	
	public void insertOrUpdate(Journal j) {
		if (j == null) return;
		journalsRepository.save(j);
	}
}
