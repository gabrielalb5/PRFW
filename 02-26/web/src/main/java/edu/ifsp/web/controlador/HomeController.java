package edu.ifsp.web.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller //1º passo anotação
public class HomeController {
	
	@GetMapping("/") // 2º quando bater em localhost:8080 já ir pra raiz home
	public String home(@RequestParam(name = "nome", required = false, defaultValue = "abacate") String nome, Model model) {
		System.out.println("Parâmetro: "+nome);
		model.addAttribute("farinha",nome);
		//model.addAttribute("sala","Info1");
		return "abacate"; //3º abacate faz referência à página html abacate.html que fica em templates (criar html e tals)
	}
}
