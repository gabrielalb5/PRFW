package edu.ifsp.loja.persistence;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.ifsp.loja.modelo.Cliente;
import edu.ifsp.loja.modelo.Produto;
import jakarta.transaction.Transactional;

@SpringBootTest
@Transactional
public class ProdutoTest {

	@Autowired
	private ProdutoRepositorio produtoRepo;

	@Test
	void buscaPeloId() {
		Produto dadosBanco = produtoRepo.findById(3).get();
		assertEquals(3, dadosBanco.getId());
		assertEquals("Pen drive", dadosBanco.getDescricao());
		assertTrue(dadosBanco.getPreco() > 0, "Preço deve ser positivo");
	}
	
	/*@Test
	//Esse teste não vai rodar pois as tabelas de pedido e pedido_item dependem do produto
	void exclusao() {
		final Integer id = 3;
		List<Produto> produtos = produtoRepo.findAll();
		assertTrue(produtoRepo.existsById(id), "O produto deve existir antes da exclusão");
		
		produtoRepo.deleteById(id);
		
	    assertFalse(produtoRepo.existsById(id), "O produto deveria ter sido excluído");
		
		int[] ids = produtos.stream().mapToInt(p -> p.getId()).toArray();
		
		assertAll(
			() -> assertEquals(3, produtos.size()),
			() -> assertArrayEquals(new int[] {1, 2, 4}, ids) 
		);
	}*/
	
	@Test
	void saveNew() {
		Produto p = new Produto();
		p.setDescricao("Banana");
		p.setPreco(10.00);
		
		assertNull(p.getId());
		produtoRepo.save(p);		
		assertNotNull(p.getId());
		
		Produto saved = produtoRepo.findById(p.getId()).get();
		assertEquals(p.getDescricao(), saved.getDescricao());
	}
}
