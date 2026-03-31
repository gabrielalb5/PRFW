package edu.ifsp.loja.persistence;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.ifsp.loja.modelo.Cliente;
import jakarta.transaction.Transactional;

@SpringBootTest
@Transactional
public class ClienteTest {

	@Autowired
	private ClienteRepositorio clienteRepo;

	@Test
	void findById() {
		Cliente found = clienteRepo.findById(1).get();
		assertAll(
				() -> assertEquals(1, found.getId()), 
				() -> assertEquals("juvenal@freemail.com", found.getEmail())
		);
	}
	
	@Test
	void findAll() {
		List<Cliente> clientes = clienteRepo.findAll();
		int[] ids = clientes.stream().mapToInt(c -> c.getId()).toArray();
		
		assertAll(
				() -> assertEquals(3, clientes.size()),
				() -> assertArrayEquals(new int[] {1, 2, 3}, ids) 
		);
	}
	
	@Test
	void saveNew() {
		Cliente c = new Cliente();
		c.setNome("Tarcísio Tavares");
		c.setEmail("tarcisio@test.com");
		
		assertNull(c.getId());
		clienteRepo.save(c);		
		assertNotNull(c.getId());
		
		Cliente saved = clienteRepo.findById(c.getId()).get();
		assertEquals(c.getEmail(), saved.getEmail());
	}
	
	@Test
	void updateExisting() {
		final String nome = "Orlando Oliveira";
		final Integer id = 3;
		
		Cliente existing = clienteRepo.findById(id).get();
		existing.setNome(nome);
		clienteRepo.save(existing);
		
		Cliente retrieved = clienteRepo.findById(id).get();
		assertEquals(nome, retrieved.getNome());
	}
	
	
}
