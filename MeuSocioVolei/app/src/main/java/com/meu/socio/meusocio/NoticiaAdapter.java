package com.meu.socio.meusocio;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.meu.socio.meusocio.Model.Noticia;

import java.util.ArrayList;

/**
 * Created by Pedro Neto on 9/5/2017.
 */

public class NoticiaAdapter extends ArrayAdapter<Noticia> {

    private final Context context;
    ArrayList<Noticia> noticias = new ArrayList<Noticia>();

    public NoticiaAdapter(Context context, ArrayList<Noticia> noticias) {
        super(context, R.layout.noticia_layout, noticias);
        this.context = context;
        this.noticias = noticias;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);


        View rowView = inflater.inflate(R.layout.noticia_layout, parent, false);

        TextView textAutor = rowView.findViewById(R.id.titulo);
        TextView textConteudo = rowView.findViewById(R.id.texto);


        Noticia noticia = noticias.get(position);

        textAutor.setText(noticia.getTitulo());
        textConteudo.setText(noticia.getTexto());

        return rowView;
    }

}
