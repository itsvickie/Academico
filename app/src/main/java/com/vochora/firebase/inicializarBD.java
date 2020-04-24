package com.vochora.firebase;

import android.app.Activity;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.vochora.aluno.Aluno;
import com.vochora.docente.Docente;

public class inicializarBD {
    public FirebaseDatabase firebaseDatabase;
    public DatabaseReference databaseReference;

    public void inicializarDatabase(Activity activity){
        FirebaseApp.initializeApp(activity);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }

    public void insertAluno(String child, String id, Aluno aluno){
        databaseReference.child(child).child(id).setValue(aluno);
    }

    public void insertProfessor(String child, String id, Docente docente){
        databaseReference.child(child).child(id).setValue(docente);
    }

}
