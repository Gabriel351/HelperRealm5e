package com.example.alunos.helperrealm5e.Racas;

public class Raca {

    protected int forca = 0;
    protected int destreza = 0;
    protected int constituicao = 0;
    protected int inteligencia = 0;
    protected int sabedoria = 0;
    protected int carisma = 0;
    protected String nome;

    public void setForca(int forca) {
        this.forca = forca;
    }

    public void setDestreza(int destreza) {
        this.destreza = destreza;
    }

    public void setConstituicao(int constituicao) {
        this.constituicao = constituicao;
    }

    public void setInteligencia(int inteligencia) {
        this.inteligencia = inteligencia;
    }

    public void setSabedoria(int sabedoria) {
        this.sabedoria = sabedoria;
    }

    public void setCarisma(int carisma) {
        this.carisma = carisma;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getForca() {
        return this.forca;
    }

    public int getDestreza() {
        return this.destreza;
    }

    public int getConstituicao() {
        return this.constituicao;
    }

    public int getInteligencia() {
        return this.inteligencia;
    }

    public int getSabedoria() {
        return this.sabedoria;
    }

    public int getCarisma() {
        return this.carisma;
    }

    public String getNome() {
        return this.nome;
    }
}
