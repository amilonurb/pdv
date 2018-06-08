package com.brl.pdv.model;

public class Cliente {

    private String nome;
    private int bonus;
    private char perfil;
    private char status;

    public Cliente(String nome, char perfil, char status) {
        this.nome = nome;
        this.perfil = perfil;
        this.status = status;
        this.bonus = 0;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public char getPerfil() {
        return perfil;
    }

    public void setPerfil(char perfil) {
        this.perfil = perfil;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return this.nome;
    }
}
