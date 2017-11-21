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
    private String data;
    private int id;

    public Noticia() {
        super();
        this.titulo = "Título da Notícia";
        this.texto = "[ Conteúdo do texto ]";
        this.data = "01/01/01";
        this.id = ++idCount;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = htmlToText(texto);
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    /*
        Método que tira todos os elementos HTML e retorna apenas uma string com o texto
     */
    public static String htmlToText(String html) {
        return android.text.Html.fromHtml(html).toString().replace('\n', (char) 32)
                .replace((char) 160, (char) 32).replace((char) 65532, (char) 32).trim();
    }
}
