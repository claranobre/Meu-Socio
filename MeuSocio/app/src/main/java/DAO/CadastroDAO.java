package DAO;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.concurrent.Executor;

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
