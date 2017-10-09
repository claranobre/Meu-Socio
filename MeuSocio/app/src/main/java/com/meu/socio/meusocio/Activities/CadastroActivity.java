package com.meu.socio.meusocio.Activities;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.meu.socio.meusocio.R;
import com.meu.socio.meusocio.Usuario;

import DAO.CadastroDAO;

public class CadastroActivity extends AppCompatActivity {

//    private CadastroDAO cadastro;

    private FirebaseAuth auth;
    private Usuario usuario;

    private EditText campoId;
    private EditText campoNome;
    private EditText campoEmail;
    private EditText campoTelefone;
    private EditText campoUsuario;
    private EditText campoSenha;
    private Button botaoCadastro;

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
        botaoCadastro = (Button) findViewById(R.id.cadastro_salvar);

        botaoCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                usuario = new Usuario();
                usuario.setNome(campoNome.getText().toString());
                usuario.setEmail(campoEmail.getText().toString());
                usuario.setSenha(campoSenha.getText().toString());
                usuario.setTelefone(campoTelefone.getText().toString());
                cadastrarUsuario();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_feed_noticias_drawer, menu);
        return true;
    }

    private void cadastrarUsuario() {
        auth = CadastroDAO.getFirebaseAutenticador();
        auth.createUserWithEmailAndPassword(usuario.getEmail(), usuario.getSenha())
            .addOnCompleteListener(CadastroActivity.this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if( task.isSuccessful()) {
                        usuario.setId(task.getResult().getUser().getUid());
                        usuario.salvarDados();
                        Toast.makeText(CadastroActivity.this, "Usuário cadastrado com sucesso", Toast.LENGTH_LONG).show();
                        finish();
                    }
                    else {
                        FirebaseAuthException e = (FirebaseAuthException) task.getException();
                        Toast.makeText(CadastroActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                        Log.e("Cadastro", "Regristro falhou", e);
                    }
                }
        });
    }
}
