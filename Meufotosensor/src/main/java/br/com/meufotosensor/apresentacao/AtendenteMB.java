package br.com.meufotosensor.apresentacao;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.meufotosensor.entidades.Atendente;
import br.com.meufotosensor.negocio.AtendenteService;

@Named
@ViewScoped
public class AtendenteMB implements Serializable {

	private static final long serialVersionUID = 1L;
	 
	@Inject
	private AtendenteService atendenteService;
	
	private Atendente atendente;

	public void prepararCadastro() {
		if (this.atendente == null) {
			this.atendente = new Atendente();
		}
	}
	
	public void salvarAtendente() {
		atendenteService.salvarAtendente(this.atendente);
	}
	
	public Atendente getAtendente() {
		return atendente;
	}

	public void setAtendente(Atendente atendente) {
		this.atendente = atendente;
	}
	
}
