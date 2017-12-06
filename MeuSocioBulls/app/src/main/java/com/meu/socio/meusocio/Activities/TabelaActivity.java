package com.meu.socio.meusocio.Activities;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.meu.socio.meusocio.Model.TimeTabela;
import com.meu.socio.meusocio.R;
import com.meu.socio.meusocio.Util.ShareOptions;
import com.meu.socio.meusocio.Util.ShareOptionsBulls;
import com.meu.socio.meusocio.Util.TabelaExtractor;
import com.meu.socio.meusocio.Util.TabelaJSonExtractor;

import java.util.Arrays;
import java.util.List;

import de.codecrafters.tableview.TableView;
import de.codecrafters.tableview.toolkit.SimpleTableDataAdapter;
import de.codecrafters.tableview.toolkit.SimpleTableHeaderAdapter;

public class TabelaActivity extends AppCompatActivity {

    TabelaExtractor tabela;
    static String[][] timess;
    static String[] headers={"Posição", "Time"};
    ShareOptions shareOptions;
    Button btShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabela);

        tabela = new TabelaJSonExtractor();
        drawTabela(tabela.getTabela());

        shareOptions = new ShareOptionsBulls();
        btShare = (Button) findViewById(R.id.btn_share);
        btShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(Intent.createChooser(shareOptions.shareIntent(), "Compartilhar usando"));
            }
        });

        final TableView<String[]> tableView = findViewById(R.id.tableview);
        //SET PROP
        tableView.setHeaderBackgroundColor(Color.parseColor("#b71c1c"));
        tableView.setHeaderAdapter(new SimpleTableHeaderAdapter(this,headers));
        tableView.setColumnCount(2);
        tableView.setHeaderElevation(10);
        tableView.setDataAdapter(new SimpleTableDataAdapter(this, timess));

    }

    private void drawTabela(String json) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();

        List<TimeTabela> times = Arrays.asList(gson.fromJson(json, TimeTabela[].class));

        timess = new String[times.size()][2];

        for(int i =0; i < times.size(); i++) {
            TimeTabela team = times.get(i);

            timess[i][0] = team.getPosicao();
            timess[i][1] = team.getNome();
        }

    }
}
