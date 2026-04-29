package com.gac.api.core.domain;

public class Chave {
    private Long id;
    private String sala;
    private String bloco;
    private StatusItem status;

    public Chave() {
    }

    public Chave(Long id, String sala, String bloco, StatusItem status) {
        this.id = id;
        this.sala = sala;
        this.bloco = bloco;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public String getBloco() {
        return bloco;
    }

    public void setBloco(String bloco) {
        this.bloco = bloco;
    }

    public StatusItem getStatus() {
        return status;
    }

    public void setStatus(StatusItem status) {
        this.status = status;
    }
}