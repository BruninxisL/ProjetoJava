package com.example.pastelaria.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.pastelaria.model.MovimentacaoEstoque;
import com.example.pastelaria.model.Produto;
import com.example.pastelaria.repository.MovimentacaoRepository;
import com.example.pastelaria.repository.ProdutoRepository;

@Controller
public class ProdutoController {
	
	@Autowired
	private MovimentacaoRepository moviRepo;
	@Autowired
	private ProdutoRepository produtoRepo;
	
	@GetMapping("/estoque")
	public String index(Model model) {
		List<Produto> produtos = (List<Produto>)produtoRepo.findAll();	
		model.addAttribute("produtos",produtos);
		
		
		return "estoque/index";
	}
	
	@GetMapping("estoque/novo")
	public String produtoNovo() {
		return "estoque/novoProduto";
	}
	
	@PostMapping("estoque/cadastrar")
	public String cadastrarProduto(Produto produto) {
		produto.setDataCadastro(LocalDateTime.now());
		produtoRepo.save(produto);

		MovimentacaoEstoque movimentacao = new MovimentacaoEstoque();
		movimentacao.setTipoMovimentacao("ENTRADA");
		movimentacao.setCod_produto(produto);
		movimentacao.setQuantidade(produto.getQuantidade());
		movimentacao.setDataHora(LocalDateTime.now());
		moviRepo.save(movimentacao);
		return "redirect:/estoque";
	}
	
	@GetMapping("/estoque/{cod_produto}")
	public String buscarProduto(@PathVariable int cod_produto, Model model) {
		Optional<Produto> produto = produtoRepo.findById(cod_produto);
		try {
			model.addAttribute("produto", produto.get());
		}catch(Exception e){
			return "redirect:/estoque";
		}
		
		return "estoque/editarProduto";
	}
	
	@PostMapping("/estoque/{cod_produto}/atualizar")
	public String atualizarProduto(@PathVariable int cod_produto, Produto produto) {
		if(!produtoRepo.existsById(cod_produto)){
			return "redirect:/estoque";
		}
		
		produtoRepo.save(produto);
		return "redirect:/estoque";
	}
	
	@GetMapping("/estoque/{cod_produto}/excluir")// Método responsável por deletar o usuário da base de dados
	public String excluirProduto(@PathVariable int cod_produto) {
		
		
		produtoRepo.deleteById(cod_produto);
	
		return "redirect:/estoque";
	}
}
