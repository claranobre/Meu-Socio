package br.pds.usuario;

public class Usuario {
	private int ru;
	private String login;
	private String senha;
	private String nome;
	private String email;
	private String endereco;
	private String telefone;
	
	public void setUsuario(int ru, String login, String senha, String nome, String email, String endereco, String telefone){
		this.ru = ru;
		this.login = login;
		this.senha = senha;
		this.nome = nome;
		this.email = email;
		this.endereco = endereco;
		this.telefone = telefone;
	}
	public void setRu(int ru) {
		this.ru = ru;
	}
	
	public int getRu() {
		return this.ru;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getLogin() {
		return this.login;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getSenha() {
		return this.senha;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return this.nome;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEndereco() {
		return this.endereco;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getTelefone() {
		return this.telefone;
	}

}
