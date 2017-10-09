package com.meu.socio.meusocio.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.meu.socio.meusocio.Noticia;
import com.meu.socio.meusocio.NoticiaAdapter;
import com.meu.socio.meusocio.R;

import java.util.ArrayList;

public class FeedNoticiasActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private NoticiaAdapter adaptadorLista;
    ArrayList<Noticia> noticias = new ArrayList<Noticia>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_noticias);


        //Navigation Drawer part

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);



        //Feed part

        ListView lista = (ListView) findViewById(R.id.listaNoticias);

        adaptadorLista = new NoticiaAdapter(this, noticias);

        lista.setAdapter(adaptadorLista);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapter, View view,
                                    int position, long id) {

                Noticia noticiaSelecionada = noticias.get(position);

                Intent acao = new Intent(FeedNoticiasActivity.this,
                        NoticiaDetalheActivity.class);

                acao.putExtra(Noticia.NOTICIA_INFO, noticiaSelecionada);

                startActivity(acao);

            }
        });


        // Temporário enquanto não tem notícias de verdade
        for(int i = 0; i < 10; i++) {
            noticias.add(new Noticia());
        }

        adaptadorLista.notifyDataSetChanged();


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.feed_noticias, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void escolheTela(int id) {
        android.support.v4.app.Fragment fragment = null;

        switch (id) {
            case R.id.loginID:
//                fragment = new LoginFragment();
                Intent intentLogin = new Intent(FeedNoticiasActivity.this,
                        LoginActivity.class);
                startActivity(intentLogin);
                break;
            case R.id.cadastroID:
//                fragment = new CadastroFragment();
                Intent intentCadastro = new Intent(FeedNoticiasActivity.this,
                        CadastroActivity.class);
                startActivity(intentCadastro);
                break;
            case R.id.parceirosID:
//                fragment = new CadastroFragment();
                Intent intentParceiro = new Intent(FeedNoticiasActivity.this,
                        ParceirosActivity.class);
                startActivity(intentParceiro);
                break;
        }

        if(fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_feed_noticias, fragment, "Fragmento");
            ft.commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        escolheTela(id);

        return true;
    }
}
