package com.meu.socio.meusocio.Activities;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.meu.socio.meusocio.R;

import java.util.zip.Inflater;

/**
 * Created by Pedro Neto on 9/23/2017.
 */

public class LoginFragment extends android.support.v4.app.Fragment {

    private View view;

    @Nullable
    @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.login, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getActivity().setTitle("Login");
    }
}
