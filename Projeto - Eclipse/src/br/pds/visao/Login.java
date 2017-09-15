package br.pds.visao;

import java.awt.event.ActionListener; 
import java.awt.event.ActionEvent; 
import javax.swing.text.*;
import javax.swing.*;

import utilitarios.ConexaoBD;

import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login extends JFrame {

    int controla;
    ResultSet rs;

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Login thisClass = new Login();
                thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                thisClass.setVisible(true);
                thisClass.setTitle("Tela de Login");
                thisClass.setSize(289, 195);
            }
        });
    }

    public Login() {
        super("Login");
    initialize();
    }


    private void initialize() {
        this.setSize(290, 180);
        this.setTitle("Login");
        this.setVisible(true);
        Container tela = getContentPane();
        tela.setLayout(null);
        this.setContentPane(tela);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        // LABELS
        JLabel titulolbl = new JLabel("Forneça Login e senha");
        tela.add(titulolbl);
        titulolbl.setBounds(10, 5, 200, 20);

        JLabel loginlbl = new JLabel("Login: ");
        tela.add(loginlbl);
        loginlbl.setBounds(10, 35, 60, 20);

        JLabel senhalbl = new JLabel("Senha: ");
        tela.add(senhalbl);
        senhalbl.setBounds(10, 60, 60, 20);

        // TEXTFIELDS
        final JTextField loginTxt = new JTextField(6);
        tela.add(loginTxt);
        loginTxt.setBounds(75, 35, 90, 20);


        final JTextField senhaTxt = new JPasswordField(6);
        tela.add(senhaTxt);
        senhaTxt.setBounds(75, 60, 90, 20);


        // BOTÕES
        JButton okbtn = new JButton("OK");
        tela.add(okbtn);
        okbtn.setBounds(30, 95, 80, 30);
        okbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {


        //EVENTO QUE FAZ O CONTROLE DE LOGIN
                String senha = new String(((JPasswordField) senhaTxt).getPassword());

             if (loginTxt.getText().equals("") || senhaTxt.getText().equals(""))// se login e senha em branco
                 JOptionPane.showMessageDialog(null,"Campos login e senha são obrigatórios");//mensagem

             else //senao
             {

               try
               {

                String sql = "select * from usuario where user_nome like '"
                + loginTxt.getText()+"' and user_senha like '"+ senha +"'";
                rs= ConexaoBD.getConexao().executeQuery(sql);// exexuta a varialvel sql acima


                   if(rs.first())// conecta e busca o primeiro registro igual e compara se for certo entra senao da erro no CATCH
                   {
                    JOptionPane.showMessageDialog(null,"Login Efetuado com Sucesso!");
                     controla = rs.getInt("TIPO_ACESSO"); 


                       if (controla==1) // TIPO DE ACESSO DO ADMINISTRADOR
                       {
                       new T_PRINCIPAL().setVisible(true);// chama o formulario principal ao conectar

                       T_PRINCIPAL.mnpesquisa.setVisible(false); //esconde os menus do professor
                       T_PRINCIPAL.mnrelatorio.setEnabled(false) ;

                       //   principal.menu_avaliacao.setVisible(false);
                     dispose();// fecha o formulario de login ao entrar no principal
                       }


                       else if (controla==2) // TIPO DE ACESSO DE PROFESSORES
                         { 
                             new T_PRINCIPAL().setVisible(true);// chama o formulario principal ao conectar

                             T_PRINCIPAL.mnpesquisa.setVisible(true); 
                             dispose();// fecha o formulario de login ao entrar no principal

                       } 
                   }
                   else{
                        JOptionPane.showMessageDialog(null, "Dados incoretos.");
                        loginTxt.requestFocus();
                       }

                       }

                       catch (SQLException erro)
                       {
                 JOptionPane.showMessageDialog(null, "Problemas de conexão com a base de dados");

               }
                 }
             }
                 });


        JButton cancelarbtn = new JButton("Cancelar");
        tela.add(cancelarbtn);
        cancelarbtn.setBounds(130, 95, 90, 30);
        cancelarbtn.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                dispose(); 
                } 
                }); 




    }
}