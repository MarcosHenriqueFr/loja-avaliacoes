package com.example.model;

public class Avaliacao {

	private int id;
	private String mensagem;
	private Usuario usuario;
	
	public Avaliacao() {}
	
	public Avaliacao(String mensagem, Usuario usuario) {
		this.mensagem = mensagem;
		this.usuario = usuario;
	}
	
	public Avaliacao(int id, String mensagem, Usuario usuario) {
		this.id = id;
		this.mensagem = mensagem;
		this.usuario = usuario;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
