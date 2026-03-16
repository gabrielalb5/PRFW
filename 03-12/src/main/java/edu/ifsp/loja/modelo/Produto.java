package edu.ifsp.loja.modelo;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class Produto {
	private int id;
	
	@Size(min = 2, max = 30, message = "{produto.descricao.size}")
	private String descricao;
	
    @DecimalMin(value = "0.0", inclusive = false, message = "{produto.preco.positive}")
	private Double preco;
		
	public Produto() {
		
	}
	
	public Produto(int id, String descricao, Double preco) {
		this.id = id;
		this.descricao = descricao;
		this.preco = preco;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
}