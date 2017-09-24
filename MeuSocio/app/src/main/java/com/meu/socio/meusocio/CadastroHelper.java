package com.meu.socio.meusocio;

import android.widget.EditText;
import com.meu.socio.meusocio.Activities.CadastroActivity;


/**
 * Created by Gil on 9/24/2017.
 */

public class CadastroHelper {
    private final EditText campoId;
    private final EditText campoNome;
    private final EditText campoEmail;
    private final EditText campoTelefone;
    private final EditText campoUsuario;
    private final EditText campoSenha;


    public CadastroHelper(CadastroActivity activity){
        campoId = (EditText) activity.findViewById(R.id.cadastro_id);
        campoNome = (EditText) activity.findViewById(R.id.cadastro_nome);
        campoEmail = (EditText) activity.findViewById(R.id.cadastro_email);
        campoTelefone = (EditText) activity.findViewById(R.id.cadastro_telefone);
        campoUsuario = (EditText) activity.findViewById(R.id.cadastro_usuario);
        campoSenha = (EditText) activity.findViewById(R.id.cadastro_senha);

    }

    public Usuario dadosUsuario(){
        Usuario usuario = new Usuario();
        usuario.setId(campoId.getText().toString());
        usuario.setNome(campoNome.getText().toString());
        usuario.setEmail(campoEmail.getText().toString());
        usuario.setTelefone(campoTelefone.getText().toString());
        usuario.setLogin(campoUsuario.getText().toString());
        usuario.setSenha(campoSenha.getText().toString());
        return usuario;
    }
}
