package com.samuel.app_lista.model;

public class Lista {

    private String nome;

    private Integer quantidade;

    public Lista() {
    }

    public Lista(String nome, Integer quantidade) {
        this.nome = nome;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "Lista{" +
                "nome='" + nome + '\'' +
                ", quantidade=" + quantidade +
                '}';
    }


    public static class ListaBuilder{

        private String nome;
        private Integer quantidade;

        public ListaBuilder setNome(String nome) {
            this.nome = nome;
            return this;
        }

        public ListaBuilder setQuantidade(Integer quantidade) {
            this.quantidade = quantidade;
            return this;
        }

        private ListaBuilder(){}

        public static ListaBuilder builder (){
            return new ListaBuilder();
        }

        public  Lista build(){
            Lista lista = new Lista();
            lista.nome = nome;
            lista.quantidade = quantidade;
            return lista;

        }
    }
}
