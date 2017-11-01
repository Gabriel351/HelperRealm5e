package com.example.alunos.helperrealm5e;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CriaBanco extends SQLiteOpenHelper {

    public static final String NOME_BANCO = "helperrealm.db";
    public static final String TABELA = "Personagem";
    public static final String ID = "_id";
    public static final String NOME = "nome";
    public static final String FORCA = "forca";
    public static final String CONSTITUICAO = "constituicao";
    public static final String INTELIGENCIA = "inteligencia";
    public static final String SABEDORIA = "sabedoria";
    public static final String CARISMA = "carisma";
    public static final String DESTREZA = "destreza";
    public static final String RACA = "raca";
    public static final String CLASSE = "classe";
    public static final String LEVEL = "level";
    public static final String VIDA = "vida";
    public static final int VERSAO = 1;

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase){
        String sql = "CREATE TABLE " + TABELA + "(" + ID + " integer primary key autoincrement, " + NOME + " text, " + FORCA + " integer, " +
                     CONSTITUICAO + " integer, " + INTELIGENCIA + " integer, " + SABEDORIA + " integer, " + CARISMA + " integer, " + DESTREZA + " integer, " +
                     VIDA + " integer, " + LEVEL + " integer, " + RACA + " text, " + CLASSE + " text)";
        sqLiteDatabase.execSQL(sql);
    }

    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion){
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABELA);
        onCreate(sqLiteDatabase);
    }

    public CriaBanco(Context context){
        super(context, NOME_BANCO, null, VERSAO);
    }
}
