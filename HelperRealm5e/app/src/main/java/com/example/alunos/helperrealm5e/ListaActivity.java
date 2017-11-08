package com.example.alunos.helperrealm5e;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class ListaActivity extends AppCompatActivity {

    BancoController crud1;
    String codigo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        BancoController crud = new BancoController(getBaseContext());
        final Cursor cursor = crud.carregaDados();

        String[] nomeCampos = new String[] {CriaBanco.NOME, CriaBanco.CLASSE, CriaBanco.RACA, CriaBanco.LEVEL};
        int[] idViews = new int[] {R.id.nomePers, R.id.classePers, R.id.racaPers,R.id.levelPers};
        SimpleCursorAdapter adaptador = new SimpleCursorAdapter(getBaseContext(), R.layout.row_layout, cursor, nomeCampos, idViews, 0);
        ListView lista = (ListView) findViewById(R.id.listView);
        lista.setAdapter(adaptador);


        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick (AdapterView<?> parent, View view, int position, long id) {
                AlertDialog alerta;


                Cursor cursor1;
                cursor.moveToPosition(position);
                codigo = cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.ID));
                AlertDialog.Builder builder = new AlertDialog.Builder(ListaActivity.this);
                builder.setTitle("Personagem");
                builder.setMessage("Você deseja alterar ou editar o personagem?");

                builder.setPositiveButton("Alterar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                        crud1.apagaRegistro(Integer.parseInt(codigo));
                        finish();
                    }
                });
                builder.setNegativeButton("Editar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                        Intent intent = new Intent(ListaActivity.this, EditaActivity.class);
                        intent.putExtra("codigo", codigo);
                        startActivity(intent);
                        finish();
                    }
                });



            }
        });
    }
}
