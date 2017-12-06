package com.meu.socio.meusocio.Util;

/**
 * Created by Pedro Neto on 11/27/2017.
 */

public class TabelaJSonExtractor implements TabelaExtractor {

    private String JSon;

    public TabelaJSonExtractor() {
        JSon = "[{\"posicao\":\"1\",\"nome\":\"Sada Cruzeiro\"},{\"posicao\":\"2\",\"nome\":\"SESC-RJ\"}" +
                ",{\"posicao\":\"3\",\"nome\":\"SESI-SP\"},{\"posicao\":\"4\",\"nome\":\"Minas Tenis Club\"}]";
    }

    @Override
    public String getTabela() {
        return this.JSon;
    }
}
