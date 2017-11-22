package com.meu.socio.meusocio.Activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.meu.socio.meusocio.R;

public class TabelaActivity extends AppCompatActivity {

    WebView tabelaWeb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabela);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tabelaWeb = (WebView) findViewById(R.id.tabela_web);
        tabelaWeb.loadUrl("http://globoesporte.globo.com/futebol/brasileirao-serie-d/#/classificacao-e-jogos");
        tabelaWeb.setWebViewClient(new WebViewClient());
        WebSettings webSettings = tabelaWeb.getSettings();
        webSettings.setJavaScriptEnabled(true);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
}
