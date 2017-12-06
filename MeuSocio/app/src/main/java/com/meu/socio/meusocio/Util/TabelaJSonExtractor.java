package com.meu.socio.meusocio.Util;

/**
 * Created by Pedro Neto on 11/27/2017.
 */

public class TabelaJSonExtractor implements TabelaExtractor {

    private String JSon;

    public TabelaJSonExtractor() {
        JSon = "[{\"posicao\":\"1\",\"nome\":\"America\"},{\"posicao\":\"2\",\"nome\":\"ABC\"}]";
    }

    @Override
    public String getTabela() {
        return this.JSon;
    }
}
