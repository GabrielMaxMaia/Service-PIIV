package com.example.services.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.services.repositories.ProdutoRepository;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@GetMapping
	public ModelAndView listar() {
		ModelAndView modelView = new ModelAndView("produto/listarProdutos");
		modelView.addObject("produtos",produtoRepository.findAll());
		return modelView;
	}
	
}
