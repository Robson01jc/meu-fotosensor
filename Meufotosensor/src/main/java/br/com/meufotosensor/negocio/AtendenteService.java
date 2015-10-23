package br.com.meufotosensor.negocio;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.meufotosensor.dao.AtendenteDAO;
import br.com.meufotosensor.entidades.Atendente;
import br.com.meufotosensor.util.Transactional;

public class AtendenteService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private AtendenteDAO atendenteDAO;
	
	@Transactional
	public void salvarAtendente(Atendente atendente) {
		atendenteDAO.adicionar(atendente);
	}
	
	@Transactional
	public List<Atendente> getTodosAtendentes() {
		return atendenteDAO.getTodosAtendentes();
	}
	
	@Transactional
	public Atendente getAtendenteById(Long id) {
		return atendenteDAO.getAtendenteById(id);
	}
	
	@Transactional
	public void removerAtendente(Atendente atendente) {
		atendenteDAO.removerAtendente(atendente);
	}
}
