package com.example.alunos.helperrealm5e;

import android.content.Context;
import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class CriaActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cria);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);

        List<String> list = new ArrayList<String>();
        list.add("Atirador");
        list.add("Bárbaro");
        list.add("Bardo");
        list.add("Bruxo");
        list.add("Clérigo");
        list.add("Druida");
        list.add("Guerreiro");
        list.add("Ladino");
        list.add("Mago");
        list.add("Paladino");
        ArrayAdapter<String> myadapter = new ArrayAdapter<String>(this,
            android.R.layout.simple_spinner_item, list);
        myadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(myadapter);
        spinner.setSelection(0);

        List<String> lista = new ArrayList<String>();
        lista.add("Anão");
        lista.add("Elfo");
        lista.add("Halfling");
        lista.add("Humano");
        ArrayAdapter<String> dataadapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, lista);
        dataadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(dataadapter);
        spinner2.setSelection(0);
    }

    public void criar(View v){

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);

        TextView nome = (TextView) findViewById(R.id.nome);
        String nomePers = nome.getText().toString();
        TextView forca = (TextView) findViewById(R.id.editForca);
        int forcaPers = Integer.valueOf(forca.getText().toString());
        TextView constituicao = (TextView) findViewById(R.id.editConstituicao);
        int constPers = Integer.valueOf(constituicao.getText().toString());
        TextView sabedoria = (TextView) findViewById(R.id.editSabedoria);
        int sabedPers = Integer.valueOf(sabedoria.getText().toString());
        TextView inteligencia = (TextView) findViewById(R.id.editInteligencia);
        int intelPers = Integer.valueOf(inteligencia.getText().toString());
        TextView destreza = (TextView) findViewById(R.id.editDestreza);
        int destPers = Integer.valueOf(destreza.getText().toString());
        TextView carisma = (TextView) findViewById(R.id.editCarisma);
        int carismPers = Integer.valueOf(carisma.getText().toString());
        int raca = spinner2.getSelectedItemPosition();
        int classe = spinner.getSelectedItemPosition();
        String race;
        String crasse;
        if(raca == 0)
            race = "Anão";
        else if(raca == 1)
            race = "Elfo";
        else if(raca == 2)
            race = "Halfling";
        else
            race = "Humano";

        if(classe == 0)
            crasse = "Atirador";
        else if(classe == 1)
            crasse = "Bárbaro";
        else if(classe == 2)
            crasse = "Bardo";
        else if(classe == 3)
            crasse = "Bruxo";
        else if(classe == 4)
            crasse = "Clérigo";
        else if(classe == 5)
            crasse = "Druida";
        else if(classe == 6)
            crasse = "Guerreiro";
        else if(classe == 7)
            crasse = "Ladino";
        else if(classe == 8)
            crasse = "Mago";
        else
            crasse = "Paladino";
        Personagem novo = new Personagem(forcaPers, destPers, constPers, intelPers, sabedPers, carismPers, nomePers, crasse, race);
        BancoController crud = new BancoController(getBaseContext());
        String resultado = crud.insereDados(novo.forca, novo.destreza, novo.constituicao, novo.inteligencia, novo.sabedoria, novo.carisma, novo.nome, novo.classeNome, novo.racaNome, novo.lvl, novo.vida);
        Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
    }



    public void maisForca(View v){
        TextView view = (TextView) findViewById(R.id.editForca);
        TextView total = (TextView) findViewById(R.id.totalPontos);
        int valor = Integer.valueOf(view.getText().toString());
        int pontos = Integer.valueOf(total.getText().toString());
        if(valor < 20 && pontos > 0) {
            valor++;
            pontos--;
            view.setText(Integer.toString(valor));
            total.setText(Integer.toString(pontos));
        }
        else{
            Context contexto = getApplicationContext();
            String texto = "Valor máximo";
            int duracao = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(contexto, texto,duracao);
            toast.show();
        }
    }

    public void menosForca(View v){
        TextView view = (TextView) findViewById(R.id.editForca);
        TextView total = (TextView) findViewById(R.id.totalPontos);
        int valor = Integer.valueOf(view.getText().toString());
        int pontos = Integer.valueOf(total.getText().toString());
        if(valor > 3) {
            valor--;
            pontos++;
            view.setText(Integer.toString(valor));
            total.setText(Integer.toString(pontos));
        }
        else{
            Context contexto = getApplicationContext();
            String texto = "Valor mínimo";
            int duracao = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(contexto, texto,duracao);
            toast.show();
        }
    }

    public void maisDestreza(View v){
        TextView view = (TextView) findViewById(R.id.editDestreza);
        TextView total = (TextView) findViewById(R.id.totalPontos);
        int valor = Integer.valueOf(view.getText().toString());
        int pontos = Integer.valueOf(total.getText().toString());
        if(valor < 20 && pontos > 0) {
            valor++;
            pontos--;
            view.setText(Integer.toString(valor));
            total.setText(Integer.toString(pontos));
        }
        else{
            Context contexto = getApplicationContext();
            String texto = "Valor máximo";
            int duracao = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(contexto, texto,duracao);
            toast.show();
        }
    }

    public void menosDestreza(View v){
        TextView view = (TextView) findViewById(R.id.editDestreza);
        TextView total = (TextView) findViewById(R.id.totalPontos);
        int valor = Integer.valueOf(view.getText().toString());
        int pontos = Integer.valueOf(total.getText().toString());
        if(valor > 3) {
            valor--;
            pontos++;
            view.setText(Integer.toString(valor));
            total.setText(Integer.toString(pontos));
        }
        else{
            Context contexto = getApplicationContext();
            String texto = "Valor mínimo";
            int duracao = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(contexto, texto,duracao);
            toast.show();
        }
    }

    public void maisConstituicao(View v){
        TextView view = (TextView) findViewById(R.id.editConstituicao);
        TextView total = (TextView) findViewById(R.id.totalPontos);
        int valor = Integer.valueOf(view.getText().toString());
        int pontos = Integer.valueOf(total.getText().toString());
        if(valor < 20 && pontos > 0) {
            valor++;
            pontos--;
            view.setText(Integer.toString(valor));
            total.setText(Integer.toString(pontos));
        }
        else{
            Context contexto = getApplicationContext();
            String texto = "Valor máximo";
            int duracao = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(contexto, texto,duracao);
            toast.show();
        }
    }

    public void menosConstituicao(View v){
        TextView view = (TextView) findViewById(R.id.editConstituicao);
        TextView total = (TextView) findViewById(R.id.totalPontos);
        int valor = Integer.valueOf(view.getText().toString());
        int pontos = Integer.valueOf(total.getText().toString());
        if(valor > 3) {
            valor--;
            pontos++;
            view.setText(Integer.toString(valor));
            total.setText(Integer.toString(pontos));
        }
        else{
            Context contexto = getApplicationContext();
            String texto = "Valor mínimo";
            int duracao = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(contexto, texto,duracao);
            toast.show();
        }
    }

    public void maisSabedoria(View v){
        TextView view = (TextView) findViewById(R.id.editSabedoria);
        TextView total = (TextView) findViewById(R.id.totalPontos);
        int valor = Integer.valueOf(view.getText().toString());
        int pontos = Integer.valueOf(total.getText().toString());
        if(valor < 20 && pontos > 0) {
            valor++;
            pontos--;
            view.setText(Integer.toString(valor));
            total.setText(Integer.toString(pontos));
        }
        else{
            Context contexto = getApplicationContext();
            String texto = "Valor máximo";
            int duracao = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(contexto, texto,duracao);
            toast.show();
        }
    }

    public void menosSabedoria(View v){
        TextView view = (TextView) findViewById(R.id.editSabedoria);
        TextView total = (TextView) findViewById(R.id.totalPontos);
        int valor = Integer.valueOf(view.getText().toString());
        int pontos = Integer.valueOf(total.getText().toString());
        if(valor > 3) {
            valor--;
            pontos++;
            view.setText(Integer.toString(valor));
            total.setText(Integer.toString(pontos));
        }
        else{
            Context contexto = getApplicationContext();
            String texto = "Valor mínimo";
            int duracao = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(contexto, texto,duracao);
            toast.show();
        }
    }

    public void maisInteligencia(View v){
        TextView view = (TextView) findViewById(R.id.editInteligencia);
        TextView total = (TextView) findViewById(R.id.totalPontos);
        int valor = Integer.valueOf(view.getText().toString());
        int pontos = Integer.valueOf(total.getText().toString());
        if(valor < 20 && pontos > 0) {
            valor++;
            pontos--;
            view.setText(Integer.toString(valor));
            total.setText(Integer.toString(pontos));
        }
        else{
            Context contexto = getApplicationContext();
            String texto = "Valor máximo";
            int duracao = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(contexto, texto,duracao);
            toast.show();
        }
    }

    public void menosInteligencia(View v){
        TextView view = (TextView) findViewById(R.id.editInteligencia);
        TextView total = (TextView) findViewById(R.id.totalPontos);
        int valor = Integer.valueOf(view.getText().toString());
        int pontos = Integer.valueOf(total.getText().toString());
        if(valor > 3) {
            valor--;
            pontos++;
            view.setText(Integer.toString(valor));
            total.setText(Integer.toString(pontos));
        }
        else{
            Context contexto = getApplicationContext();
            String texto = "Valor mínimo";
            int duracao = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(contexto, texto,duracao);
            toast.show();
        }
    }

    public void maisCarisma(View v){
        TextView view = (TextView) findViewById(R.id.editCarisma);
        TextView total = (TextView) findViewById(R.id.totalPontos);
        int valor = Integer.valueOf(view.getText().toString());
        int pontos = Integer.valueOf(total.getText().toString());
        if(valor < 20 && pontos > 0) {
            valor++;
            pontos--;
            view.setText(Integer.toString(valor));
            total.setText(Integer.toString(pontos));
        }
        else{
            Context contexto = getApplicationContext();
            String texto = "Valor máximo";
            int duracao = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(contexto, texto,duracao);
            toast.show();
        }
    }

    public void menosCarisma(View v){
        TextView view = (TextView) findViewById(R.id.editCarisma);
        TextView total = (TextView) findViewById(R.id.totalPontos);
        int valor = Integer.valueOf(view.getText().toString());
        int pontos = Integer.valueOf(total.getText().toString());
        if(valor > 3) {
            valor--;
            pontos++;
            view.setText(Integer.toString(valor));
            total.setText(Integer.toString(pontos));
        }
        else{
            Context contexto = getApplicationContext();
            String texto = "Valor mínimo";
            int duracao = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(contexto, texto,duracao);
            toast.show();
        }
    }


}
