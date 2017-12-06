package com.meu.socio.meusocio.Util;

import android.content.Intent;

import com.meu.socio.meusocio.Activities.TabelaActivity;

/**
 * Created by Pedro Neto on 12/6/2017.
 */

public class ShareOptionsVolei implements ShareOptions {


    public String getTitleContent() {
        return "Tabela";
    }

    public String getBodyContent() {
        return "Acompanhe todos os momentos do vôlei brasileiro em: http://2017.cbv.com.br/";
    }

    public Intent shareIntent() {
        Intent myIntent = new Intent(Intent.ACTION_SEND);
        myIntent.setType("text/plain");
        String shareTitle = getTitleContent();
        String shareBody = getBodyContent();

        myIntent.putExtra(Intent.EXTRA_SUBJECT, shareTitle);
        myIntent.putExtra(Intent.EXTRA_TEXT, shareBody);

        return myIntent;
    }
}
