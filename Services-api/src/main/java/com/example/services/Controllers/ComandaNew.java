package com.example.services.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.services.Model.Comanda;
import com.example.services.Model.NewComanda;
import com.example.services.repositories.ComandaRepository;
import com.example.services.repositories.MesaRepository;
import com.example.services.repositories.NewComandaRepository;
import com.example.services.repositories.ProdutoRepository;

@Controller
@RequestMapping("/newcomanda")
public class ComandaNew {

	@Autowired
	private MesaRepository mesaRepository;
	
	@Autowired
	private NewComandaRepository newComanda;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	
	@GetMapping
	public String listar(Model model) {
		List<NewComanda> listaComandas = newComanda.findAll();
		model.addAttribute("listaComandas", listaComandas);
		return "/newcomanda/listarComanda";
	} 
}
