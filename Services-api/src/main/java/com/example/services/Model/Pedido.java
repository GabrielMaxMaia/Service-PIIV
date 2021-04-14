package com.example.services.Model;

import java.time.OffsetDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "pedido")
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@ManyToOne 						// N para 1, mesa pode ter um pedido ou mais
	@JoinColumn(name = "cod_mesa")
	private Mesa mesa;
	
	@NotNull
	private String status;
	
	@NotNull
	@Column(name = "hora_do_pedido")
	private OffsetDateTime horaDoPedido;
	
	@NotNull
	private Date data;
	
	private String observacao;
	
	@NotNull
	@ManyToOne   						// N para 1, usuario pode ter um pedido ou mais
	@JoinColumn(name = "cod_usuario")
	private Usuario usuario;
	
}
