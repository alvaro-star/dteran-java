package br.edu.ifms.estudante.alvaro.detran.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_infracao")
public class InfracaoModel implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idtb_infracao")
	private Integer id;
	@Column(nullable = false, length = 200)
	private String descricao;
	@Column(nullable = false)
	private double pontos;
	@Column(nullable = false)
	private double valor;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "infracao")
	private List<MultaModel> multas = new ArrayList<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public List<MultaModel> getMultas() {
		return multas;
	}

	public void setMultas(List<MultaModel> multas) {
		this.multas = multas;
		for(MultaModel multaModel : multas) {
			multaModel.setInfracao(this);
		}
	}
	
	
	
}
