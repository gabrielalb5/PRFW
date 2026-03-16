package edu.ifsp.loja.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.ifsp.loja.modelo.Produto;
import edu.ifsp.loja.persistence.ProdutoRepositorio;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/produto")
public class ProdutoController {
	private ProdutoRepositorio repo;
	
	public ProdutoController(ProdutoRepositorio repo) {
		this.repo = repo;
	}
	
	@GetMapping("/novo")
	public String iniciar(Model model) {
		Produto produto = new Produto();
		model.addAttribute("produto",produto);
		
		return "produto/editar";
	}
	
	@GetMapping("/{id}/editar")
	public String editar(@PathVariable(name = "id") Integer id, Model model) {
		Produto produto = repo.findById(id);
		model.addAttribute("produto",produto);
		return "produto/editar";
	}
	
	@PostMapping("/salvar")
	public String salvar(@Valid Produto produto, Errors errors) {
		if(errors.hasErrors()) {
			for(var e:errors.getAllErrors()) {
				System.out.println(e);
			}
			return "produto/editar";
		}
		System.out.println("Salvando produto...");
		repo.save(produto);
		
		System.out.println("ID: "+produto.getId());
		System.out.println("Descrição: "+produto.getDescricao());
		System.out.println("Preço: "+produto.getPreco());
		
		return "redirect:/produto/%d/editar".formatted(produto.getId());
	}
	
	@GetMapping("/listar")
	public String listar(Model model) {
		Iterable<Produto> produtos = repo.findAll();			
		model.addAttribute("produtos", produtos);
		return "produto/listar";
	}
}