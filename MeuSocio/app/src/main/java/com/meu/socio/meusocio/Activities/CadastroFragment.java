package com.meu.socio.meusocio.Activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.meu.socio.meusocio.R;

/**
 * Created by Pedro Neto on 9/23/2017.
 */

public class CadastroFragment extends android.support.v4.app.Fragment {

//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, @Nullable Bundle savedInstanceState) {
////        return inflater.inflate(R.layout.cadastro_fragment, container, false);
//    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getActivity().setTitle("Cadastro");
    }
}
