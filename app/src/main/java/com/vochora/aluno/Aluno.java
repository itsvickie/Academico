package com.vochora.aluno;

public class Aluno {
    private String alunoNome;
    private String alunoCurso;
    private int alunoCPF;
    private String alunoTurma;
    private int alunoTelefone;
    private int alunoMatricula;
    private String alunoLogin;
    private String alunoSenha;

    public Aluno() {
    }

    public Aluno(String alunoNome, String alunoCurso, int alunoCPF, String alunoTurma, int alunoTelefone, int alunoMatricula, String alunoLogin, String alunoSenha) {
        this.alunoNome = alunoNome;
        this.alunoCurso = alunoCurso;
        this.alunoCPF = alunoCPF;
        this.alunoTurma = alunoTurma;
        this.alunoTelefone = alunoTelefone;
        this.alunoMatricula = alunoMatricula;
        this.alunoLogin = alunoLogin;
        this.alunoSenha = alunoSenha;
    }

    public String getAlunoNome() {
        return alunoNome;
    }

    public void setAlunoNome(String alunoNome) {
        this.alunoNome = alunoNome;
    }

    public String getAlunoCurso() {
        return alunoCurso;
    }

    public void setAlunoCurso(String alunoCurso) {
        this.alunoCurso = alunoCurso;
    }

    public int getAlunoCPF() {
        return alunoCPF;
    }

    public void setAlunoCPF(int alunoCPF) {
        this.alunoCPF = alunoCPF;
    }

    public String getAlunoTurma() {
        return alunoTurma;
    }

    public void setAlunoTurma(String alunoTurma) {
        this.alunoTurma = alunoTurma;
    }

    public int getAlunoTelefone() {
        return alunoTelefone;
    }

    public void setAlunoTelefone(int alunoTelefone) {
        this.alunoTelefone = alunoTelefone;
    }

    public int getAlunoMatricula() {
        return alunoMatricula;
    }

    public void setAlunoMatricula(int alunoMatricula) {
        this.alunoMatricula = alunoMatricula;
    }

    public String getAlunoLogin() {
        return alunoLogin;
    }

    public void setAlunoLogin(String alunoLogin) {
        this.alunoLogin = alunoLogin;
    }

    public String getAlunoSenha() {
        return alunoSenha;
    }

    public void setAlunoSenha(String alunoSenha) {
        this.alunoSenha = alunoSenha;
    }
}
