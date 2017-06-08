package model;


import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import model.Usuario;


@Entity
public class Pessoa {
	
	
	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE)
	private int id;
	
	@Column(length = 60, nullable=false)
	private String nome;
	
	@Column(length=11, nullable=false, unique=true)
	private String cpf;
	
	@Column(length=60,nullable=false, unique=true)
	private String email;
	
	//@OneToOne
	//@JoinColumn(nullable=false)
	///private Usuario usuario;
	
	@Column(nullable=false)
	private LocalDate dataNascimento;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

/*
	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
*/

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}


	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

}
