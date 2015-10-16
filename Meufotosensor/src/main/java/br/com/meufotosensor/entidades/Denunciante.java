package br.com.meufotosensor.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_denunciante")
public class Denunciante extends Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "nm_qtdocorrencias")
	private Integer qtdOcorrencias;

	public Integer getQtdOcorrencias() {
		return qtdOcorrencias;
	}

	public void setQtdOcorrencias(Integer qtdOcorrencias) {
		this.qtdOcorrencias = qtdOcorrencias;
	}
	
}
