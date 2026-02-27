package edu.ifsp.web.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProfileController {
	
	@GetMapping("/profile")
	public String profile(@RequestParam(name = "name", required = false, defaultValue = "Usuário") String name,
						  @RequestParam(name = "profession", required = false, defaultValue = "Desempregado") String profession,
						  @RequestParam(name = "phone", required = false, defaultValue = "+55 16XXXX-XXXX") String phone,
						  @RequestParam(name = "n1", defaultValue = "0") int n1, @RequestParam(name = "n1", defaultValue = "0") int n2,
							Model model){
		model.addAttribute("name",name);
		model.addAttribute("profession",profession);
		model.addAttribute("phone",phone);
		model.addAttribute("soma",n1+n2);
		return "profile";
	}
}
