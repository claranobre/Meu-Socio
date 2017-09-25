package com.meu.socio.meusocio;

/**
 * Created by clara on 9/20/17.
 */

public class Usuario {
    private String id;
    private String nome;
    private String email;
    private String telefone;
    private String login;
    private String senha;

    public Usuario() {
        id = "null";
        nome = "null";
        email = "null";
        telefone = "null";
        login = "null";
        senha = "null";
    }

    public void setUsuario(){
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
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

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTelefone() {
        return this.telefone;
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
}
