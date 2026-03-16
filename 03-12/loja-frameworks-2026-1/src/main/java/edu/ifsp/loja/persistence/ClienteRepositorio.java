package edu.ifsp.loja.persistence;

import edu.ifsp.loja.modelo.Cliente;

public interface ClienteRepositorio {
	Cliente findById(int id);
	Iterable<Cliente> findAll();
	Cliente save(Cliente cliente);
}
