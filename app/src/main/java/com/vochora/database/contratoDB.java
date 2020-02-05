package com.vochora.database;

import android.provider.BaseColumns;

public final class contratoDB {

    public contratoDB() {
    }

    public static class alunoTabela implements BaseColumns {
        public static final String NomeTabela = "aluno";
        public static final String login = "alunoLogin";
        public static final String senha =  "alunoSenha";
    }

    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + alunoTabela.NomeTabela + " (" +
                    alunoTabela._ID + "INTEGER PRIMARY KEY," +
                    alunoTabela.login + "alunoLogin varchar(10) NOT NULL" +
                    alunoTabela.senha + "alunoSenha varchar(10) NOT NULL";

}
