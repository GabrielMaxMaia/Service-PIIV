package com.example.services.Controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.services.Model.Comanda;
import com.example.services.Model.Pedido;
import com.example.services.Model.Usuario;
import com.example.services.repositories.ComandaRepository;
import com.example.services.repositories.MesaRepository;
import com.example.services.repositories.PedidoRepository;
import com.example.services.repositories.ProdutoRepository;
import com.example.services.repositories.UsuarioRepository;

@Controller
@RequestMapping("/pedidos")
public class PedidoController {

	@Autowired
	private MesaRepository mesaRepository;

	@Autowired
	private ComandaRepository comandaRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@GetMapping("/{id}/listar")
	public ModelAndView listar(@PathVariable Long id, Model model) {
		
		//List<Pedido> listaPedido = new ArrayList<>();	

		//listaPedido.add(pedidoRepository.findById(id).orElseThrow());
		//model.addAttribute("Pedidos", listaPedido);	
		
		//Optional<Pedido> optional = this.pedidoRepository.findById(id);
		
		List<Pedido> listaPedido = pedidoRepository.findByComandaId(id);
		
		ModelAndView mv = new ModelAndView("pedido/listarPedidos");
		
		mv.addObject("pedidos", listaPedido);
		
		return mv;
		
		/*if (optional.isPresent()) {
			listaPedido.add(optional.get()) ;			
			ModelAndView mv = new ModelAndView("pedido/listarPedidos");
			mv.addObject("pedidos", listaPedido);
			return mv;

		} else {

			return new ModelAndView("redirect:/usuarios");

		}*/
		
		
	}
}
