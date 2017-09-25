package DAO;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Pedro Neto on 9/24/2017.
 */

public class CadastroDAO {

    private DatabaseReference referenciaFirebase;
    private FirebaseAuth autenticador;

    private DatabaseReference getFirebase() {
        if(referenciaFirebase == null) {
            referenciaFirebase = FirebaseDatabase.getInstance().getReference();
        }

        return referenciaFirebase;
    }

    private FirebaseAuth getFirebaseAutenticador() {
        if( autenticador == null) {
            autenticador = FirebaseAuth.getInstance();
        }

        return autenticador;
    }

    public void cadastrarUsuario(String email, String senha) {
        this.autenticador.createUserWithEmailAndPassword(email, senha);
    }

}
