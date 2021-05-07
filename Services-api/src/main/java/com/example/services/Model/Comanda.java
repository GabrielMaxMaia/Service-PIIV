package com.example.services.Model;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="comanda" , schema = "targetSchemaName")
public class Comanda {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@NotNull
	@ManyToOne 							
	@JoinColumn(name = "id_mesa")
	private Mesa mesa;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="mesa_produto", joinColumns = @JoinColumn(name = "id_mesa"),
									inverseJoinColumns = @JoinColumn(name = "id_produto"))
	private Set<Produto> produtos = new HashSet<>();
	
	
	/*@Column(name = "valorTotal")
	private BigDecimal valor;*/
	
	private Integer quantidade;
	
	
	public float somador(Produto produto,int quantidade) {
		float result =  produto.getValor().floatValue() * quantidade;
		return result;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Mesa getMesa() {
		return mesa;
	}


	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}


	public Set<Produto> getProdutos() {
		return produtos;
	}


	public void setProdutos(Set<Produto> produtos) {
		this.produtos = produtos;
	}


	/*public BigDecimal getValor() {
		return valor;
	}


	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}*/


	public Integer getQuantidade() {
		return quantidade;
	}


	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	

}
	