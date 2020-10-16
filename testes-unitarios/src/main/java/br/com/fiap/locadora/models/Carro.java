package br.com.fiap.locadora.models;

public class Carro {

    private String modelo;
    private Integer disponiveis;
    private Double valor;

    public Carro() {}

    public Carro(String modelo, Integer disponiveis, Double valor) {
        this.modelo = modelo;
        this.disponiveis = disponiveis;
        this.valor = valor;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getDisponiveis() {
        return disponiveis;
    }

    public void setDisponiveis(Integer disponiveis) {
        this.disponiveis = disponiveis;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
