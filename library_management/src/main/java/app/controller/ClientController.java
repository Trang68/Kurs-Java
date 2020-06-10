package app.controller;

import org.apache.commons.lang3.StringUtils;
import org.javatuples.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import app.entity.Clients;
import app.service.ClientsServiceImpl;
import app.service.SecurityServiceImpl;


@Controller
public class ClientController {
	@Autowired
	ClientsServiceImpl clientsServiceImpl;
	
	 @Autowired
	 private SecurityServiceImpl securityServiceImpl;
	
 	@GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new Clients());
        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("userForm") Clients client, Model model) {
    	Pair<Boolean,String> r = this.validate(client);
        if (!r.getValue0()) {
        	model.addAttribute("error", r.getValue1());
            return "registration";
        }

        clientsServiceImpl.save(client);
        return "redirect:/welcome";
    }
    
    @GetMapping({"/", "/welcome"})
    public String welcome(Model model) {
        return "welcome";
    }
    
    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }
    
    private Pair<Boolean, String> validate(Clients c) {
    	String error = "";
    	Clients client = this.clientsServiceImpl.getClientBySeria(c.getPassportSeria());
    	if (client != null) error = "Passport Seria is existed!";
    	if (StringUtils.isEmpty(c.getPassportSeria())) error = "Passport Seria is required!";
    	if (StringUtils.isEmpty(c.getPassportNum())) error = "Passport num is required!";
    	if (this.clientsServiceImpl.getClientBySeria(c.getPassportSeria()) != null) error = "Passport Seria is existed!";
    	if (StringUtils.isEmpty(error)) return new Pair<Boolean, String>(true, "");
    	return new Pair<Boolean, String>(false, error);
    }
}
