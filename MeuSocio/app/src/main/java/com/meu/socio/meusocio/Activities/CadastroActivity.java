package com.meu.socio.meusocio.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.meu.socio.meusocio.CadastroHelper;
import com.meu.socio.meusocio.R;
import com.meu.socio.meusocio.Usuario;

public class CadastroActivity extends AppCompatActivity {
    private CadastroHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.cadastro_salvar:
                Usuario usuario = helper.dadosUsuario();
                Toast.makeText(CadastroActivity.this, "Cadastro " + usuario.getNome() + " feito com sucesso", Toast.LENGTH_SHORT).show();
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
