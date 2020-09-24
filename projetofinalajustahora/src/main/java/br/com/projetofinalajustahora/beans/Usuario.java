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
@Table(name="itmn232_usuario")
public class Usuario {
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)   
    @Column(name="id_usuario")
	    private int id_usuario;
   
    @Column(name="nome_usuario",length=100)
    private String nome_usuario;
   
    @Column(name="email_usuario",length=100)
    private String email_usuario;
   
    @Column(name="racf",length=7)
    private String racf;
   
    @Column(name="senha",length=50)
    private String senha;
   
    @Column(name="link_foto",length=255)
    private String link_foto;
   
    @Column(name="gestor")
    private int gestor;
	
    @OneToMany(mappedBy="id_usuario",cascade=CascadeType.ALL )
    @JsonIgnoreProperties("id_usuario")
	private List<Ocorrencia> ocorrencias;
    
    
	public Usuario(int id_usuario, String nome_usuario, String email_usuario, String racf, String senha,
			String link_foto, int gestor, List<Ocorrencia> ocorrencias) {
		super();
		this.id_usuario = id_usuario;
		this.nome_usuario = nome_usuario;
		this.email_usuario = email_usuario;
		this.racf = racf;
		this.senha = senha;
		this.link_foto = link_foto;
		this.gestor = gestor;
		this.ocorrencias = ocorrencias;
	}



	public Usuario() {
		super();
	}
	
	

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getNome_usuario() {
		return nome_usuario;
	}

	public void setNome_usuario(String nome_usuario) {
		this.nome_usuario = nome_usuario;
	}

	public String getEmail_usuario() {
		return email_usuario;
	}

	public void setEmail_usuario(String email_usuario) {
		this.email_usuario = email_usuario;
	}

	public String getRacf() {
		return racf;
	}

	public void setRacf(String racf) {
		this.racf = racf;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getLink_foto() {
		return link_foto;
	}

	public void setLink_foto(String link_foto) {
		this.link_foto = link_foto;
	}

	public int getGestor() {
		return gestor;
	}

	public void setGestor(int gestor) {
		this.gestor = gestor;
	}

	public List<Ocorrencia> getOcorrencias() {
		return ocorrencias;
	}

	public void setOcorrencias(List<Ocorrencia> ocorrencias) {
		this.ocorrencias = ocorrencias;
	}
    
    
	

}
