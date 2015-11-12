package br.com.meufotosensor.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.meufotosensor.entidades.Bairro;

public class BairroDAO implements Serializable {
	
private static final long serialVersionUID = 1L;
	
	private EntityManager entityManager;

	@Inject
	public BairroDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public List<Bairro> getTodosBairros() {
		TypedQuery<Bairro> query = entityManager.createQuery(
				"from Bairro", Bairro.class);
		return query.getResultList();
	}
	
	public Bairro getBairroById(Long id) {
		return entityManager.find(Bairro.class, id);
	}
	
}
