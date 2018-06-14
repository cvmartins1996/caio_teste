package com.io.crud.iocrud.service;

import java.util.List;

import com.io.crud.iocrud.model.Motorista;

public interface MotoristaService {
	
	Motorista insertMotorista(Motorista motorista);
	Motorista getMotorista(Long id);
	Motorista updateMotorista(Motorista motorista);
	void deleteMotorista(Motorista motorista);
	void deleteOneMotorista(Long id);
	List<Motorista> getAllMotoristas();
	
}
