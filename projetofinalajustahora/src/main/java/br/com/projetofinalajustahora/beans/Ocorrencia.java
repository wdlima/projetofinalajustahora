package br.com.projetofinalajustahora.beans;


import java.sql.Time;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="itmn232_ocorrencia")
public class Ocorrencia {
	
	@Id
	@Column(name="num_seq")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int num_seq;
	
	//private int id_usuario; => falata receber nome.
	
	//private int id_atividade;
	
	
	@Column(name="descricao", length=100)
	private String descricao;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
	@Column(name="data_oc")
	@Temporal(TemporalType.DATE)
	private Date data_oc;
	
	
	@Column(name="num_horas")	
	private Time num_horas;
	
	@Column(name="ponto_manual")
	private int ponto_manual;
	
	@Column(name="status")
	private int status;
	
	@ManyToOne
	@JsonIgnoreProperties("ocorrencias")
	private Usuario id_usuario;
	
	@ManyToOne
	@JsonIgnoreProperties("ocorrencias")
	private Atividade id_atividade;
	
	

	public Ocorrencia(int num_seq, String descricao, Date data_oc, Time num_horas, int ponto_manual, int status,
			Usuario id_usuario, Atividade id_atividade) {
		super();
		this.num_seq = num_seq;
		this.descricao = descricao;
		this.data_oc = data_oc;
		this.num_horas = num_horas;
		this.ponto_manual = ponto_manual;
		this.status = status;
		this.id_usuario = id_usuario;
		this.id_atividade = id_atividade;
	}

	public Ocorrencia() {
		super();
	}

	public int getNum_seq() {
		return num_seq;
	}

	public void setNum_seq(int num_seq) {
		this.num_seq = num_seq;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getData_oc() {
		return data_oc;
	}

	public void setData_oc(Date data_oc) {
		this.data_oc = data_oc;
	}

	public Time getNum_horas() {
		return num_horas;
	}

	public void setNum_horas(Time num_horas) {
		this.num_horas = num_horas;
	}

	public int getPonto_manual() {
		return ponto_manual;
	}

	public void setPonto_manual(int ponto_manual) {
		this.ponto_manual = ponto_manual;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Usuario getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Usuario id_usuario) {
		this.id_usuario = id_usuario;
	}

	public Atividade getId_atividade() {
		return id_atividade;
	}

	public void setId_atividade(Atividade id_atividade) {
		this.id_atividade = id_atividade;
	}
	
	
	
}
