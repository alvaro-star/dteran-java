package br.edu.ifms.estudante.alvaro.detran.auth;

public class AuthResponse {
	private String cpf;
	private String accessToken;

	public AuthResponse() { }

	
	public AuthResponse(String cpf, String accessToken) {
		this.cpf = cpf;
		this.accessToken = accessToken;
	}


	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	

	

}
