package com.meu.socio.meusocio.Util;

import android.content.Intent;

/**
 * Created by Pedro Neto on 12/6/2017.
 */

public class ShareOptionsAmerica implements ShareOptions {

    public String getTitleContent() {
        return "Tabela";
    }

    public String getBodyContent() {
        return "Tabela série F: 1- America, 2- ABC";
    }

    @Override
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
