package br.com.meufotosensor.apresentacao;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
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
	
	private List<Atendente> atendentes;
	
	private Boolean mostrarCadastro = false;

	public void prepararCadastro() {
		if (this.atendente == null) {
			this.atendente = new Atendente();
		}
	}
	
	public void salvarAtendente() {
		FacesContext context = FacesContext.getCurrentInstance();
		
		try {
			atendenteService.salvarAtendente(this.atendente);
			
			this.atendente = new Atendente();
			FacesContext.getCurrentInstance().addMessage("successMessage",
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Atendente salvo com sucesso!", ""));
		} catch (Exception e) {
			FacesMessage mensagem = new FacesMessage(e.getMessage());
			mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, mensagem);
		}
		
	}
	
	public void editarAtendente() {
		FacesContext context = FacesContext.getCurrentInstance();
		
		try {
			atendenteService.salvarAtendente(this.atendente);
			
			this.atendente = new Atendente();
			FacesContext.getCurrentInstance().addMessage("successMessage",
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Atendente atualizado com sucesso!", ""));
		} catch (Exception e) {
			FacesMessage mensagem = new FacesMessage(e.getMessage());
			mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, mensagem);
		}
		
		mostraOcultaCadastro();
		
	}
	
	public void getTodosAtendentes() {
		this.atendentes = atendenteService.getTodosAtendentes();
	}
	
	public void preparaExcluir(Atendente atendente) {
		this.atendente = atendente;
	}
	
	public void excluirAtendente() {
		FacesContext context = FacesContext.getCurrentInstance();
				
			try {
				atendenteService.removerAtendente(this.atendente);
				getTodosAtendentes();
				
				context.addMessage(null, new FacesMessage("Atendente excluído com sucesso!"));
			} catch (Exception e) {
				FacesMessage mensagem = new FacesMessage(e.getMessage());
				mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
				context.addMessage(null, mensagem);
			}
		this.atendente = new Atendente();
	}
	
	public void mostraOcultaCadastro() {
		if(this.mostrarCadastro == false) { 
			this.mostrarCadastro = true;
		} else {
			this.mostrarCadastro = false;
		}
	}
	
	public Atendente getAtendente() {
		return atendente;
	}

	public void setAtendente(Atendente atendente) {
		this.atendente = atendente;
	}

	public List<Atendente> getAtendentes() {
		return atendentes;
	}

	public void setAtendentes(List<Atendente> atendentes) {
		this.atendentes = atendentes;
	}

	public Boolean getMostrarCadastro() {
		return mostrarCadastro;
	}

	public void setMostrarCadastro(Boolean mostrarCadastro) {
		this.mostrarCadastro = mostrarCadastro;
	}
	
}