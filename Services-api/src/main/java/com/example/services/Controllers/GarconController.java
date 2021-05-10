package com.example.services.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.services.Model.Mesa;
import com.example.services.repositories.MesaRepository;

@Controller
@RequestMapping("/garcons")
public class GarconController {
	
	@Autowired
	private MesaRepository mesaRepository;
	
	@GetMapping
	public String listar(Model model) {
		// lista de mesa
		List<Mesa> mesas = this.mesaRepository.findAll();
		model.addAttribute("mesas", mesas);
		return "/garcon/dashboardG";
	}
}
