package com.meu.socio.meusocio;

import android.content.Context;
import android.os.AsyncTask;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

/**
 * Created by Pedro Neto on 11/19/2017.
 */

public class RssReader extends AsyncTask<Void, Void, Void>{

    private Context context; // Contexto do FeedNoticiasActivity
    private String address; // Link do RSS
    private NoticiaAdapter adapter; // Adapter das noticias para poder atualizar o feed
    private ArrayList<Noticia> noticias; // Array que armazena as notícias
    URL url;



    /*
     *  Construtor recebendo o contexto e iniciando as coisas
     */
    public RssReader(Context context) {
        this.context = context;
        this.address = "http://www.americadenatal.com.br/noticias.rss";
        this.noticias = new ArrayList<>();
    }

    /*
     *  Método que roda quando a thread inicia
     */
    @Override
    protected Void doInBackground(Void... voids) {

        // Coleta os dados do RSS
        Document rssData = getData();

        processXml(rssData);

        return null;
    }

    /*
        Processa os dados do Document gerado
     */
    private void processXml(Document data) {
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
    }


    /*
        Quando todos os dados são processados, atualiza
        a tela usando o adapter passado do feedNoticias
     */
    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

        this.adapter.notifyDataSetChanged();

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

    /*
        Lê os dados do RSS e passa para um Document
     */
    private Document getData() {
        try {
            // Informa a url do RSS
            url = new URL(address);

            // Abre a conexão
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            InputStream inputStream = connection.getInputStream();

            // Cria o Document a partir do RSS
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document xmlDocument = builder.parse(inputStream);

            return xmlDocument;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public ArrayList<Noticia> getNoticias() {
        return noticias;
    }

    public void setAdapter(NoticiaAdapter adapter) {
        this.adapter = adapter;
    }
}
