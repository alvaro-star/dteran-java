package br.edu.ifms.estudante.alvaro.detran.dtos;

import javax.validation.constraints.NotBlank;

public class InfracaoDto {
	
	@NotBlank
	private String descricao;
	private double pontos;
	private double valor;
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getPontos() {
		return pontos;
	}
	public void setPontos(double pontos) {
		this.pontos = pontos;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	

}
