package com.example.services.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.services.Model.Pedido;
import com.example.services.repositories.CozinhaRepository;
import com.example.services.repositories.PedidoRepository;

@Controller
@RequestMapping("/cozinha")
public class CozinhaController {
	
	@Autowired
	private CozinhaRepository cozinhaRepository;
	
	@GetMapping("/listar")
	public ModelAndView listar(Model model) {		 
		
		
			List<String> listaPedido = cozinhaRepository.findPedidos();
			
			
			System.out.println(listaPedido.get(0).toString()) ;
			
			//ModelAndView mv = new ModelAndView("cozinha/listarPedidos");
			
			//mv.addObject("pedidos", listaPedido);			
			
			return null;
		
				
		
		
	}
}
