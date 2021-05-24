package com.example.services.Controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.services.Model.Mesa;
import com.example.services.Model.Pedido;
import com.example.services.Model.Produto;
import com.example.services.Model.Usuario;
import com.example.services.dto.ReqCaixa;
import com.example.services.repositories.MesaRepository;
import com.example.services.repositories.PedidoRepository;
import com.example.services.repositories.ProdutoRepository;

@Controller
@RequestMapping("/dashAdm")
public class RelatoriosController {
	
	@Autowired
	private MesaRepository mesaRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@GetMapping
	public String listarMesas(Model model) {
		
		
		// lista de mesa
		List<Mesa> mesas = this.mesaRepository.findAll();
		model.addAttribute("mesas", mesas);
		return "/administracao/dashboard/dashboard";
	}
	
	@GetMapping("/mesa/{id}")
	public ModelAndView visualizarCaixa(@PathVariable Long id) {
		if (!pedidoRepository.findPedidosByMesa(id).isEmpty()) {

			ModelAndView mv = new ModelAndView("/administracao/dashboard/PedidosMesa");

			

			List<Pedido> listaPedido = pedidoRepository.findPedidosByMesa(id);
			
			List<ReqCaixa> listaCaixa = new ArrayList<ReqCaixa>();

			for (int j = 0; j < listaPedido.size(); j++) {

				Optional<Produto> p = produtoRepository.findById(listaPedido.get(j).getProduto().getId());
				Produto pp = p.get();
				
				ReqCaixa caixa = new ReqCaixa();

				caixa.setNome(pp.getNome());
				caixa.setValor(pp.getValor());
				caixa.setMesa(listaPedido.get(j).getMesa().getNumero());
				caixa.setQuantidade(listaPedido.get(j).getQuantidade());			

				listaCaixa.add(caixa);
			}			
			
			mv.addObject("valorTotal",pedidoRepository.findValorTotalMesa(id));
			mv.addObject("listaCaixa",listaCaixa);
			mv.addObject("id",id);
			
			return mv;
		} else {

			ModelAndView mv = new ModelAndView("redirect:/dashAdm");
			return mv;

		}

	}
}
