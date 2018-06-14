package com.io.crud.iocrud.service;

import java.util.List;

import com.io.crud.iocrud.model.Corrida;

public interface CorridaService {
	
	void deleteCorrida(Corrida corrida);
	void deleteOneCorrida(Long id);
	Corrida updateCorrida(Corrida corrida);
	Corrida insertCorrida(Corrida corrida);
	Corrida getOneCorrida(Long id);
	List<Corrida> getAllCorridas();
	
}
