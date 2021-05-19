package com.example.services.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String home() {
		return "home"; // renderiza o arquivo templates/home.html
	}
	
	@GetMapping("/entrar")
    public String entrar() {
        return "entrar";
    }
}
