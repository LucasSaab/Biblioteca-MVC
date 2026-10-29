package com.ger.biblioteca.biblioteca.model;

import java.util.ArrayList;
import java.util.List;

public class Autor {
    private String nome;
    private String nacionalidade;
    private List<String> livrosPublicados = new ArrayList<>();
    public Autor() {
    }

    public Autor(String nome, String nacionalidade, List<String> livrosPublicados) {
        this.nome = nome;
        this.nacionalidade = nacionalidade;
        if (livrosPublicados != null) {
            this.livrosPublicados = livrosPublicados;
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public List<String> getLivrosPublicados() {
        return livrosPublicados;
    }

    public void setLivrosPublicados(List<String> livrosPublicados) {
        this.livrosPublicados = livrosPublicados;
    }
}