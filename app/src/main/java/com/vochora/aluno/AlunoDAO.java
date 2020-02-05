package com.vochora.aluno;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.vochora.database.conexaoDB;

public class AlunoDAO {
    private conexaoDB conexao;
    private SQLiteDatabase bd;

    public AlunoDAO(Context context){
        conexao = new conexaoDB(context);
        bd = conexao.getWritableDatabase();
    }

    public long inserir(Aluno aluno){
        ContentValues values = new ContentValues();
        values.put("alunoLogin", aluno.getAlunoLogin());
        values.put("alunoSenha", aluno.getAlunoSenha());
        return bd.insert("aluno", null, values);
    }
}
