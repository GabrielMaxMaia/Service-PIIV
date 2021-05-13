package com.example.services.Controllers;



import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.services.Model.Comanda;
import com.example.services.Model.Mesa;
import com.example.services.Model.Produto;
import com.example.services.repositories.ComandaRepository;
import com.example.services.repositories.MesaRepository;
import com.example.services.repositories.ProdutoRepository;

@Controller
@RequestMapping("/comandas")
public class ComandaController {
	
	@Autowired
	private MesaRepository mesaRepository;
	
	@Autowired
	private ComandaRepository comandaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@GetMapping
	public String listar(Model model) {
		List<Comanda> listaComandas = comandaRepository.findAll();
		model.addAttribute("listaComandas", listaComandas);
		return "/comanda/listarComanda";
	}
	
	@GetMapping("/criar")
	public ModelAndView form() {
		ModelAndView mv = new ModelAndView("/comanda/criarComanda");

		Comanda comanda = new Comanda();
		mv.addObject(comanda);
		
		// lista de produtos
		List<Produto> produtos = this.produtoRepository.findAll();
		mv.addObject("listProdutos", produtos);
		
		// lista de mesa
		List<Mesa> mesas = this.mesaRepository.findAll();
		mv.addObject("listMesa", mesas);
		
		return mv;
	}
	
	@GetMapping("delete/{id}")
	public String deleteComandaForm(@PathVariable Long id) {
	    this.comandaRepository.deleteById(id);
	    return "redirect:/comandas";       
	}
	
	
	@PostMapping("")
	public ModelAndView create(@Valid Comanda comanda, BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {
			ModelAndView mv = new ModelAndView("/comanda/criaComanda");				
			return mv;
		} else {			
			this.comandaRepository.save(comanda);
			ModelAndView mv = new ModelAndView("comanda/EditarComanda");
			List<Mesa> mesas = this.mesaRepository.findAll();
			mv.addObject("mesa", mesas);
			List<Produto> produtos = this.produtoRepository.findAll();
			mv.addObject("produto",produtos);
			return mv;
		}
	}
	
	@GetMapping("/{id}/editar")
	public ModelAndView edit(@PathVariable Long id, Comanda requisicao) {
		Optional<Comanda> optional = this.comandaRepository.findById(id);

		if (optional.isPresent()) {
			Comanda comanda = optional.get();			
			ModelAndView mv = new ModelAndView("comanda/EditarComanda");			
			mv.addObject("comandaId", comanda.getId());
			return mv;

		} else {

			return new ModelAndView("redirect:/comandas");

		}

	}
	
	@PostMapping("/{id}")
	public ModelAndView update(@PathVariable Long id, @Valid Comanda requisicao,
			BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {

			ModelAndView mv = new ModelAndView("comanda/editarComanda");
			mv.addObject("comandaId", id);
			return mv;
			
		} else {
			Optional<Comanda> optional = this.comandaRepository.findById(id);
			
			if(optional.isPresent()) {				
				Comanda comanda = optional.get();
				comanda.setId(id);
				this.comandaRepository.save(comanda);
				return new ModelAndView("redirect:/comandas");
			}else {
				return new ModelAndView("redirect:/comandas");
			}
		}

	}
	
	@GetMapping("{id}/deletar")
	public String delete(@PathVariable Long id) {
		try {
			this.comandaRepository.deleteById(id);
			return "redirect:/usuarios";
		}catch(EmptyResultDataAccessException e){			
			return "redirect:/usuarios";
		}
		
	}

}
