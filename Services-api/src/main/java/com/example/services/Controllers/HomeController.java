package com.example.services.Controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String home() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		System.out.println(auth.getPrincipal()) ;
		System.out.println(auth.getAuthorities()) ;
		System.out.println(auth.getDetails()) ;		
		
		return "home"; // renderiza o arquivo templates/home.html
	}
	
	@GetMapping("/entrar")
    public String entrar() {
        return "entrar";
    }
}
