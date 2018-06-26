package com.example.sso.customer;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")

public class CrmController {

	@Autowired
	private CustomerRepository customerRepository;
	
	@GetMapping
	public String home() {
		return "home";
	}

	@GetMapping("/logout")
	public String logout(HttpServletRequest request) throws Exception {
		request.logout();
		return "redirect:/";
	}

	@GetMapping("/customers")
    public String customers(Model model, Principal principal) {
		
        model.addAttribute(customerRepository.findAll());
        return "customers";
    }

	@GetMapping("/customers/{id}")
	public String customer(@PathVariable("id") Long id, Model model) {
		model.addAttribute(customerRepository.findOne(id));
		return "customer";
	}

}
