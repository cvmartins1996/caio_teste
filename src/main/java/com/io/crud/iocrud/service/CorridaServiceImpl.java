package com.io.crud.iocrud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.io.crud.iocrud.model.Corrida;
import com.io.crud.iocrud.model.Motorista;
import com.io.crud.iocrud.repository.CorridaRepository;
@Service
public class CorridaServiceImpl implements CorridaService {
	
	@Autowired
	private CorridaRepository corridaRepository;
	
	
	@Override
	public void deleteCorrida(Corrida corrida) {
		corridaRepository.delete(corrida);
	}

	@Override
	public void deleteOneCorrida(Long id) {
		corridaRepository.deleteById(id);
	}

	@Override
	public Corrida updateCorrida(Corrida corrida) {
		verificaSeMotoristaEstaFerias(corrida);
		return corridaRepository.save(corrida);
	}

	@Override
	public Corrida insertCorrida(Corrida corrida) {
		verificaSeMotoristaEstaFerias(corrida);
		
		return corridaRepository.save(corrida);
	}

	private void verificaSeMotoristaEstaFerias(Corrida corrida) {
		Motorista motorista = new MotoristaServiceImpl().getMotorista(corrida.getIdMotorista());
		if (!motorista.isStatus()) {
			throw new IllegalArgumentException("Motorista está em periodo de ferias");
		}
	}

	@Override
	public Corrida getOneCorrida(Long id) {
		return corridaRepository.getOne(id);
	}

	@Override
	public List<Corrida> getAllCorridas() {
		return corridaRepository.findAll();
	}

}
