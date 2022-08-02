package br.edu.ifms.estudante.alvaro.detran.auth;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class AuthRequest {
	@NotNull
	@Length(min = 5, max = 50)
	private String cpf;

	@NotNull
	@Length(min = 5, max = 10)
	private String senha;

	public AuthRequest() {

	}

	public AuthRequest(String cpf, String senha) {
		this.cpf = cpf;
		this.senha = senha;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}



}
