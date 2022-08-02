package br.edu.ifms.estudante.alvaro.detran.dtos;

import javax.validation.constraints.NotBlank;

public class MultaDto {

	@NotBlank
	private String cidade;
	private int ano;
	private Integer idCarro;
	private Integer idInfracao;
	
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public int getIdCarro() {
		return idCarro;
	}
	public void setIdCarro(int idCarro) {
		this.idCarro = idCarro;
	}
	public int getIdInfracao() {
		return idInfracao;
	}
	public void setIdInfracao(int idInfracao) {
		this.idInfracao = idInfracao;
	}
	
	
	
}
