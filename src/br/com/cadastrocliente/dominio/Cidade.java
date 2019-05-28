package br.com.cadastrocliente.dominio;

public class Cidade {

	private int id;
	private String nome;
	private int estado;
	
	
	//CONSTRUTOR
	public Cidade() {
	}

	//CONSTRUTOR QUE SERÁ USADO NA LISTA 
	public Cidade(int id, String nome, int estado) {
		this.id = id;
		this.nome = nome;
		this.estado = estado;
	}

	//GETTERS AND SETTERS
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

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}
	
	
	
}
