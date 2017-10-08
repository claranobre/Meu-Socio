package com.meu.socio.meusocio;

import com.google.firebase.database.Exclude;

import DAO.CadastroDAO;

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
    }

    public void salvarDados() {
        CadastroDAO.getFirebase().child("usuarios").child(getId()).setValue( this);
    }

    public void setId(String id) {
        this.id = id;
    }

    @Exclude
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

    @Exclude
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

    @Exclude
    public String getSenha() {
        return this.senha;
    }
}
