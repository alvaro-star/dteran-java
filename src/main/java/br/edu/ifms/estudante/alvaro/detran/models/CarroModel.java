package br.edu.ifms.estudante.alvaro.detran.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import br.edu.ifms.estudante.alvaro.detran.configs.DetailUserData;

@Entity
@Table(name = "tb_carro")
public class CarroModel implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idtb_carro")
	private Integer id;
	@Column(nullable = false)
	private String nome;
	@Column(nullable = false)
	private String placa;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "id_usuario")
	@JsonProperty(access = Access.WRITE_ONLY)
	private DetailUserData usuario;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "carro")
	private List<MultaModel> multas = new ArrayList<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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



	public DetailUserData getUsuario() {
		return usuario;
	}

	public void setUsuario(DetailUserData usuario) {
		this.usuario = usuario;
	}

	public List<MultaModel> getMultas() {
		return multas;
	}

	public void setMultas(List<MultaModel> multas) {
		this.multas = multas;
		for(MultaModel multaModel : multas) {
			multaModel.setCarro(this);
		}
	}
	
}
