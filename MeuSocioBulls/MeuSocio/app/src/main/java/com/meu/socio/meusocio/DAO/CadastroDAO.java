package com.meu.socio.meusocio.DAO;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Pedro Neto on 9/24/2017.
 */

public class CadastroDAO {

    private static DatabaseReference referenciaFirebase;
    private static FirebaseAuth autenticador;

    public CadastroDAO() {
    }

    public static DatabaseReference getFirebase() {
        if(referenciaFirebase == null) {
            referenciaFirebase = FirebaseDatabase.getInstance().getReference();
        }

        return referenciaFirebase;
    }

    public static FirebaseAuth getFirebaseAutenticador() {
        if( autenticador == null) {
            autenticador = FirebaseAuth.getInstance();
        }

        return autenticador;
    }

}
