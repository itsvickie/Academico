package com.vochora.database;

import android.app.Activity;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.vochora.aluno.Aluno;
import com.vochora.docente.Docente;

import java.util.Map;

public class Database {
    private static FirebaseDatabase firebaseDatabase;
    private static DatabaseReference databaseReference;
    private static FirebaseAuth auth;

    public void inicializarDatabase(Activity activity){
        FirebaseApp.initializeApp(activity);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }

    public static FirebaseAuth getFirebaseAuth(){
        if (auth == null){
            auth = FirebaseAuth.getInstance();
        }
        return auth;
    }

    public void insertAluno(String child, String id, Aluno aluno){
        databaseReference.child(child).child(id).setValue(aluno);
    }

    public void insertDocente(String child, String id, Docente docente) {
        databaseReference.child(child).child(id).setValue(docente);
    }
}
