package app.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.javatuples.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import app.entity.BookTypes;
import app.service.BookTypesServiceImpl;

@Controller
public class BookTypesController {

	@Autowired 
	private BookTypesServiceImpl bookTypesServiceImpl;
	
	@GetMapping("/bookTypes/list")
    public String getBookType(Model model) {
		List<BookTypes> listBookTypes = bookTypesServiceImpl.getAllBookTypes();
		model.addAttribute("listBookTypes", listBookTypes);
        return "/bookTypes/list";
    }
	
	
	@GetMapping("/bookTypes/add")
    public String addBookTypes(Model model) {
		BookTypes bt = new BookTypes();
		
		model.addAttribute("bookTypeForm", bt);
        return "/bookTypes/edit";
    }
	
	@GetMapping("/bookTypes/edit")
    public String editBookTypes(Model model, @RequestParam(value = "id", required = true) Integer id) {
		BookTypes bt = bookTypesServiceImpl.getBookTypeById(id);
		
		model.addAttribute("bookTypeForm", bt);
        return "/bookTypes/edit";
    }
	
	@GetMapping("/bookTypes/delete")
    public String deleteBookTypes(Model model, @RequestParam(value = "id", required = true) Integer id) {
		bookTypesServiceImpl.delete(id);
		
        return "redirect:/bookTypes/list";
    }
	
	@PostMapping("/bookTypes/save")
    public String save(Model model, @ModelAttribute("bookTypeForm") BookTypes bt, RedirectAttributes ra) {
		Pair<Boolean,String> r = this.validate(bt);
        if (!r.getValue0()) {
        	model.addAttribute("error", r.getValue1());
        	ra.addFlashAttribute("error", r.getValue1());
            return (bt.getId()== null) ? "redirect:/bookTypes/add": "redirect:/bookTypes/edit?id=" + bt.getId();
        }
        
		bookTypesServiceImpl.insertOrUpdate(bt);
        return "redirect:/bookTypes/list";
    }
	
	private Pair<Boolean, String> validate(BookTypes c) {
    	String error = "";
    	if (StringUtils.isEmpty(c.getName())) error = "book type name is required!";
    	
    	if (StringUtils.isEmpty(error)) return new Pair<Boolean, String>(true, "");
    	return new Pair<Boolean, String>(false, error);
    }
}
