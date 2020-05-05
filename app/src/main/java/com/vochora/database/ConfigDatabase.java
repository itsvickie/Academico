package com.vochora.database;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.vochora.aluno.Aluno;
import com.vochora.docente.Docente;

import java.util.Map;

public class ConfigDatabase {
    private static DatabaseReference database;
    private static FirebaseAuth auth;

    //Inicializa o Firebase
    public static DatabaseReference getFirebaseDatabase(){
        if (database == null){
            database = FirebaseDatabase.getInstance().getReference();
        }
        return database;
    }

    //Inicializa a Auth
    public static FirebaseAuth getFirebaseAuth(){
        if (auth == null){
            auth = FirebaseAuth.getInstance();
        }
        return auth;
    }

    public void insertUser(String child, String id, Map values){
        getFirebaseDatabase().child(child).child(id).setValue(values);
    }
}
