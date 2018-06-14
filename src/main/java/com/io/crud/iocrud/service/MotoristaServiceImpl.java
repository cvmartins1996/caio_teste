package com.io.crud.iocrud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.io.crud.iocrud.model.Motorista;
import com.io.crud.iocrud.repository.MotoristaRepository;
@Service
public class MotoristaServiceImpl implements MotoristaService{
	
	
	@Autowired
	private MotoristaRepository motoristaRepository;

	@Override
	public Motorista insertMotorista(Motorista motorista) {
		
		return motoristaRepository.save(motorista);
	}

	@Override
	public Motorista getMotorista(Long id) {
		return motoristaRepository.getOne(id);
	}

	@Override
	public Motorista updateMotorista(Motorista motorista) {
		return motoristaRepository.save(motorista);
	}

	@Override
	public void deleteMotorista(Motorista motorista) {
		motoristaRepository.delete(motorista);
	}
	
	@Override
	public void deleteOneMotorista(Long id) {
		motoristaRepository.deleteById(id);
	}


	@Override
	public List<Motorista> getAllMotoristas() {
		return motoristaRepository.findAll();
	}
	
	
	
	
}
