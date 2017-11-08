package com.example.alunos.helperrealm5e;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class EditaActivity extends AppCompatActivity {

    BancoController crud;
    String codigo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edita);

        codigo = this.getIntent().getStringExtra("codigo");

        crud = new BancoController(getBaseContext());

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

        List<String> lista = new ArrayList<String>();
        lista.add("Anão");
        lista.add("Elfo");
        lista.add("Halfling");
        lista.add("Humano");
        ArrayAdapter<String> dataadapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, lista);
        dataadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(dataadapter);

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
    }
}
