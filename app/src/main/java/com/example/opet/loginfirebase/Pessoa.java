package com.example.opet.loginfirebase;

import java.util.Date;

/**
 * Created by opet on 27/08/2018.
 */

public class Pessoa {
    private String id;
    private String nome;
    private Date nascimento;
    private String graduacao;
    private String idioma;

    public Pessoa() {
    }

    public Pessoa(String id, String nome, Date nascimento, String graduacao, String idioma) {
        this.id = id;
        this.nome = nome;
        this.nascimento = nascimento;
        this.graduacao = graduacao;
        this.idioma = idioma;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public String getGraduacao() {
        return graduacao;
    }

    public void setGraduacao(String graduacao) {
        this.graduacao = graduacao;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                '}';
    }
}
