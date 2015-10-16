package br.com.meufotosensor.negocio;

import java.io.Serializable;

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
}
