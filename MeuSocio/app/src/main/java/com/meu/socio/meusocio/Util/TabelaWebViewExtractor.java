package com.meu.socio.meusocio.Util;

import com.meu.socio.meusocio.Util.TabelaExtractor;

/**
 * Created by Pedro Neto on 11/27/2017.
 */

public class TabelaWebViewExtractor implements TabelaExtractor {

    private String link;

    public TabelaWebViewExtractor() {
        link = "https://www.cbf.com.br/competicoes/brasileiro-serie-d/equipes/2017?c=20030#.WhTfYkqnFPZ";
    }

    @Override
    public String getTabela() {
        return this.link;
    }
}
