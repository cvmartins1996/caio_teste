package com.io.crud.iocrud.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Corrida {
	
	@Id
	@GeneratedValue
	private Long id;
	private Long idPassageiro;
	private Long idMotorista;
	private float valor;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getIdPassageiro() {
		return idPassageiro;
	}
	public void setIdPassageiro(Long idPassageiro) {
		this.idPassageiro = idPassageiro;
	}
	public Long getIdMotorista() {
		return idMotorista;
	}
	public void setIdMotorista(Long idMotorista) {
		this.idMotorista = idMotorista;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	
}
