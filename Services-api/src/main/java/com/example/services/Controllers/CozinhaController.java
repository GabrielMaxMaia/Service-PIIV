package com.example.services.Controllers;

import java.util.ArrayList;
import java.util.Iterator;
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

		List<String> id = new ArrayList<>();
		List<String> nome = new ArrayList<>();
		List<String> quantidade = new ArrayList<>();
		List<String> observacao = new ArrayList<>();
		List<String> status = new ArrayList<>();

		for (int i = 0; i < listaPedido.size(); i++) {

			String linha = " ";
			String vLinha[] = null;

			linha = listaPedido.get(i);

			vLinha = linha.split(",");

			id.add(vLinha[0]);
			nome.add(vLinha[1]);
			quantidade.add(vLinha[2]);
			observacao.add(vLinha[3]);
			status.add(vLinha[4]);

		}

		ModelAndView mv = new ModelAndView("cozinha/listarPedidos");

		
		mv.addObject("ids", id);
		mv.addObject("nomes", nome);
		mv.addObject("quantidades", quantidade);
		mv.addObject("observacoes", observacao);
		mv.addObject("status", status);

		return mv;

	}
}
