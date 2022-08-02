package br.edu.ifms.estudante.alvaro.detran.auth;

public class UserDTO {
	private Integer id;
	private String senha;

	public UserDTO() {
	}

	public UserDTO(Integer id, String senha) {
		this.id = id;
		this.senha = senha;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}



}
