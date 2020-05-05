package com.vochora.docente;

import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;

public class Docente {
    private String id;
    private String senha;
    private String matricula;
    private String nomeCompleto;
    private int CPF;
    private int RG;
    private String telefone;
    private String email;
    private String birthdate;
    private String endRua;
    private int endNumero;
    private String endEstado;
    private String endCidade;
    private String endBairro;
    private int endCEP;
    private String endComplemento;
    private float salario;

    public Docente() {
    }

    public Docente(String id, String senha, String matricula, String nomeCompleto, int CPF, int RG, String telefone, String email, String birthdate, String endRua, int endNumero, String endEstado, String endCidade, String endBairro, int endCEP, String endComplemento, float salario) {
        this.id = id;
        this.senha = senha;
        this.matricula = matricula;
        this.nomeCompleto = nomeCompleto;
        this.CPF = CPF;
        this.RG = RG;
        this.telefone = telefone;
        this.email = email;
        this.birthdate = birthdate;
        this.endRua = endRua;
        this.endNumero = endNumero;
        this.endEstado = endEstado;
        this.endCidade = endCidade;
        this.endBairro = endBairro;
        this.endCEP = endCEP;
        this.endComplemento = endComplemento;
        this.salario = salario;
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

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }
}
