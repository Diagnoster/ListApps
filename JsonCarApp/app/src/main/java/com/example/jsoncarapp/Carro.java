package com.example.jsoncarapp;

public class Carro {
    private int id;
    private String modelo;
    private String placa;

    public int getId() {
        return id;
    }

    public String getModelo() {
        return modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return "Carro{" +
                "id=" + id +
                ", modelo='" + modelo + '\'' +
                ", placa='" + placa + '\'' +
                '}';
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }
}
