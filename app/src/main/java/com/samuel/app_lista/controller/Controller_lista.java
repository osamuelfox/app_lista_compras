package com.samuel.app_lista.controller;

import android.content.ContentValues;
import android.util.Log;

import androidx.annotation.NonNull;

import com.samuel.app_lista.database.Lista_DB;
import com.samuel.app_lista.model.Lista;
import com.samuel.app_lista.view.Tela_principal;

public class Controller_lista extends Lista_DB {

    public  Controller_lista(Tela_principal activity){
        super(activity);

    }

    @NonNull
    @Override
    public String toString() {
        Log.d("MVC_Controller", "Controller iniciada");
        return super.toString();
    }

    public void salvar(Lista lista){
        Log.d("MVC_Controller", "Salvo");

        ContentValues dados = new ContentValues();
        dados.put("nome", lista.getNome());
        dados.put("quantidade",lista.getQuantidade());

        salvarDados("Lista",dados);
    }
}
