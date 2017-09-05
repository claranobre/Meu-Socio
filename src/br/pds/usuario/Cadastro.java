package br.pds.usuario;
import java.util.ArrayList;

public class Cadastro extends Usuario{

    private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    
    public void novoSocio(String login, String senha, String nome, String email, String endereco, String telefone){
        public boolean checker = true;
        for(int i = 0; i < usuarios.size(); i++){
            if(usuarios.get(i).getLogin().equals(login) || usuarios.get(i).getEmail().equals(email)){
                //Alterar para lançar uma exceção
                System.out.println("Login ou Email ja utilizado");
                checker = false;
            }
        }
        if(checker){
            Usuario cadastrar = new Usuario();
            int ru = usuarios.size();
            cadastrar.setUsuario(ru, login, senha, nome, email, endereco, telefone);
            usuarios.add(cadastrar);
        }
        else{
            System.out.println("Erro ao efetuar o cadastro");
        }
    }

    //Classe apenas para listar os usuarios, e seus respectivos dados acessíveis
    public void listarSocios(){
        for(int i = 0; i < usuarios.size(); i++){
            int ru = usuarios.get(i).getRu();
            String login = usuarios.get(i).getLogin();
            String nome = usuarios.get(i).getNome();
            String email = usuarios.get(i).getEmail();
            String endereco = usuarios.get(i).getEndereco();
            String telefone = usuarios.get(i).getTelefone();
            System.out.println("Registro Unico: " + ru + "Login: " + login + "Nome: " + nome + "Email: " + email + "Endereco: " + endereco + "Telefone: " + telefone);
        }
    }
}
