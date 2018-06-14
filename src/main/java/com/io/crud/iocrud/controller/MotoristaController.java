package com.io.crud.iocrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.io.crud.iocrud.model.Motorista;
import com.io.crud.iocrud.service.MotoristaService;

@Controller
public class MotoristaController {
	
	
	private MotoristaService motoristaService;
	
	@Autowired
	public MotoristaController(MotoristaService motoristaService) {
		this.motoristaService = motoristaService;
	}
	
	
	@RequestMapping(value ="/motorista", method=RequestMethod.GET)
	public String home(Model model){
		model.addAttribute("motorista", new Motorista());
		return "motorista";
	}
	
	@RequestMapping("/inserir-motorista")
	public String insertMotorista(@ModelAttribute Motorista motorista, Model model) {
		
		motoristaService.insertMotorista(motorista);
		Model addAttribute = model.addAttribute("motoristas", motoristaService.getAllMotoristas());
		return browser(addAttribute);
	}
	
	@RequestMapping("/browser-motorista")
	public String browser(Model model) {
		model.addAttribute("motoristas", motoristaService.getAllMotoristas());
		return "motorista-browser";
	}
	
	@RequestMapping("/editar-motorista{id}")
	public String editar(@PathVariable Long id, Model model) {
		model.addAttribute("motorista", motoristaService.getMotorista(id));
		return "editar-motorista";
	}
	
	@RequestMapping("/salvar-edicao-motorista")
	public String salvarEdicao(@ModelAttribute Motorista motorista, Model model) {
		motoristaService.updateMotorista(motorista);
		Model addAttribute = model.addAttribute("motoristas", motoristaService.getAllMotoristas());
		return browser(addAttribute);
	}
	
	@RequestMapping("/deletar-motorista")
	public String deletarMotorista(@PathVariable Long id, Model model) {
		motoristaService.deleteOneMotorista(id);
		Model addAttribute = model.addAttribute("motoristas", motoristaService.getAllMotoristas());
		return browser(addAttribute);
	}
	
}
