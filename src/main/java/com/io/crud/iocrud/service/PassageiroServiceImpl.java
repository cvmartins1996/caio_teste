package com.io.crud.iocrud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.io.crud.iocrud.model.Passageiro;
import com.io.crud.iocrud.repository.PassageiroRepository;

@Service
public class PassageiroServiceImpl implements PassageiroService{
	
	@Autowired
	private PassageiroRepository passageiroRepository;
	
	public Passageiro insertPassageiro(Passageiro passageiro) {
		return passageiroRepository.save(passageiro);
	}

	@Override
	public Passageiro getPassageiro(Long id) {
		return passageiroRepository.getOne(id);
	}

	@Override
	public Passageiro updatePassageiro(Passageiro passageiro) {
		return passageiroRepository.save(passageiro);
	}

	@Override
	public void deletePassageiro(Passageiro passageiro) {
		passageiroRepository.delete(passageiro);
	}

	@Override
	public void deleteOnePassageiro(Long id) {
		passageiroRepository.deleteById(id);
	}

	@Override
	public List<Passageiro> getAllPassageiros() {
		return passageiroRepository.findAll();
	}

}
