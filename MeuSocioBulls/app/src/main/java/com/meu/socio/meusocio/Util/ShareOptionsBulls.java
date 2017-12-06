package com.meu.socio.meusocio.Util;

import android.content.Intent;
import android.net.Uri;

import com.meu.socio.meusocio.R;

/**
 * Created by Pedro Neto on 12/6/2017.
 */

public class ShareOptionsBulls implements ShareOptions {

    @Override
    public Intent shareIntent() {
        Intent shareIntent = new Intent();
        shareIntent.setAction(Intent.ACTION_SEND);
        shareIntent.setType("image/png");
        Uri uri = Uri.parse("android.resource://com.meu.socio.meusocio/"+R.drawable.gamebulls);
        shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
        shareIntent.putExtra(Intent.EXTRA_TEXT, "GO BULLS!");

        return shareIntent;
    }
}
