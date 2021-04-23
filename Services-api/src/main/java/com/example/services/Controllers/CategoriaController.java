package com.example.services.Controllers;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.services.repositories.CategoriaRepository;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {

	@Autowired
	private CategoriaRepository categoria;
	
	@GetMapping
	public ModelAndView listar() {
		ModelAndView modelView = new ModelAndView("categoria/listarCategorias");
		modelView.addObject("categorias", categoria.findAll());
		return modelView;
	}
	
	@GetMapping("delete/{id}")
	public String deleteCustomerForm(@PathVariable Long id) {
	    this.categoria.deleteById(id);
	    return "redirect:/categorias";       
	}
	
}
