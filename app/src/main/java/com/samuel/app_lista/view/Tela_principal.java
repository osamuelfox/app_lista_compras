package com.samuel.app_lista.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.samuel.app_lista.R;
import com.samuel.app_lista.controller.Controller_lista;
import com.samuel.app_lista.database.Lista_DB;
import com.samuel.app_lista.model.Lista;

public class Tela_principal extends AppCompatActivity {

    Controller_lista controller_lista;

    Lista lista;

    Lista outrasLista;


    EditText edit_nome, edit_quantidade;
    Button bt_adicionar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);

        edit_nome = findViewById(R.id.editText_nome);
        edit_quantidade = findViewById(R.id.editText_number);
        bt_adicionar = findViewById(R.id.button_adicinar);

        lista = new Lista();

        controller_lista = new Controller_lista(Tela_principal.this);

        bt_adicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                outrasLista.setNome(edit_nome.getText().toString());
                outrasLista.setQuantidade(Integer.parseInt(edit_quantidade.toString()));

                Toast.makeText(Tela_principal.this, " Salvo ", Toast.LENGTH_SHORT).show();

                controller_lista.salvar(outrasLista);
            }
        });
    }
}