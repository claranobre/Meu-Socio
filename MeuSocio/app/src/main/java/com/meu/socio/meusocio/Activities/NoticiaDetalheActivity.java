package com.meu.socio.meusocio.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.meu.socio.meusocio.Noticia;
import com.meu.socio.meusocio.R;

/**
 * Created by Pedro Neto on 9/5/2017.
 */

public class NoticiaDetalheActivity extends Activity {

    private Noticia noticia;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.noticia_detalhe);

        TextView textAutor = (TextView) findViewById(R.id.tituloDetalhe);
        TextView textConteudo = (TextView) findViewById(R.id.texto);
        TextView textData = (TextView) findViewById(R.id.postagemDetalhe);

        Intent intent = getIntent();

        noticia = (Noticia) intent.getSerializableExtra(Noticia.NOTICIA_INFO);

        textAutor.setText(noticia.getTitulo());
        textConteudo.setText(noticia.getTexto());
        textData.setText(noticia.getData().toGMTString());

    }

    public void voltar(View v) {

        finish();
    }
}
