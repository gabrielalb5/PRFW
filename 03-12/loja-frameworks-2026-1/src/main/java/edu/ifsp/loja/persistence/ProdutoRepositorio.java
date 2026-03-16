package edu.ifsp.loja.persistence;

import edu.ifsp.loja.modelo.Produto;

public interface ProdutoRepositorio {
	Produto findById(int id);
	Iterable<Produto> findAll();
	Produto save(Produto produto);
}