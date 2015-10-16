package br.com.meufotosensor.negocio;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.meufotosensor.dao.OcorrenciaDAO;
import br.com.meufotosensor.entidades.Ocorrencia;
import br.com.meufotosensor.util.Transactional;

public class OcorrenciaService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private OcorrenciaDAO ocorrenciaDAO;
	
	@Transactional
	public void salvarOcorrencia(Ocorrencia ocorrencia) {
		ocorrenciaDAO.adicionar(ocorrencia);
	}
}
