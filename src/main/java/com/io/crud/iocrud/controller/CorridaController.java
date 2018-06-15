package com.io.crud.iocrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.io.crud.iocrud.model.Corrida;
import com.io.crud.iocrud.model.Motorista;
import com.io.crud.iocrud.model.Passageiro;
import com.io.crud.iocrud.service.CorridaService;
import com.io.crud.iocrud.service.MotoristaService;
import com.io.crud.iocrud.service.PassageiroService;

@Controller
public class CorridaController {
	
	private CorridaService corridaService;
	private MotoristaService motoristaService;
	private PassageiroService passageiroService;
	
	@Autowired
	public CorridaController(CorridaService corridaService, MotoristaService motoristaService, PassageiroService passageiroService) {
		this.corridaService = corridaService;
		this.motoristaService =  motoristaService;
		this.passageiroService = passageiroService;
	}
	
	@RequestMapping("/corrida")
	public String home(Model model) {
		model.addAttribute("corrida", new Corrida());
		
		model.addAttribute("motoristas", motoristaService.getAllMotoristas());
		model.addAttribute("passageiros", passageiroService.getAllPassageiros());
		return "corrida";
	}
	
	@RequestMapping("/inserir-corrida")
	public String insertCorrida(@ModelAttribute Corrida corrida, Model model, @ModelAttribute("motorista") Motorista motorista, @ModelAttribute("passageiro") Passageiro passageiro) {
		
		corrida.setIdMotorista(motorista.getId());
		corrida.setIdPassageiro(passageiro.getId());
		
		corridaService.insertCorrida(corrida);
		Model addAttribute = model.addAttribute("corridas", corridaService.getAllCorridas());
		return browser(addAttribute);
	}
	
	@RequestMapping("/browser-corrida")
	public String browser(Model model) {
		model.addAttribute("corridas", corridaService.getAllCorridas());
		return "browser-corrida";
	}
	
}
