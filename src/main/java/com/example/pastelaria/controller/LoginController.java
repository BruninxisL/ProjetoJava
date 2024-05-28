package com.example.pastelaria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.pastelaria.model.Users;
import com.example.pastelaria.repository.UsersRepository;



@Controller
public class LoginController {
	
	@Autowired
	private UsersRepository userRepository;
	
	
	@GetMapping("/")
	public String  index() {
		return "login/index";
	}
	
	@PostMapping("/logar")
	public String logar(Model model, Users userParam) {
		Users user = this.userRepository.login(userParam.getUsername(),userParam.getSenha());
		if(user != null) {
			return "redirect:/home";
		}
		model.addAttribute("erro","Usuário ou Senha inválidos");
		
		return "login/index";
	}
}
