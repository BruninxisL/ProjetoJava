package com.example.pastelaria.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.pastelaria.model.Pratos;
import com.example.pastelaria.model.Users;
import com.example.pastelaria.repository.PratosRepository;

@Controller
public class PratosController {
	@Autowired
	private PratosRepository pratoRepo;
	
	@GetMapping("/pratos")
	public String index(Model model) {
		List<Pratos> pratos = (List<Pratos>)pratoRepo.findAll();
		model.addAttribute("pratos", pratos);
		return "pratos/index";
	}
	
	@GetMapping("/pratos/novo")
		public String pratoNovo() {
			return "pratos/novoPrato";
	}
	
	
	@PostMapping("/pratos/cadastrar")
	public String cadastrarPrato(Pratos prato) {
		pratoRepo.save(prato);
		
		return"redirect:/pratos";
	}
	
	@GetMapping("/pratos/{cod_prato}")//Método Responsável por setar os campos do formulário Editar Usuário com os Respectivos dados para ser possivel realizar a edição
	public String buscarUsuario(@PathVariable int cod_prato, Model model) {
		Optional<Pratos> prato = pratoRepo.findById(cod_prato);
		try {
			model.addAttribute("prato", prato.get());
		} catch(Exception e){
			return "redirect:/pratos";
		}
		return "users/editarPrato";
	}
	
}
