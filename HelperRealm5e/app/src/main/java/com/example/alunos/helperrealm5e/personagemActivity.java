package com.example.alunos.helperrealm5e;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import java.util.StringTokenizer;

public class personagemActivity extends AppCompatActivity {

    String codigo;
    BancoController crud;
    TextView forca;
    TextView destreza;
    TextView constituicao;
    TextView sabedoria;
    TextView inteligencia;
    TextView carisma;
    TextView nome;
    TextView classe;
    TextView raca;
    TextView level;
    TextView vida;
    Cursor cursor;
    int forca1 = 0;
    int destreza1 = 0;
    int constituicao1 = 0;
    int sabedoria1 = 0;
    int inteligencia1 = 0;
    int carisma1 = 0;
    String classe1;
    String nome1;
    String raca1;
    int lvl = 0;
    int vida1 = 0;
    Personagem personagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personagem);
        codigo = this.getIntent().getStringExtra("codigo");
        
        crud = new BancoController(getBaseContext());
        this.atualizar();
        personagem = new Personagem(forca1, destreza1, constituicao1, inteligencia1, sabedoria1, carisma1, nome1, classe1, raca1);
    }

    public void atualizar(){
        forca = (TextView) findViewById(R.id.editForca);
        destreza = (TextView) findViewById(R.id.editDestreza);
        constituicao = (TextView) findViewById(R.id.editConstituicao);
        sabedoria = (TextView) findViewById(R.id.editSabedoria);
        inteligencia = (TextView) findViewById(R.id.editInteligencia);
        carisma = (TextView) findViewById(R.id.editCarisma);
        nome = (TextView) findViewById(R.id.textNome);
        classe = (TextView) findViewById(R.id.textClasse);
        raca = (TextView) findViewById(R.id.textRaca);
        level = (TextView) findViewById(R.id.textLvl);
        vida = (TextView) findViewById(R.id.textVida);

        cursor = crud.carregaDadosById(Integer.parseInt(codigo));

        forca.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.FORCA)));
        forca1 = Integer.parseInt(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.FORCA)));

        destreza.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.DESTREZA)));
        destreza1 = Integer.parseInt(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.DESTREZA)));

        constituicao.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.CONSTITUICAO)));
        constituicao1 = Integer.parseInt(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.CONSTITUICAO)));

        sabedoria.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.SABEDORIA)));
        sabedoria1 = Integer.parseInt(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.SABEDORIA)));

        inteligencia.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.INTELIGENCIA)));
        inteligencia1 = Integer.parseInt(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.INTELIGENCIA)));

        carisma.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.CARISMA)));
        carisma1 = Integer.parseInt(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.CARISMA)));

        nome.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.NOME)));
        nome1 = cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.NOME));

        classe.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.CLASSE)));
        classe1 = cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.CLASSE));

        raca.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.RACA)));
        raca1 = cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.RACA));

        level.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.LEVEL)));
        lvl = Integer.parseInt(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.LEVEL)));

        vida.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.VIDA)));
        vida1 = Integer.parseInt(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.VIDA)));
    }

    public void d2(View v) {
        Random rand = new Random();
        int dado = 0;
        while(dado == 0)
            dado = rand.nextInt(3);
        this.show(dado);
    }

    public void d4(View v) {
        Random rand = new Random();
        int dado = 0;
        while(dado == 0)
            dado = rand.nextInt(5);
        this.show(dado);
    }

    public void d6(View v) {
        Random rand = new Random();
        int dado = 0;
        while(dado == 0)
            dado = rand.nextInt(7);
        this.show(dado);
    }

    public void d8(View v) {
        Random rand = new Random();
        int dado = 0;
        while(dado == 0)
            dado = rand.nextInt(9);
        this.show(dado);
    }

    public void d10(View v) {
        Random rand = new Random();
        int dado = 0;
        while(dado == 0)
            dado = rand.nextInt(11);
        this.show(dado);
    }

    public void d12(View v) {
        Random rand = new Random();
        int dado = 0;
        while(dado == 0)
            dado = rand.nextInt(13);
        this.show(dado);
    }

    public void d20(View v) {
        Random rand = new Random();
        int dado = 0;
        while(dado == 0)
            dado = rand.nextInt(21);
        this.show(dado);
    }

    public void show(int dadinho){
        TextView dado = (TextView) findViewById(R.id.dadoResult);
        dado.setText(Integer.toString(dadinho));
    }

    public void lvlUp(View v){
            if(this.lvl != 20) {
                this.lvl++;
                if (this.lvl % 2 == 0) {
                    if(this.constituicao1 < 20)
                        this.constituicao1++;
                    this.vida1++;
                }
                Random rand = new Random();
                int dado = 0;
                int x = personagem.classe.getDadoVida();
                dado = rand.nextInt(++x);
                this.vida1 += dado;

                if (this.lvl % 3 == 0) {
                    
                    if(this.forca1 < 20)
                        this.forca1++;
                    if(this.destreza1 < 20)
                        this.destreza1++;
                    if(this.sabedoria1 < 20)
                        this.sabedoria1++;
                    if(this.inteligencia1 < 20)
                        this.inteligencia1++;
                    if(this.carisma1 < 20)
                        this.carisma1++;
                    
                    int mod = 0;
                    int mod2 = 0;

                    if (this.lvl >= 1 && this.lvl <= 4)
                        mod = 1;
                    else if (this.lvl >= 5 && this.lvl <= 8)
                        mod = 2;
                    else if (this.lvl >= 9 && this.lvl <= 12)
                        mod = 3;
                    else if (this.lvl >= 13 && this.lvl <= 16)
                        mod = 4;
                    else if (this.lvl >= 17 && this.lvl <= 20)
                        mod = 5;

                    if (personagem.classe.getPrimaria2() != "") {
                        mod /= 2;
                        mod2 = mod;
                    }

                    if (personagem.classe.getPrimaria().equals("Forca") && this.forca1 < 20)
                        this.forca1 += mod;
                    if (personagem.classe.getPrimaria2().equals("Forca") && this.forca1 < 20)
                        this.forca1 += mod2;
                    if (personagem.classe.getPrimaria().equals("Destreza") && this.destreza1 < 20)
                        this.destreza1 += mod;
                    if (personagem.classe.getPrimaria2().equals("Destreza") && this.destreza1 < 20)
                        this.destreza1 += mod2;
                    if (personagem.classe.getPrimaria().equals("Constituicao") && this.constituicao1 < 20)
                        this.constituicao1 += mod;
                    if (personagem.classe.getPrimaria2().equals("Constituicao") && this.constituicao1 < 20)
                        this.constituicao1 += mod2;
                    if (personagem.classe.getPrimaria().equals("Inteligencia") && this.inteligencia1 < 20)
                        this.inteligencia1 += mod;
                    if (personagem.classe.getPrimaria2().equals("Inteligencia") && this.inteligencia1 < 20)
                        this.inteligencia1 += mod2;
                    if (personagem.classe.getPrimaria().equals("Sabedoria") && this.sabedoria1 < 20)
                        this.sabedoria1 += mod;
                    if (personagem.classe.getPrimaria2().equals("Sabedoria") && this.sabedoria1 < 20)
                        this.sabedoria1 += mod2;
                    if (personagem.classe.getPrimaria().equals("Carisma") && this.carisma1 < 20)
                        this.carisma1 += mod;
                    if (personagem.classe.getPrimaria2().equals("Carisma") && this.carisma1 < 20)
                        this.carisma1 += mod2;
                }
            }
            this.bd();
            this.atualizar();
    }

    public void bd(){
        crud.alteraRegistro(Integer.parseInt(codigo), forca1, destreza1, constituicao1, sabedoria1, inteligencia1, carisma1, nome1, classe1, raca1, lvl, vida1);
        Toast.makeText(getApplicationContext(), "LEVEL UP", Toast.LENGTH_LONG).show();
    }
}
