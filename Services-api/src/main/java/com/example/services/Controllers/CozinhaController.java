package com.example.services.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.services.dto.ReqCozinha;
import com.example.services.repositories.CozinhaRepository;

@Controller
@RequestMapping("/cozinha")
public class CozinhaController {

	@Autowired
	private CozinhaRepository cozinhaRepository;

	@GetMapping("/listar")
	public ModelAndView listar(Model model) {

		List<String> listaPedido = cozinhaRepository.findPedidos();
				
		List<ReqCozinha> listar = new ArrayList<>();		
		
		
		for (int i = 0; i < listaPedido.size(); i++) {

			String linha = " ";
			String vLinha[] = null;

			linha = listaPedido.get(i);

			vLinha = linha.split(",");
			
			ReqCozinha cozinha = new ReqCozinha();			
			

			cozinha.setId(Long.parseLong(vLinha[0]));
			cozinha.setNome(vLinha[1]);
			cozinha.setQuantidade(Integer.parseInt(vLinha[2]));
			cozinha.setObservacao(vLinha[3]);
			cozinha.setStatus(vLinha[4]);
			
			listar.add(cozinha);
			
		}

		ModelAndView mv = new ModelAndView("cozinha/listarPedidos");	
		
		
		mv.addObject("listar",listar);				

		return mv;

	}
}
