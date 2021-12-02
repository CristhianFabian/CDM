package com.example.appgames;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class GameDAO {

    public static void inserir(Context context, Game game){

        ContentValues values = new ContentValues();
        values.put("nome", game.getNome());
        values.put("categoria", game.getCategoria());

        Banco connect = new Banco(context);
        SQLiteDatabase db = connect.getWritableDatabase();

        db.insert("games", null, values);

    }

    public static void editar(Context context, Game game){

        ContentValues values = new ContentValues();
        values.put("nome", game.getNome());
        values.put("categoria", game.getCategoria());

        Banco connect = new Banco(context);
        SQLiteDatabase db = connect.getWritableDatabase();

        db.update("games", values, "id = " + game.getId(), null);

    }

    public static void excluir(Context context, int idGame){

        Banco connect = new Banco(context);
        SQLiteDatabase db = connect.getWritableDatabase();

        db.delete("games", "id = " + idGame, null);
    }

    public static List<Game> getJogos(Context context){

        List<Game> lista = new ArrayList<>();

        Banco connect = new Banco(context);
        SQLiteDatabase db = connect.getReadableDatabase();

        Cursor cursor = db.rawQuery("select * from games order by nome", null);

        if(cursor.getCount() > 0){

            cursor.moveToFirst();
            do{
                Game jogo = new Game();
                jogo.setId(cursor.getInt(0));
                jogo.setNome(cursor.getString(1));
                jogo.setCategoria(cursor.getString(2));
                lista.add(jogo);

            }while (cursor.moveToNext());
        }

        return lista;

    }

    public static Game getGameById(Context context, int idJogo){
        Banco connect = new Banco(context);
        SQLiteDatabase db = connect.getReadableDatabase();

        Cursor cursor = db.rawQuery("select * from games where id = " + idJogo, null);

        if( cursor.getCount() > 0){
            cursor.moveToFirst();
                Game jogo = new Game();
                jogo.setId(cursor.getInt(0));
                jogo.setNome(cursor.getString(1));
                jogo.setCategoria(cursor.getString(2));

                return jogo;

        }else {
            return null;
        }

    }
}
