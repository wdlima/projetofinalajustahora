package br.com.projetofinalajustahora.beans;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="itmn232_atividade")


public class Atividade {
	@Id
	@Column(name="id_atividade")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_atividade;
	
	
	@Column(name="nome_atividade", length=100)
	private String nome_atividade;


	@JsonIgnoreProperties("id_atividade") 
	@OneToMany(mappedBy="id_atividade", cascade=CascadeType.ALL)
	private List<Ocorrencia> ocorrencias;

	
	public Atividade(int id_atividade, String nome_atividade, List<Ocorrencia> ocorrencias) {
		super();
		this.id_atividade = id_atividade;
		this.nome_atividade = nome_atividade;
		this.ocorrencias = ocorrencias;
	}


	public Atividade() {
		super();
	}


	public int getId_atividade() {
		return id_atividade;
	}


	public void setId_atividade(int id_atividade) {
		this.id_atividade = id_atividade;
	}


	public String getNome_atividade() {
		return nome_atividade;
	}


	public void setNome_atividade(String nome_atividade) {
		this.nome_atividade = nome_atividade;
	}


	public List<Ocorrencia> getOcorrencias() {
		return ocorrencias;
	}


	public void setOcorrencias(List<Ocorrencia> ocorrencias) {
		this.ocorrencias = ocorrencias;
	}
	
	
	
}

