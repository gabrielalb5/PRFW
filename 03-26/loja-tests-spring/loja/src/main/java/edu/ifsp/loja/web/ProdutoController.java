package edu.ifsp.loja.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.ifsp.loja.modelo.Produto;
import edu.ifsp.loja.persistence.ProdutoRepositorio;

@Controller
@RequestMapping("/produto")
public class ProdutoController {
	private final ProdutoRepositorio repo;
	
	public ProdutoController(ProdutoRepositorio repo) {
		this.repo = repo;
	}
	
	@GetMapping("/listar")
	public String listar(Model model) {
		Iterable<Produto> produtos = repo.findAll();
		model.addAttribute("produtos", produtos);
		return "produto/listar";
	}
	
}
