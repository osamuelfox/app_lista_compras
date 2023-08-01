package com.samuel.app_lista.model;

import android.widget.TextView;

import com.samuel.app_lista.R;
import com.samuel.app_lista.view.Tela_principal;

import java.util.Arrays;
import java.util.List;

public class Itens {


    public static List<Lista> itens(){


        return Arrays.asList(
                Lista.ListaBuilder.builder()
                        .setNome("Samuel")
                        .setQuantidade(10)
                        .build()
        );
    }
}
