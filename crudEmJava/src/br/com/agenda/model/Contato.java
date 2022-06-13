package br.com.agenda.model;

import java.util.Date;

public class Contato {
	
	private int id;
	private String nome;
	private int idade;
	private Date dataCadastro;
		
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
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public Date getDataDeCadastro() {
		return dataCadastro;
	}
	public void setDataDeCadastro(Date dataDeCadastro) {
		this.dataCadastro = dataDeCadastro;
	}
	
	

}
