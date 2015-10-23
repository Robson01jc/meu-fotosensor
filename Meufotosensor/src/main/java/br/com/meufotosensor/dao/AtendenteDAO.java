package br.com.meufotosensor.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

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

	public List<Atendente> getTodosAtendentes() {
		TypedQuery<Atendente> query = entityManager.createQuery(
				"from Atendente", Atendente.class);
		return query.getResultList();
	}
	
	public Atendente getAtendenteById(Long id) {
		return entityManager.find(Atendente.class, id);
	}
	
	public void removerAtendente(Atendente atendente) {
		entityManager.remove(entityManager.contains(atendente) ? atendente : entityManager.merge(atendente));
	}

}
