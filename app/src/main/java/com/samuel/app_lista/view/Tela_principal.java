package com.samuel.app_lista.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.samuel.app_lista.R;
import com.samuel.app_lista.controller.Controller_lista;
import com.samuel.app_lista.database.Lista_DB;
import com.samuel.app_lista.model.Itens;
import com.samuel.app_lista.model.Lista;

import java.util.ArrayList;

public class Tela_principal extends AppCompatActivity {

    Controller_lista controller_lista;
    Lista lista;
    EditText edit_nome, edit_quantidade;
    Button bt_adicionar;

    private ListaAdapter listaAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);

        principal();

        listaAdapter = new ListaAdapter(new ArrayList<>(Itens.itens()));

        RecyclerView rv = findViewById(R.id.recycler);
        rv.setAdapter(listaAdapter);
    }

    private void principal() {
        edit_nome = findViewById(R.id.editText_nome);
        edit_quantidade = findViewById(R.id.editText_number);
        bt_adicionar = findViewById(R.id.button_adicinar);

        lista = new Lista();

        controller_lista = new Controller_lista(Tela_principal.this);

        bt_adicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                lista.setNome(edit_nome.getText().toString());
                lista.setQuantidade(Integer.valueOf(edit_quantidade.getText().toString()));

                Toast.makeText(Tela_principal.this, " Salvo ", Toast.LENGTH_SHORT).show();

                controller_lista.salvar(lista);
            }
        });
    }
}