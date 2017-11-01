package com.example.alunos.helperrealm5e;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


public class BancoController {
    private SQLiteDatabase db;
    private CriaBanco banco;

    public BancoController(Context context) {
        banco = new CriaBanco(context);
    }

    public String insereDados(int forca, int destreza, int constituicao, int inteligencia, int sabedoria, int carisma, String nome, String crasse, String race, int lvl, int vida) {
        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(CriaBanco.NOME, nome);
        valores.put(CriaBanco.CLASSE, crasse);
        valores.put(CriaBanco.RACA, race);
        valores.put(CriaBanco.LEVEL, lvl);
        valores.put(CriaBanco.VIDA, vida);
        valores.put(CriaBanco.FORCA, forca);
        valores.put(CriaBanco.DESTREZA, destreza);
        valores.put(CriaBanco.CONSTITUICAO, constituicao);
        valores.put(CriaBanco.INTELIGENCIA, inteligencia);
        valores.put(CriaBanco.SABEDORIA, sabedoria);
        valores.put(CriaBanco.CARISMA, carisma);

        resultado = db.insert(CriaBanco.TABELA, null, valores);
        db.close();

        if (resultado ==-1) {
            return "Erro ao inserir registro";
        } else {
            return "Registro Inserido com sucesso";
        }
    }

    public Cursor carregaDados() {
        Cursor cursor;
        String[] campos = {banco.NOME, banco.CLASSE, banco.RACA, banco.LEVEL};
        db = banco.getReadableDatabase();
        cursor = db.query(banco.TABELA, campos, null, null, null, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }
}