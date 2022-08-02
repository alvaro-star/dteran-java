package br.edu.ifms.estudante.alvaro.detran.dtos;

import javax.validation.constraints.NotBlank;

public class UsuarioDto {

	@NotBlank
	private String nome;
	@NotBlank
	private String senha;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
}
