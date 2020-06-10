package app.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Books;
import app.repository.BookRepository;

@Service
public class BookServiceImpl {
	@Autowired
	private BookRepository bookRepository;
	
	public List<Books> getAllBooks() {
		return bookRepository.findAll();
	}
	
	public Books getBookById(Integer id) {
		return bookRepository.getOne(id);
	}
	
	public void insertOrUpdate(Books b) {
		if (b == null) return;
		bookRepository.save(b);
	}
	
	public void delete(Integer id) {
		bookRepository.deleteById(id);
	}
	
	public Map<Integer, Books> booksToMap(List<Books> list) {
		Map<Integer, Books> map = new HashMap<>();
		for (Books b : list) {
			map.put(b.getId(), b);
		}
		
		return map;
	}
}
