package com.example.alunos.helperrealm5e.Classes;

public class Classe {

    protected String nome;
    protected int dadoVida;
    protected String primaria;

    public String getPrimaria() {
        return primaria;
    }

    public void setPrimaria(String primaria) {
        this.primaria = primaria;
    }

    public String getPrimaria2() {
        return primaria2;
    }

    public void setPrimaria2(String primaria2) {
        this.primaria2 = primaria2;
    }

    protected String primaria2;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDadoVida(int dadoVida) {
        this.dadoVida = dadoVida;
    }

    public String getNome() {
        return this.nome;
    }

    public int getDadoVida() {
        return this.dadoVida;
    }
}
