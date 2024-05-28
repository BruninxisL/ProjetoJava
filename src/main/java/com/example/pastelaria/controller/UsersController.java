package com.example.pastelaria.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.ui.Model;


import com.example.pastelaria.model.Users;
import com.example.pastelaria.repository.UsersRepository;




@Controller

public class UsersController {
	@Autowired
	private UsersRepository userRepository; // Repositório de Usuários
	
	
	@GetMapping("/usuarios")//pegando todos os usuários e mostrando eles na tabela
	public String index(Model model) {
		List<Users> users = (List<Users>)userRepository.findAll();
		model.addAttribute("users", users);
		return "users/index";
	}
	
	@GetMapping("/usuarios/novo")//rota para chamar o formulário de cadastro de usuários
	public String usuarioNovo() {
		
		return "users/novoUsuario";
	}
	
	@PostMapping("/usuarios/criar") // Método para cadastrar o usuário na base de dados
	public String criarUsuario(Users user) {
		userRepository.save(user);
		
		return "redirect:/usuarios";
	}
	
	@GetMapping("/usuarios/{cod_user}")//Método Responsável por setar os campos do formulário Editar Usuário com os Respectivos dados para ser possivel realizar a edição
	public String buscarUsuario(@PathVariable int cod_user, Model model) {
		Optional<Users> user = userRepository.findById(cod_user);
		try {
			model.addAttribute("user", user.get());
		} catch(Exception e){
			return "redirect:/usuarios";
		}
		return "users/editarUsuario";
	}
	
	@PostMapping("/usuarios/{cod_user}/atualizar")//Método que atualiza os dados do usuário no banco de dados
	public String alterarUsuario(@PathVariable int cod_user, Users user) {
		if(!userRepository.existsById(cod_user)) {
			return "redirect:/usuarios";
		}
		
		userRepository.save(user);
		
		return "redirect:/usuarios";
	}
	
	@GetMapping("/usuarios/{cod_user}/excluir")// Método responsável por deletar o usuário da base de dados
	public String ecluirUsuario(@PathVariable int cod_user) {
		
		userRepository.deleteById(cod_user);
	
		return "redirect:/usuarios";
	}
}
