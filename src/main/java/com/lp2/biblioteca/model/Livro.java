package com.lp2.biblioteca.model;

public class Livro {
    private Long id;
    private String nome;
    private int ano;
    private String autor;
    private boolean status; // true -> disponivel, false -> emprestado
    private Long responsavelId;

    public Livro() {
    }

    public Livro(Livro livro) {
        this.id = livro.getId();
        this.ano = livro.getAno();
        this.nome = livro.getNome();
        this.autor = livro.getAutor();
        this.status = livro.isStatus();
        this.responsavelId = livro.getResponsavelId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Long getResponsavelId() {
        return responsavelId;
    }

    public void setResponsavelId(Long responsavelId) {
        this.responsavelId = responsavelId;
    }

    public String getStatusTexto() {
        return status ? "Disponível" : "Emprestado";
    }
}
