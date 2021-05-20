package com.example.services.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.services.Model.Comanda;
import com.example.services.Model.Mesa;
import com.example.services.Model.Pedido;
import com.example.services.repositories.ComandaRepository;
import com.example.services.repositories.MesaRepository;
import com.example.services.repositories.PedidoRepository;

@Controller
@RequestMapping("/garcons")
public class GarconController {
	
	@Autowired
	private MesaRepository mesaRepository;
	
	@Autowired
	private ComandaRepository comandaRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@GetMapping
	public String listar(Model model) {
		// lista de mesa
		List<Mesa> mesas = this.mesaRepository.findAll();
		model.addAttribute("mesas", mesas);
		return "/garcon/dashboardG";
	}
	
	@GetMapping("/mesa/{id}")
	public ModelAndView listarPorMesa(@PathVariable Long id) {
		
		List<Comanda> comandas = comandaRepository.comandasPorMesa(id);
		
		if(comandas.isEmpty()) {
			
			return new ModelAndView("redirect:/garcons");
		}
		
		ModelAndView mv = new ModelAndView("garcon/mesa");
		
		mv.addObject("comandas", comandas);
		mv.addObject("id", id);
		
		return mv;
	}
	
	@GetMapping("/comanda/{id}")
	public ModelAndView listarComanda(@PathVariable Long id) {
		
		if(comandaRepository.existsById(id)) {
			List<Pedido> listaPedido = pedidoRepository.findPedidosByComandaId(id);
			ModelAndView mv = new ModelAndView("pedido/comanda/listarPedidos");
			
			mv.addObject("pedidos", listaPedido);
			mv.addObject("id", id);
			
			return mv;
		}else {
			ModelAndView mv = new ModelAndView("pedido/comanda/erroComanda");			
			return mv;		
		}	
	}
}