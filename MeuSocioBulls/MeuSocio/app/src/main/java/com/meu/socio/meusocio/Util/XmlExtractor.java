package com.meu.socio.meusocio.Util;

import android.os.AsyncTask;

import com.meu.socio.meusocio.Model.Reader;

import org.w3c.dom.Document;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

/**
 * Created by Clara Nobre on 04/12/2017.
 */

public class XmlExtractor extends AsyncTask<Void, Void, Document> implements DataExtractor {
    Reader reader;
    URL url;
    String address = "http://www.nba.com/bulls/rss.xml";

    public RssExtractor(Reader obj) {
        reader = obj;
    }

    @Override
    public Document getData() {
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

    @Override
    protected Document doInBackground(Void[] voids) {
        Document document = this.getData();
        return document;

    }

    @Override
    protected void onPostExecute(Document document) {
        reader.processData(document);
        super.onPostExecute(document);

    }
}
