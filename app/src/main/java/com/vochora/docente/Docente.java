package com.vochora.docente;

public class Docente {
    private String docenteNome;
    private int docenteCPF;
    private int docenteTelefone;
    private String docenteCargo;

    public Docente() {
    }

    public Docente(String docenteNome, int docenteCPF, int docenteTelefone, String docenteCargo) {
        this.docenteNome = docenteNome;
        this.docenteCPF = docenteCPF;
        this.docenteTelefone = docenteTelefone;
        this.docenteCargo = docenteCargo;
    }

    public String getDocenteNome() {
        return docenteNome;
    }

    public void setDocenteNome(String docenteNome) {
        this.docenteNome = docenteNome;
    }

    public int getDocenteCPF() {
        return docenteCPF;
    }

    public void setDocenteCPF(int docenteCPF) {
        this.docenteCPF = docenteCPF;
    }

    public int getDocenteTelefone() {
        return docenteTelefone;
    }

    public void setDocenteTelefone(int docenteTelefone) {
        this.docenteTelefone = docenteTelefone;
    }

    public String getDocenteCargo() {
        return docenteCargo;
    }

    public void setDocenteCargo(String docenteCargo) {
        this.docenteCargo = docenteCargo;
    }
}
