package com.io.crud.iocrud.service;

import java.util.List;

import com.io.crud.iocrud.model.Passageiro;

public interface PassageiroService {
	Passageiro insertPassageiro(Passageiro passageiro);
	Passageiro getPassageiro(Long id);
	Passageiro updatePassageiro(Passageiro passageiro);
	void deletePassageiro(Passageiro passageiro);
	void deleteOnePassageiro(Long id);
	List<Passageiro> getAllPassageiros();
}
