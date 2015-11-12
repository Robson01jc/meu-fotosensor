package br.com.meufotosensor.negocio;

import java.io.File;
import java.io.InputStream;
import java.io.Serializable;

import javax.inject.Inject;

import br.com.meufotosensor.dao.OcorrenciaDAO;
import br.com.meufotosensor.entidades.Ocorrencia;
import br.com.meufotosensor.util.FileUtils;
import br.com.meufotosensor.util.Transactional;

public class OcorrenciaService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private OcorrenciaDAO ocorrenciaDAO;
	
	@Transactional
	public void salvarOcorrencia(Ocorrencia ocorrencia) {
		ocorrenciaDAO.adicionar(ocorrencia);
	}
	
	public String salvarArquivoImagem(InputStream input, String nomeArquivoImagem) {

		String arquivoImagemPath = "C:/Users/Robson/Java/MeuFotosensor/Arquivos/" + nomeArquivoImagem;
		try {
			File arquivo = new File(arquivoImagemPath);
			FileUtils.bcopy(input, arquivo, "semnome");
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return "http://localhost:8080/Meufotosensor/conteudo/" + nomeArquivoImagem ;

	}
	
}
