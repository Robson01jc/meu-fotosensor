package br.com.meufotosensor.enums;

public enum TipoOcorrencia {
	ACIDENTE("Acidente"), INFRACAO("Infracao");

	private String desc;
	private String role;

	private TipoOcorrencia(String desc) {
		this.desc = desc;
		this.role = "ROLE_" + this.name();
	}

	public String getDesc() {
		return desc;
	}

	public String getRole() {
		return role;
	}
}
