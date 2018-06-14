package com.io.crud.iocrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.io.crud.iocrud.model.Passageiro;
import com.io.crud.iocrud.service.PassageiroService;
@Controller
public class PassageiroController {
	
	private PassageiroService passageiroService;
	
	@Autowired
	public PassageiroController(PassageiroService passageiroService) {
		this.passageiroService = passageiroService;
	}
	
	@RequestMapping("/passageiro")
	public String home(Model model) {
		model.addAttribute("passageiro", new Passageiro());
		return "passageiro";
	}
	
	@RequestMapping("/inserir-passageiro")
	public String insertPassageiro(@ModelAttribute Passageiro passageiro, Model model) {
		
		passageiroService.insertPassageiro(passageiro);
		Model addAttribute = model.addAttribute("passageiros", passageiroService.getAllPassageiros());
		return browser(addAttribute);
	}
	
	@RequestMapping("/browser-passageiro")
	public String browser(Model model) {
		model.addAttribute("passageiros", passageiroService.getAllPassageiros());
		return "browser-passageiro";
	}
	
	@RequestMapping("/editar-passageiro{id}")
	public String editar(@PathVariable Long id, Model model) {
		return "editar-passageiro";
	}
	
	@RequestMapping("/salvar-edicao-passageiro")
	public String salvarEdicao(@ModelAttribute Passageiro passageiro, Model model) {
		Model addAttribute = model.addAttribute("passageiros", passageiroService.getAllPassageiros());
		return browser(addAttribute);
	}
	
	@RequestMapping("/deletar-passageiro{id}")
	public String deletarPassageiro(@PathVariable Long id, Model model) {
		Model addAttribute = model.addAttribute("passageiros", passageiroService.getAllPassageiros());
		return browser(addAttribute);
	}
	
	
}
