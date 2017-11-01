package com.example.alunos.helperrealm5e;

import android.content.Context;

import com.example.alunos.helperrealm5e.Classes.Atirador;
import com.example.alunos.helperrealm5e.Classes.Barbaro;
import com.example.alunos.helperrealm5e.Classes.Bardo;
import com.example.alunos.helperrealm5e.Classes.Bruxo;
import com.example.alunos.helperrealm5e.Classes.Classe;
import com.example.alunos.helperrealm5e.Classes.Clerigo;
import com.example.alunos.helperrealm5e.Classes.Druida;
import com.example.alunos.helperrealm5e.Classes.Guerreiro;
import com.example.alunos.helperrealm5e.Classes.Ladino;
import com.example.alunos.helperrealm5e.Classes.Mago;
import com.example.alunos.helperrealm5e.Classes.Paladino;
import com.example.alunos.helperrealm5e.Racas.Anao;
import com.example.alunos.helperrealm5e.Racas.Elfo;
import com.example.alunos.helperrealm5e.Racas.Halfling;
import com.example.alunos.helperrealm5e.Racas.Humano;
import com.example.alunos.helperrealm5e.Racas.Raca;
import java.util.Random;

/**
 * Created by alunos on 18/10/17.
 */

public class Personagem {

    protected Classe classe;
    protected Raca raca;
    protected int forca;
    protected int destreza;
    protected int constituicao;
    protected int inteligencia;
    protected int sabedoria;
    protected int carisma;
    protected String nome;
    protected int vida;
    protected String racaNome;
    protected String classeNome;
    protected int lvl;

    public Personagem(int forca, int destreza, int constituicao, int inteligencia, int sabedoria, int carisma, String nome, String crasse, String race){

        if(crasse == "Atirador")
            this.classe = new Atirador();
        else if(crasse == "Bárbaro")
            this.classe = new Barbaro();
        else if(crasse == "Bardo")
            this.classe = new Bardo();
        else if(crasse == "Bruxo")
            this.classe = new Bruxo();
        else if(crasse == "Clérigo")
            this.classe = new Clerigo();
        else if(crasse == "Druida")
            this.classe = new Druida();
        else if(crasse == "Guerreiro")
            this.classe = new Guerreiro();
        else if(crasse == "Ladino")
            this.classe = new Ladino();
        else if(crasse == "Mago")
            this.classe = new Mago();
        else if(crasse == "Paladino")
            this.classe = new Paladino();

        if(race == "Anão")
            this.raca = new Anao();
        else if(race == "Elfo")
            this.raca = new Elfo();
        else if(race == "Halfling")
            this.raca = new Halfling();
        else if(race == "Humano")
            this.raca = new Humano();

        this.forca = forca + raca.getForca();
        this.destreza = destreza + raca.getDestreza();
        this.constituicao = constituicao + raca.getConstituicao();
        this.inteligencia = inteligencia + raca.getInteligencia();
        this.sabedoria = sabedoria + raca.getSabedoria();
        this.carisma = carisma + raca.getCarisma();
        this.nome = nome;
        this.vida = classe.getDadoVida() + this.constituicao;
        this.racaNome = raca.getNome();
        this.classeNome = classe.getNome();
        this.lvl = 1;
    }

    public boolean lvlUp(){
        if(this.lvl != 20) {
            this.lvl++;
            if (this.lvl % 2 == 0) {
                this.constituicao++;
                this.vida++;
            }
            Random rand = new Random();
            int dado = 0;
            while (dado == 0)
                dado = rand.nextInt(classe.getDadoVida());
            this.vida += dado;

            int mod = 0;
            int mod2 = 0;

            if (this.lvl >= 1 && this.lvl <= 4)
                mod = 2;
            else if (this.lvl >= 5 && this.lvl <= 8)
                mod = 3;
            else if (this.lvl >= 9 && this.lvl <= 12)
                mod = 4;
            else if (this.lvl >= 13 && this.lvl <= 16)
                mod = 5;
            else if (this.lvl >= 17 && this.lvl <= 20)
                mod = 6;

            if(classe.getPrimaria2() != "") {
                mod /= 2;
                mod2 = mod;
            }
            if (classe.getPrimaria() == "Forca")
                    this.forca += mod;
            if (classe.getPrimaria2() == "Forca")
                this.forca += mod2;
            if (classe.getPrimaria() == "Destreza")
                this.destreza += mod;
            if (classe.getPrimaria2() == "Destreza")
                this.destreza += mod2;
            if (classe.getPrimaria() == "Constituicao")
                this.constituicao += mod;
            if (classe.getPrimaria2() == "Constituicao")
                this.constituicao += mod2;
            if (classe.getPrimaria() == "Inteligencia")
                this.inteligencia += mod;
            if (classe.getPrimaria2() == "Inteligencia")
                this.inteligencia += mod2;
            if (classe.getPrimaria() == "Sabedoria")
                this.sabedoria += mod;
            if (classe.getPrimaria2() == "Sabedoria")
                this.sabedoria += mod2;
            if (classe.getPrimaria() == "Carisma")
                this.carisma += mod;
            if (classe.getPrimaria2() == "Carisma")
                this.carisma += mod2;
            return true;
        }
        return false;
    }
}
