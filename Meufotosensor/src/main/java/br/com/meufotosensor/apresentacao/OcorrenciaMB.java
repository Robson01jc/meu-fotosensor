package br.com.meufotosensor.apresentacao;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.util.Base64;

import br.com.meufotosensor.entidades.Bairro;
import br.com.meufotosensor.entidades.Ocorrencia;
import br.com.meufotosensor.negocio.BairroService;
import br.com.meufotosensor.negocio.OcorrenciaService;

@Named
@ViewScoped
public class OcorrenciaMB implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private OcorrenciaService ocorrenciaService;
	
	@Inject
	private BairroService bairroService;
	
	private Ocorrencia ocorrencia;
	
	public void prepararCadastro() {
		if (this.ocorrencia == null) {
			this.ocorrencia = new Ocorrencia();
		}
	}
		
	public void salvarOcorrencia() {
		salvarImagemOcorrencia(ocorrencia.getArquivoImagem());
		ocorrencia.setData(new Date());
		this.ocorrenciaService.salvarOcorrencia(ocorrencia);
	}
	
	public String salvarImagemOcorrencia(String imagemBase64) {
		
		String urlImagem = "";
		
		try {
			
			byte[] imagemByte = Base64.decode(imagemBase64.substring(22));
			InputStream input = new ByteArrayInputStream(imagemByte);
			urlImagem = ocorrenciaService.salvarArquivoImagem(input, "imagem");
			input.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return urlImagem;
		
	}
	
	public List<Bairro> getBairros() {
		return bairroService.getTodosBairros();
	}
	
	public Ocorrencia getOcorrencia() {
		return ocorrencia;
	}

	public void setOcorrencia(Ocorrencia ocorrencia) {
		this.ocorrencia = ocorrencia;
	}

}
