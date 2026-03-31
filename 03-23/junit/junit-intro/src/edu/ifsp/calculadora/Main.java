package edu.ifsp.calculadora;

public class Main {
	public static void maind(String[] args) {
		Calculadora calc = new Calculadora();
		
		int res = calc.somar(5,2);
		System.out.println(res);
	}
}
