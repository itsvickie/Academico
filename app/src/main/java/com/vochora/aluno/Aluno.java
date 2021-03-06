package com.vochora.aluno;

import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;

public class Aluno {
    private String id;
    private String senha;
    private String matricula;
    private String nomeCompleto;
    private int CPF;
    private int RG;
    private String telefone;
    private String email;
    private String curso;
    private int periodo;
    private String turma;
    private String birthdate;
    private String endRua;
    private int endNumero;
    private String endEstado;
    private String endCidade;
    private String endBairro;
    private int endCEP;
    private String endComplemento;

    public Aluno() {
    }

    public Aluno(String id, String senha, String matricula, String nomeCompleto, int CPF, int RG, String telefone, String email, String curso, int periodo, String turma, String birthdate, String endRua, int endNumero, String endEstado, String endCidade, String endBairro, int endCEP, String endComplemento) {
        this.id = id;
        this.senha = senha;
        this.matricula = matricula;
        this.nomeCompleto = nomeCompleto;
        this.CPF = CPF;
        this.RG = RG;
        this.telefone = telefone;
        this.email = email;
        this.curso = curso;
        this.periodo = periodo;
        this.turma = turma;
        this.birthdate = birthdate;
        this.endRua = endRua;
        this.endNumero = endNumero;
        this.endEstado = endEstado;
        this.endCidade = endCidade;
        this.endBairro = endBairro;
        this.endCEP = endCEP;
        this.endComplemento = endComplemento;
    }

    @Exclude
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Exclude
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public int getCPF() {
        return CPF;
    }

    public void setCPF(int CPF) {
        this.CPF = CPF;
    }

    public int getRG() {
        return RG;
    }

    public void setRG(int RG) {
        this.RG = RG;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Exclude
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public int getPeríodo() {
        return periodo;
    }

    public void setPeríodo(int período) {
        this.periodo = período;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getEndRua() {
        return endRua;
    }

    public void setEndRua(String endRua) {
        this.endRua = endRua;
    }

    public int getEndNumero() {
        return endNumero;
    }

    public void setEndNumero(int endNumero) {
        this.endNumero = endNumero;
    }

    public String getEndEstado() {
        return endEstado;
    }

    public void setEndEstado(String endEstado) {
        this.endEstado = endEstado;
    }

    public String getEndCidade() {
        return endCidade;
    }

    public void setEndCidade(String endCidade) {
        this.endCidade = endCidade;
    }

    public String getEndBairro() {
        return endBairro;
    }

    public void setEndBairro(String endBairro) {
        this.endBairro = endBairro;
    }

    public int getEndCEP() {
        return endCEP;
    }

    public void setEndCEP(int endCEP) {
        this.endCEP = endCEP;
    }

    public String getEndComplemento() {
        return endComplemento;
    }

    public void setEndComplemento(String endComplemento) {
        this.endComplemento = endComplemento;
    }
}