package com.example.services.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.services.Model.Usuario;
import com.example.services.repositories.usuarioRepository;

@Controller
public class UsuarioController {

	@Autowired
	private usuarioRepository usuarioRepository;

	@GetMapping("/usuarios")
	public ModelAndView index() {

		List<Usuario> usuarios = this.usuarioRepository.findAll();
		ModelAndView mv = new ModelAndView("usuarios/index");
		mv.addObject("usuarios", usuarios);
		return mv;
	}
}
