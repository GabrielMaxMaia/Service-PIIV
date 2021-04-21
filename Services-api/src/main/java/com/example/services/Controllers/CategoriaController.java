package com.example.services.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.services.repositories.CategoriaRepository;

@Controller
public class CategoriaController {

	@Autowired
	private CategoriaRepository categoria;
	
	@GetMapping("/categorias")
	public ModelAndView listar() {
		ModelAndView modelView = new ModelAndView("categoria/listarCategorias");
		modelView.addObject("categorias", categoria.findAll());
		return modelView;
	}
	
}
