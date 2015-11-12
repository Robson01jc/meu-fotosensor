package br.com.meufotosensor.negocio;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.meufotosensor.dao.BairroDAO;
import br.com.meufotosensor.entidades.Bairro;
import br.com.meufotosensor.util.Transactional;

public class BairroService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private BairroDAO bairroDAO;
	
	
	@Transactional
	public List<Bairro> getTodosBairros() {
		return bairroDAO.getTodosBairros();
	}
	
	@Transactional
	public Bairro getBairroById(Long id) {
		return bairroDAO.getBairroById(id);
	}
	
}
