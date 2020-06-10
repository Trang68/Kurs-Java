package app.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.javatuples.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import app.entity.BookTypes;
import app.entity.Books;
import app.service.BookServiceImpl;
import app.service.BookTypesServiceImpl;

@Controller
public class BookController {
	@Autowired
	private BookServiceImpl bookServiceImpl;
	
	@Autowired
	private BookTypesServiceImpl bookTypesServiceImpl;
	
	@GetMapping("/books/list")
    public String getAllBooks(Model model) {
		List<Books> listBooks = bookServiceImpl.getAllBooks();
		List<BookTypes> listBookTypes = bookTypesServiceImpl.getAllBookTypes();
		Map<Integer, BookTypes> mapType = this.bookTypesServiceImpl.bookTypesToMap(listBookTypes);
		List<BookModelView> listView = new ArrayList<>();
		for (Books book : listBooks) {
			BookModelView mv = new BookModelView();
			mv.setId(book.getId());
			mv.setCnt(book.getCnt());
			mv.setName(book.getName());
			mv.setTypeId(book.getTypeId());
			if (mapType.containsKey(book.getTypeId())) {
				mv.setType(mapType.get(book.getTypeId()).getName());
			}
			
			listView.add(mv);
		}
		model.addAttribute("listBooks", listView);
        return "/books/list";
    }
	
	
	@GetMapping("/books/borrow")
    public String searchAllBooks(Model model) {
		List<Books> listBooks = bookServiceImpl.getAllBooks();
		List<BookTypes> listBookTypes = bookTypesServiceImpl.getAllBookTypes();
		Map<Integer, BookTypes> mapType = this.bookTypesServiceImpl.bookTypesToMap(listBookTypes);
		List<BookModelView> listView = new ArrayList<>();
		for (Books book : listBooks) {
			BookModelView mv = new BookModelView();
			mv.setId(book.getId());
			mv.setCnt(book.getCnt());
			mv.setName(book.getName());
			mv.setTypeId(book.getTypeId());
			if (mapType.containsKey(book.getTypeId())) {
				mv.setType(mapType.get(book.getTypeId()).getName());
			}
			
			listView.add(mv);
		}
		model.addAttribute("listBooks", listView);
        return "/books/list_borrow";
    }
	
	
	@GetMapping("/books/add")
    public String addBook(Model model) {
		Books bt = new Books();
		List<BookTypes> listBookTypes = bookTypesServiceImpl.getAllBookTypes();
		
		model.addAttribute("listBookTypes", listBookTypes);
		model.addAttribute("bookForm", bt);
        return "/books/edit";
    }
	
	@GetMapping("/books/edit")
    public String editBooks(Model model, @RequestParam(value = "id", required = true) Integer id) {
		Books bt = bookServiceImpl.getBookById(id);
		List<BookTypes> listBookTypes = bookTypesServiceImpl.getAllBookTypes();
		
		model.addAttribute("listBookTypes", listBookTypes);
		model.addAttribute("bookForm", bt);
        return "/books/edit";
    }
	
	@GetMapping("/books/delete")
    public String deleteBook(Model model, @RequestParam(value = "id", required = true) Integer id) {
		bookServiceImpl.delete(id);
		
        return "redirect:/books/list";
    }
	
	@PostMapping("/books/save")
    public String save(Model model, @ModelAttribute("bookForm") Books b, RedirectAttributes ra) {
		Pair<Boolean,String> r = this.validate(b);
        if (!r.getValue0()) {
        	model.addAttribute("error", r.getValue1());
        	ra.addFlashAttribute("error", r.getValue1());
            return (b.getId()== null) ? "redirect:/books/add": "redirect:/books/edit?id=" + b.getId();
        }
        
        bookServiceImpl.insertOrUpdate(b);
        return "redirect:/books/list";
    }
	
	private Pair<Boolean, String> validate(Books c) {
    	String error = "";
    	if (StringUtils.isEmpty(c.getName())) error = "Book name is required!";
    	if (c.getTypeId() == null) error = "Book type is required";
    	if (StringUtils.isEmpty(error)) return new Pair<Boolean, String>(true, "");
    	return new Pair<Boolean, String>(false, error);
    }
	
	public class BookModelView extends Books {
		private String type;

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}
		
	}
}
