package com.vochora.api;

import android.widget.EditText;

import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;
import com.vochora.aluno.Aluno;

public class Mascaras {

    public void formatacaoDados(String formato, EditText campo){
        SimpleMaskFormatter formatoMask = new SimpleMaskFormatter(formato);
        MaskTextWatcher dadoFormatado = new MaskTextWatcher(campo, formatoMask);
        campo.addTextChangedListener(dadoFormatado);
    }

    public EditText formatarTelefone(EditText telefone){
        formatacaoDados("(NN) NNNNN-NNNN", telefone);
        return telefone;
    }

    public EditText formatarCPF(EditText cpf){
        formatacaoDados("NNN.NNN.NNN-NN", cpf);
        return cpf;
    }

    public EditText formatarData(EditText data){
        formatacaoDados("NN/NN/NNNN", data);
        return data;
    }
}