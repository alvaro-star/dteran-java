package br.edu.ifms.estudante.alvaro.detran.dtos;

import javax.validation.constraints.NotBlank;

public class CarroDto {
	@NotBlank
	private String nome;
	@NotBlank
	private String placa;
	private Integer idUsuario;
	

	
	public Integer getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	
}
