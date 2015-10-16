package br.com.meufotosensor.dao;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.meufotosensor.entidades.Ocorrencia;

public class OcorrenciaDAO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private EntityManager entityManager;

	@Inject
	public OcorrenciaDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public void adicionar(Ocorrencia ocorrencia) { 
		entityManager.persist(ocorrencia); 
	} 
	
}
