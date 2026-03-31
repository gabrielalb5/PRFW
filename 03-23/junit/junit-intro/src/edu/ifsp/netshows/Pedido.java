package edu.ifsp.netshows;

import java.util.ArrayList;

public class Pedido {
	private int id;
	private double frete;
	private double valorTotal;
	private MeioPagamento pagamento;
	private ArrayList<Produto> produtos = new ArrayList<>();
	
	public Pedido(int id, MeioPagamento pagamento, ArrayList<Produto> produtos) {
		setId(id);
		setPagamento(pagamento);
		setProdutos(produtos);
	}

	public double calcularFrete(double valor, boolean allVirtual) {
		
		if(valor > 200 || allVirtual) {
			frete = 0;
		}else {
			frete = 30;
		}
		setFrete(frete);
		return frete;
	}
	
	public void calcularValorTotal() {
		double somaProdutos = 0.0;
		boolean allVirtual = true;
		
		for(Produto p : produtos) {
			somaProdutos = somaProdutos + p.getValor();
			if(!p.isVirtual()) {
				allVirtual = false;
			}
		}
		
		double frete = calcularFrete(somaProdutos, allVirtual);

		if(getPagamento() == MeioPagamento.PIX || getPagamento() == MeioPagamento.DEBITO) {
			somaProdutos = somaProdutos*0.95;
		}
		
		setValorTotal(somaProdutos+frete);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public ArrayList<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(ArrayList<Produto> produtos) {
		this.produtos = produtos;
	}
	public double getFrete() {
		return frete;
	}
	private void setFrete(double frete) {
		this.frete = frete;
	}
	public double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	public MeioPagamento getPagamento() {
		return pagamento;
	}
	public void setPagamento(MeioPagamento pagamento) {
		this.pagamento = pagamento;
	}
}
