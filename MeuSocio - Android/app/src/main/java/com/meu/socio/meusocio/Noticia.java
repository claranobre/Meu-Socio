package com.meu.socio.meusocio;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Pedro Neto on 9/5/2017.
 */

public class Noticia implements Serializable{

    public static final String NOTICIA_INFO = "NOTICIA_INFO";
    private static int idCount = 0;


    private String titulo;
    private String texto;
    private Date data;
    private int id;

    public Noticia() {
        super();
        this.titulo = "Título da Notícia";
        this.texto = "[ Conteúdo do texto ]";
        this.data = new Date();
        this.id = ++idCount;
    }


    public String getTitulo() {
        return titulo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }
}
