package com.example.services.Controllers;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.services.Model.Comanda;
import com.example.services.Model.Mesa;
import com.example.services.Model.Pedido;
import com.example.services.Model.Produto;
import com.example.services.Model.Usuario;
import com.example.services.dto.ReqNovoPedido;
import com.example.services.dto.RequisicaoNovoUsuario;
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
	
	@GetMapping("/criar")
	public ModelAndView form() {
		ModelAndView mv = new ModelAndView("/pedido/CriarPedido");

		ReqNovoPedido pedido = new ReqNovoPedido();
		mv.addObject(pedido);
						
		// lista de produtos
		List<Produto> produtos = this.produtoRepository.findAll();
		mv.addObject("produtos", produtos);
		
		return mv;
	}
	
	@PostMapping("")
	public ModelAndView create(@Valid ReqNovoPedido reqpedido, BindingResult bindingResult) {
		// binding result é um parametro do validation do spring utilizado em conjunto
		// com o @valid
		if (bindingResult.hasErrors()) {
			System.out.println(reqpedido);
			System.out.println(bindingResult.toString());
			ModelAndView mv = new ModelAndView("pedido/CriarPedido");
			return mv;
		} else {
			
			Pedido pedido = new Pedido();
			
			pedido.setProduto(reqpedido.getProduto());
			pedido.setQuantidade(reqpedido.getQuantidade());
			pedido.setObservacao(reqpedido.getObservacao());
			
			Long id = this.comandaRepository.findComanda();	
			Optional<Comanda> optional = this.comandaRepository.findById(id);
			Comanda comanda = optional.get();
			pedido.setComanda(comanda);	
			pedido.setMesa(comanda.getMesa());			
			pedido.setHoraDoPedido(OffsetDateTime.now());
			pedido.setStatus("preparacao");		
			
			Optional<Usuario> optional2 = this.usuarioRepository.findById(6l);//verificar	a forma que será recuperado o usuario para salvar o pedido	
			Usuario usuario = optional2.get();			
			pedido.setUsuario(usuario);
			
			this.pedidoRepository.save(pedido);			
			return redirecionar(comanda.getId(),bindingResult);
		}

	}
	
	@RequestMapping(value = "/pedidos/listar", method = RequestMethod.GET)			
	public ModelAndView redirecionar(Long id, BindingResult bindingResult) {			
		ModelAndView mv = new ModelAndView("redirect:/pedidos/"+id+"/listar");		
		return mv;
	}
}
