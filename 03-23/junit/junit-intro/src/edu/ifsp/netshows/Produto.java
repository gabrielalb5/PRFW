package edu.ifsp.netshows;

public class Produto {
	private String descricao;
	private double valor;
	private boolean virtual;
	
	public Produto(String descricao, double valor, boolean virtual) {
		setDescricao(descricao);
		setValor(valor);
		setVirtual(virtual);
	}
	
	public String getDescricao() {
		return descricao;
	}
	private void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getValor() {
		return valor;
	}
	private void setValor(double valor) {
		this.valor = valor;
	}	
	public boolean isVirtual() {
		return virtual;
	}
	public void setVirtual(boolean virtual) {
		this.virtual = virtual;
	}
}
