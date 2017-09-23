package com.meu.socio.meusocio.Activities;


import java.util.ArrayList;

/**
 * Created by clara on 9/20/17.
 */

public class Cadastro extends Usuario{
    private static ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

    public static void addSocio(String login, String senha, String nome, String email, String endereco, String telefone){
        boolean checker = true;
        for(int i = 0; i < usuarios.size(); i++){
            if(usuarios.get(i).getLogin().equals(login) || usuarios.get(i).getEmail().equals(email)){
                //Alterar para lançar uma exceção
                System.out.println("Login ou Email ja utilizado");
                checker = false;
            }
        }
        if(checker){
            Usuario cadastrar = new Usuario();
            int ru = usuarios.size()+ 1;
            cadastrar.setUsuario(ru, login, senha, nome, email, endereco, telefone);
            usuarios.add(cadastrar);
        }
        else{
            System.out.println("Erro ao efetuar o cadastro_fragment");
        }
    }

    public void removeSocio(String login){

    }


    //Classe apenas para listar os usuarios, e seus respectivos dados acessíveis
    public static void listarSocios(){
        for(int i = 0; i < usuarios.size(); i++){
            imprimeDados(usuarios.get(i), i);
        }
    }

    //realiza a busca de um login no banco de socios
    public static Usuario buscarSocio(String login){
        boolean founded = false;
        Usuario user = new Usuario();
        for(int i = 0; i < usuarios.size(); i++){
            if(login.equals(usuarios.get(i).getLogin())){
                founded = true;
                user = usuarios.get(i);
                imprimeDados(usuarios.get(i), i);
            }
        }

        if(!founded){
            System.out.println("Usuario não encontrado!");
            return null;
        } else {
            return user;
        }
    }

    //lista dados do usuario
    public static void imprimeDados(Usuario user, int i){
        System.out.println("Registro Unico: " + usuarios.get(i).getRu() + "| Login: " +
                usuarios.get(i).getLogin() + "| Nome: " + usuarios.get(i).getNome() +
                "| Email: " + usuarios.get(i).getEmail() + "| Endereco: " +
                usuarios.get(i).getEndereco() + "| Telefone: " + usuarios.get(i).getTelefone());
    }
}