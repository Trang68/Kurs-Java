package app.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import app.entity.BookTypes;
import app.entity.Books;
import app.entity.Clients;
import app.entity.Journal;
import app.service.BookServiceImpl;
import app.service.BookTypesServiceImpl;
import app.service.ClientsServiceImpl;
import app.service.JournalServiceImpl;

@Controller
public class JournalController {

	@Autowired 
	private JournalServiceImpl journalServiceImpl;
	
	@Autowired 
	private ClientsServiceImpl clientsServiceImpl;
	
	@Autowired 
	private BookServiceImpl bookServiceImpl;
	
	@Autowired 
	private BookTypesServiceImpl bookTypesServiceImpl;
	
	@GetMapping("/journal/list")
    public String getBookType(Model model) {
		List<Journal> listJournal = journalServiceImpl.getAllJournal();
		Map<Integer, Clients> mapClients = clientsServiceImpl.clientsToMap(clientsServiceImpl.getAllClients());
		Map<Integer, Books> mapBooks = bookServiceImpl.booksToMap(bookServiceImpl.getAllBooks());
//		Map<Integer, BookTypes> mapBookTypes = bookTypesServiceImpl.bookTypesToMap(bookTypesServiceImpl.getAllBookTypes());
		List<JournalViewModel> listVM = new ArrayList<JournalController.JournalViewModel>();
		for (Journal journal : listJournal) {
			JournalViewModel vm = new JournalViewModel();
			vm.setId(journal.getId());
			if (mapBooks.containsKey(journal.getBookId())){
				vm.setBookName(mapBooks.get(journal.getBookId()).getName());
//				if (mapBookTypes.containsKey(mapBooks.get(journal.getBookId()).getTypeId())) vm.set
			}
			if (mapClients.containsKey(journal.getClientId())) {
				Clients c = mapClients.get(journal.getClientId());
				vm.setClient(c.getPassportSeria());
				vm.setFullName(c.getLastName().concat(" ").concat(c.getPatherName()).concat(" ").concat(c.getFirstName()));
			}
			
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");  
			if (journal.getDateBeg() != null) vm.setDateBeg(dateFormat.format(new Date(journal.getDateBeg()))); 
			if (journal.getDateEnd() != null) vm.setDateEnd(dateFormat.format(new Date(journal.getDateEnd()))); 
			if (journal.getDateRet() != null) vm.setDateRet(dateFormat.format(new Date(journal.getDateRet())));
			
			listVM.add(vm);
		}
		model.addAttribute("listJournal", listVM);
        return "/journal/list";
    }
	
	@GetMapping("/journal/save")
    public String save(Model model, @RequestParam(value = "id", required = true) Integer bookId, RedirectAttributes ra) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = null;
		if (principal instanceof UserDetails) {
		  username = ((UserDetails)principal).getUsername();
		} else {
		  username = principal.toString();
		}
		Clients client = clientsServiceImpl.getClientBySeria(username);
		if (client == null) return "redirect:/login";
		
		Calendar c= Calendar.getInstance();
		c.add(Calendar.DATE, 30);
        Journal j = new Journal();
        j.setBookId(bookId);
        j.setClientId(client.getId());
        j.setDateBeg(new Date().getTime());
        j.setDateEnd(c.getTime().getTime());
        
		journalServiceImpl.insertOrUpdate(j);
        return "redirect:/journal/list";
    }
	
	@GetMapping("/journal/returnBook")
	public String returnBook(Model model, @RequestParam(value = "id", required = true) Integer id){
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = null;
		if (principal instanceof UserDetails) {
		  username = ((UserDetails)principal).getUsername();
		} else {
		  username = principal.toString();
		}
		Clients client = clientsServiceImpl.getClientBySeria(username);
		
		Journal j = this.journalServiceImpl.getJournalById(id);
		if  (j == null || client.getId() != j.getClientId()) {
			model.addAttribute("error", "Can not return this book.");
			return "journal/list";
		}
		
		j.setDateRet(new Date().getTime());
		journalServiceImpl.insertOrUpdate(j);
        return "redirect:/journal/list";
	}
	
	public class JournalViewModel {
		private Integer id;
		private String bookName;
		private String client;
		private String fullName;
		private String dateBeg;
		private String dateEnd;
		private String dateRet;
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getBookName() {
			return bookName;
		}
		public void setBookName(String bookName) {
			this.bookName = bookName;
		}
		public String getClient() {
			return client;
		}
		public void setClient(String client) {
			this.client = client;
		}
		public String getFullName() {
			return fullName;
		}
		public void setFullName(String fullName) {
			this.fullName = fullName;
		}
		public String getDateBeg() {
			return dateBeg;
		}
		public void setDateBeg(String dateBeg) {
			this.dateBeg = dateBeg;
		}
		public String getDateEnd() {
			return dateEnd;
		}
		public void setDateEnd(String dateEnd) {
			this.dateEnd = dateEnd;
		}
		public String getDateRet() {
			return dateRet;
		}
		public void setDateRet(String dateRet) {
			this.dateRet = dateRet;
		}
	}
}
