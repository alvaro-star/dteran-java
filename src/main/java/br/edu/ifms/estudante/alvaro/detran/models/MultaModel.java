package br.edu.ifms.estudante.alvaro.detran.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name = "tb_multa")
public class MultaModel implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idtb_multa")
	private Integer id;
	@Column(nullable = false)
	private String cidade;
	@Column(nullable = false)
	private int ano;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "id_carro")
	@JsonProperty(access = Access.WRITE_ONLY)
	private CarroModel carro;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "id_infracao")
	@JsonProperty(access = Access.WRITE_ONLY)
	private InfracaoModel infracao;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public CarroModel getCarro() {
		return carro;
	}

	public void setCarro(CarroModel carro) {
		this.carro = carro;
	}

	public InfracaoModel getInfracao() {
		return infracao;
	}

	public void setInfracao(InfracaoModel infracao) {
		this.infracao = infracao;
	}
	
	
	
}
