package com.example.services.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.services.Model.Produto;
import com.example.services.repositories.ProdutoRepository;

@Controller
public class HomeController {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@GetMapping("/")
	public ModelAndView home() {
		
		List<Produto> lanches = new ArrayList<>();
		List<Produto> bebidas = new ArrayList<>();
		List<Produto> sobremesas = new ArrayList<>();
		List<Produto> acompanhamentos = new ArrayList<>();
		
		List<Produto> produtos = produtoRepository.findAll();
		
		for (Produto produto : produtos) {
			
			if(produto.getCategoria().getId() == 1) {
				
				lanches.add(produto);
			}
			else if (produto.getCategoria().getId() == 2){
				
				bebidas.add(produto);
			}
			else if(produto.getCategoria().getId() == 3){
				
				sobremesas.add(produto);
			}
			else {
				
				acompanhamentos.add(produto);
			}
		}
		
		ModelAndView mv = new ModelAndView("home");
		
		mv.addObject("lanches", lanches);
		mv.addObject("bebidas" ,bebidas);
		mv.addObject("sobremesas", sobremesas);
		mv.addObject("acompanhamentos", acompanhamentos);
		
		return mv;
	}
	
	@GetMapping("/entrar")
    public String entrar() {
        return "entrar";
    }
	
}
