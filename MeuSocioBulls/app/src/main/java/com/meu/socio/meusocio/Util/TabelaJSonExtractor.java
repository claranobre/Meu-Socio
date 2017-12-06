package com.meu.socio.meusocio.Util;

/**
 * Created by Pedro Neto on 11/27/2017.
 */

public class    TabelaJSonExtractor implements TabelaExtractor {

    private String JSon;

    public TabelaJSonExtractor() {
        JSon = "[{\"posicao\":\"1\",\"nome\":\"Bulls\"},{\"posicao\":\"2\",\"nome\":\"Akron Zips\"}" +
                ",{\"posicao\":\"3\",\"nome\":\"Western Michigan\"},{\"posicao\":\"4\",\"nome\":\"Nothern Illinois\"}]";
    }

    @Override
    public String getTabela() {
        return this.JSon;
    }
}
