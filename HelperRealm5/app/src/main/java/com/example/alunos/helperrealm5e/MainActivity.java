package com.example.alunos.helperrealm5e;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void criarPersonagem(View v){
        Intent it = new Intent(this, CriaActivity.class);
        startActivity(it);
    }

    public void editarPersonagens(View v){
        Intent it = new Intent(this, EditaActivity.class);
        startActivity(it);
    }

    public void listarPersonagens(View v){
        Intent it = new Intent(this, ListaActivity.class);
        startActivity(it);
    }

    public void mostrarPersonagem(View v){
        Intent it = new Intent(this, personagemActivity.class);
        startActivity(it);
    }
}
