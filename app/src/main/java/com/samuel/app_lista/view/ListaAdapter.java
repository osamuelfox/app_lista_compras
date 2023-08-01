package com.samuel.app_lista.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.samuel.app_lista.R;
import com.samuel.app_lista.model.Lista;

import java.util.ArrayList;
import java.util.List;

public class ListaAdapter extends RecyclerView.Adapter<ListaAdapter.ListaViewHolder>  {
    private final List<Lista> listas;

    public ListaAdapter(ArrayList<Lista> listas) {
        this.listas = listas;
    }

    @NonNull
    @Override
    public ListaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item, parent, false);
        return new ListaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListaViewHolder holder, int position) {
        Lista lista = listas.get(position);
        holder.bind(lista);
    }

    @Override
    public int getItemCount() {
        return listas.size();
    }

    class ListaViewHolder extends RecyclerView.ViewHolder{

        TextView txtNome;

        public ListaViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNome = itemView.findViewById(R.id.txt_nome);

        }

        public void bind(Lista lista) {
            txtNome.setText(lista.getNome());
        }
    }
}
