package edu.ifsp.netshows;

import java.util.ArrayList;

public class Main {
	public static void maind(String[] args) {
		Produto p1 = new Produto("Camiseta NetShows",70.00,false);
		Produto p2 = new Produto("Guitarra Elétrica",500.00,false);
		Produto p3 = new Produto("Ingresso Beatles",150.00,false);
		Produto p4 = new Produto("Violino 4/4",300.00,false);
		
		ArrayList<Produto> lista1 = new ArrayList<>();
		lista1.add(p1);
		lista1.add(p2);
		lista1.add(p3);
		
		ArrayList<Produto> lista2 = new ArrayList<>();
		lista2.add(p1);
		
		Pedido ped1 = new Pedido(0, MeioPagamento.CHEQUE, lista1);
		Pedido ped2 = new Pedido(0, MeioPagamento.PIX, lista2);
	}
}
