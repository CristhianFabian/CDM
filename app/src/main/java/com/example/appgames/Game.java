package com.example.appgames;

public class Game {

    public int id;
    public String nome, categoria;

    public Game() {
    }

    public Game(String nome, String categoria) {
        this.nome = nome;
        this.categoria = categoria;
    }

    public Game(int id, String nome, String categoria) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return nome + " | "+ categoria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
