package com.prgwebtrabalho2.model;

import java.util.Date;


public class Pedido {
    private int id;
    private Date data;
    private int entrada;
    private int principal;
    private int sobremesa;

    // Construtor com argumentos
    public Pedido(int id, Date data, int entrada, int principal, int sobremesa) {
        this.id = id;
        this.data = data;
        this.entrada = entrada;
        this.principal = principal;
        this.sobremesa = sobremesa;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getEntrada() {
        return entrada;
    }

    public void setEntrada(int entrada) {
        this.entrada = entrada;
    }

    public int getPrincipal() {
        return principal;
    }

    public void setPrincipal(int principal) {
        this.principal = principal;
    }

    public int getSobremesa() {
        return sobremesa;
    }

    public void setSobremesa(int sobremesa) {
        this.sobremesa = sobremesa;
    }
}