package edu.ifsp.calculadora;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

class CalculadoraTest {
	private Calculadora calc = new Calculadora();
	
	@Test
	void testSomar(){
		assertEquals(7, 	calc.somar(5, 2));
		assertEquals(-7, 	calc.somar(-5, -2));
		assertEquals(20000, calc.somar(16700, 3300));
		assertEquals(16, 	calc.somar(-2, 18));
		assertEquals(2, 	calc.somar(0, 2));
	}
	
	@Test
	void testDividir(){
		assertEquals(5, 		calc.dividir(10, 2));
		final int qualquer = 100;
		assertEquals(qualquer,	calc.dividir(qualquer, 1));
	}
	
	@Test
	void testExcecao() {
		try {
			calc.dividir(1, 0);
			fail("ArithmeticException esperada");
		}catch(ArithmeticException e) {
			// OK
		}
	}
}
