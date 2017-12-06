package com.meu.socio.meusocio.Model;

import android.content.Context;

import com.meu.socio.meusocio.NoticiaAdapter;
import com.meu.socio.meusocio.Util.RssExtractor;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;

/**
 * Created by Pedro Neto on 11/19/2017.
 */

public class Reader {

    private Context context; // Contexto do FeedNoticiasActivity
    private NoticiaAdapter adapter; // Adapter das noticias para poder atualizar o feed
    private ArrayList<Noticia> noticias; // Array que armazena as notícias
    private RssExtractor rssExtractor;



    /*
     *  Construtor recebendo o contexto e iniciando as coisas
     */
    public Reader(Context context) {
        this.context = context;
        this.noticias = new ArrayList<>();
        rssExtractor = new RssExtractor(this);
    }

    /*
     *  Método que executa a AsyncTask
     */
    public void executeExtractor() {
        rssExtractor.execute();
    }

    /*
        Processa os dados do Document gerado
     */
    public void processData(Document data) {
        if(data != null) {
            Element root = data.getDocumentElement();
            Node channel = root.getChildNodes().item(1);
            NodeList items = channel.getChildNodes();

            // Iterar por todas as notícias
            for (int i = 0; i < items.getLength(); i++) {
                // Cria a notícia
                Noticia noticia = new Noticia();

                Node currentChild = items.item(i);

                if(currentChild.getNodeName().equalsIgnoreCase("item")) {

                    NodeList itemChilds = currentChild.getChildNodes();

                    // Iterar por todos os nós internos da notícia
                    for(int j = 0; j < itemChilds.getLength(); j++) {
                        Node current = itemChilds.item(j);

                        // Chama contentFiller pra popular a Noticia
                        contentFiller(current, noticia);
                    }
                    noticias.add(noticia);
                }
            }
        }
        adapter.notifyDataSetChanged();
    }

    /*
        Armazena os dados na notícia
     */
    private void contentFiller(Node node, Noticia noticia) {
        if(node.getNodeName().equalsIgnoreCase("title")) {
            noticia.setTitulo(node.getTextContent());
        }
        else if(node.getNodeName().equalsIgnoreCase("description")) {
            noticia.setTexto(node.getTextContent());
        }
        else if(node.getNodeName().equalsIgnoreCase("pubDate")) {
            noticia.setData(node.getTextContent());
        }

    }

    public ArrayList<Noticia> getNoticias() {
        return noticias;
    }

    public void setAdapter(NoticiaAdapter adapter) {
        this.adapter = adapter;
    }
}
