package edu.ifsp.netshows;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NetshowsTest {
	
	ArrayList<Produto> lista1 = new ArrayList<>();
	ArrayList<Produto> lista2 = new ArrayList<>();
	
	@BeforeEach
	void setup() {
		Produto p1 = new Produto("Camiseta NetShows",70.00,false);
		Produto p2 = new Produto("Guitarra Elétrica",500.00,false);
		Produto p3 = new Produto("Ingresso Beatles",150.00,false);
		Produto p4 = new Produto("Violino 4/4",300.00,false);
		
		lista1.add(p1);
		lista1.add(p2);
		lista1.add(p3);
		
		lista2.add(p1);
	}
	
	@Test
	void testValorTotal(){
		Pedido ped1 = new Pedido(1, MeioPagamento.CHEQUE, lista1);
		Pedido ped2 = new Pedido(2, MeioPagamento.PIX, lista2);
		ped1.calcularValorTotal();
		ped2.calcularValorTotal();
		
		assertEquals(720, ped1.getValorTotal());
		assertEquals(96.5, ped2.getValorTotal());
	}
	
	void testValorFrete(){
		Pedido ped1 = new Pedido(1, MeioPagamento.CHEQUE, lista1);
		Pedido ped2 = new Pedido(2, MeioPagamento.PIX, lista2);
		ped1.calcularValorTotal();
		ped2.calcularValorTotal();
		
		assertEquals(0, ped1.getValorTotal());
		assertEquals(30, ped2.getValorTotal());
	}
}
