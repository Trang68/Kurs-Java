package app.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.BookTypes;
import app.repository.BookTypesRepository;

@Service
public class BookTypesServiceImpl {

	@Autowired
	private BookTypesRepository bookTypesRepository;
	
	public List<BookTypes> getAllBookTypes() {
		return bookTypesRepository.findAll();
	}
	
	public BookTypes getBookTypeById(Integer id) {
		return bookTypesRepository.getOne(id);
	}
	
	public void insertOrUpdate(BookTypes bt) {
		if (bt == null) return;
		bookTypesRepository.save(bt);
	}
	
	public void delete(Integer id) {
		bookTypesRepository.deleteById(id);
	}
	
	public Map<Integer, BookTypes> bookTypesToMap(List<BookTypes> list) {
		Map<Integer, BookTypes> map = new HashMap<>();
		for (BookTypes bookTypes : list) {
			map.put(bookTypes.getId(), bookTypes);
		}
		
		return map;
	}
}
