package com.example.services.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import com.example.services.Model.Usuario;

// é uma classe dto (data transfer object) uma classe auxiliar de segurança para receber o formulario html apenas esses atributos
public class RequisicaoNovoUsuario {
	
	
	private Long codigo;
	
	@NotBlank
	private String nome;
	
	@NotBlank
	@Email
	private String email;
	
	@NotBlank
	private String senha;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Usuario toUsuario() {
		Usuario usuario = new Usuario();
		usuario.setCodigo(this.codigo);
		usuario.setNome(this.nome);
		usuario.setEmail(this.email);
		usuario.setSenha(this.senha);
		
		return usuario;
	}
	
	public Usuario toUsuario(Usuario usuario) {		
		usuario.setCodigo(this.codigo);
		usuario.setNome(this.nome);
		usuario.setEmail(this.email);
		usuario.setSenha(this.senha);
		return usuario;
	}
	
	public void fromUsuario(Usuario usuario) {
		this.codigo = usuario.getCodigo();
		this.nome = usuario.getNome();
		this.email = usuario.getEmail();
		this.senha = usuario.getSenha();
	}

}
