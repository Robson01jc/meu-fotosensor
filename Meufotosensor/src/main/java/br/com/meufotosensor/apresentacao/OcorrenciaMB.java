package br.com.meufotosensor.apresentacao;

import java.io.Serializable;
import java.util.Date;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.meufotosensor.entidades.Ocorrencia;
import br.com.meufotosensor.negocio.OcorrenciaService;

@Named
@ViewScoped
public class OcorrenciaMB implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private OcorrenciaService ocorrenciaService;
	
	private Ocorrencia ocorrencia;

	public void prepararCadastro() {
		if (this.ocorrencia == null) {
			this.ocorrencia = new Ocorrencia();
		}
	}
		
	public void salvarOcorrencia() {
		ocorrencia.setData(new Date());
		this.ocorrenciaService.salvarOcorrencia(ocorrencia);
	}
	
	public Ocorrencia getOcorrencia() {
		return ocorrencia;
	}

	public void setOcorrencia(Ocorrencia ocorrencia) {
		this.ocorrencia = ocorrencia;
	}
	
}
