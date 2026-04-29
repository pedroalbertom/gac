package com.gac.api.core.domain;

public class Projetor {
    private Long id;
    private String marca;
    private String modelo;
    private String patrimonio;
    private StatusItem status;

    public Projetor() {
    }

    public Projetor(Long id, String marca, String modelo, String patrimonio, StatusItem status) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.patrimonio = patrimonio;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPatrimonio() {
        return patrimonio;
    }

    public void setPatrimonio(String patrimonio) {
        this.patrimonio = patrimonio;
    }

    public StatusItem getStatus() {
        return status;
    }

    public void setStatus(StatusItem status) {
        this.status = status;
    }
}