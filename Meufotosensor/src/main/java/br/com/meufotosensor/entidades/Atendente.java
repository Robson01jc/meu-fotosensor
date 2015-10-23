package br.com.meufotosensor.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import br.com.meufotosensor.enums.TipoOcorrencia;

@Entity
@Table(name = "tb_atendente")
public class Atendente extends Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "ds_tipoocorrencia")
	private TipoOcorrencia tipoOcorrencia;
	
	@Column(name = "ds_ramal")
	private String ramal;

	public TipoOcorrencia getTipoOcorrencia() {
		return tipoOcorrencia;
	}

	public void setTipoOcorrencia(TipoOcorrencia tipoOcorrencia) {
		this.tipoOcorrencia = tipoOcorrencia;
	}

	public String getRamal() {
		return ramal;
	}

	public void setRamal(String ramal) {
		this.ramal = ramal;
	}
	
}
