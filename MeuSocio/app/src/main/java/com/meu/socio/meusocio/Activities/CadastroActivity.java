package com.meu.socio.meusocio.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.meu.socio.meusocio.CadastroHelper;
import com.meu.socio.meusocio.R;
import com.meu.socio.meusocio.Usuario;

import DAO.CadastroDAO;

public class CadastroActivity extends AppCompatActivity {
    private CadastroHelper helper;
    private CadastroDAO cadastro;


    private EditText campoId;
    private EditText campoNome;
    private EditText campoEmail;
    private EditText campoTelefone;
    private EditText campoUsuario;
    private EditText campoSenha;

    public CadastroActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        campoId = (EditText) findViewById(R.id.cadastro_id);
        campoNome = (EditText) findViewById(R.id.cadastro_nome);
        campoEmail = (EditText) findViewById(R.id.cadastro_email);
        campoTelefone = (EditText) findViewById(R.id.cadastro_telefone);
        campoUsuario = (EditText) findViewById(R.id.cadastro_usuario);
        campoSenha = (EditText) findViewById(R.id.cadastro_senha);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Button botaoCadastro = (Button) findViewById(R.id.cadastro_salvar);
//        Toast.makeText(CadastroActivity.this, "Cadastro " + usuario.getNome() + " feito com sucesso", Toast.LENGTH_SHORT).show();
//        botaoCadastro.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Usuario usuario = helper.dadosUsuario();
//                Toast.makeText(CadastroActivity.this, "Cadastro " + usuario.getNome() + " feito com sucesso", Toast.LENGTH_SHORT).show();
//                cadastro.cadastrarUsuario(usuario.getEmail(), usuario.getSenha());
//            }
//        });
        finish();

        return super.onOptionsItemSelected(item);
    }

    public void cadastro(View view) {
        Usuario usuario = new Usuario();
        usuario.setEmail(campoEmail.toString());
        usuario.setSenha(campoSenha.toString());
        Toast.makeText(CadastroActivity.this, "Cadastro " + usuario.getNome() + " feito com sucesso", Toast.LENGTH_SHORT).show();
        cadastro.cadastrarUsuario(usuario.getEmail(), usuario.getSenha());
    }








}
