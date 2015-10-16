package br.com.meufotosensor.dao;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.meufotosensor.entidades.Atendente;

public class AtendenteDAO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private EntityManager entityManager;

	@Inject
	public AtendenteDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public void adicionar(Atendente atendente) { 
		entityManager.merge(atendente); 
	} 
	
}
