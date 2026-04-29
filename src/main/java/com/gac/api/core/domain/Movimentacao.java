package com.gac.api.core.domain;

import java.time.LocalDateTime;
import java.util.List;

public class Movimentacao {
    private Long id;
    private LocalDateTime dataHora;
    private String matriculaProfessor;
    private String sala;
    private Usuario atendente;
    private TipoMovimentacao tipo; 
    private List<Projetor> projetores;
    private List<Chave> chaves;

    public Movimentacao() {
    }

    public Movimentacao(Long id, LocalDateTime dataHora, String matriculaProfessor, String sala, 
                        Usuario atendente, TipoMovimentacao tipo, 
                        List<Projetor> projetores, List<Chave> chaves) {
        this.id = id;
        this.dataHora = dataHora;
        this.matriculaProfessor = matriculaProfessor;
        this.sala = sala;
        this.atendente = atendente;
        this.tipo = tipo;
        this.projetores = projetores;
        this.chaves = chaves;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDateTime getDataHora() { return dataHora; }
    public void setDataHora(LocalDateTime dataHora) { this.dataHora = dataHora; }

    public String getMatriculaProfessor() { return matriculaProfessor; }
    public void setMatriculaProfessor(String matriculaProfessor) { this.matriculaProfessor = matriculaProfessor; }

    public String getSala() { return sala; }
    public void setSala(String sala) { this.sala = sala; }

    public Usuario getAtendente() { return atendente; }
    public void setAtendente(Usuario atendente) { this.atendente = atendente; }

    public TipoMovimentacao getTipo() { return tipo; }
    public void setTipo(TipoMovimentacao tipo) { this.tipo = tipo; }

    public List<Projetor> getProjetores() { return projetores; }
    public void setProjetores(List<Projetor> projetores) { this.projetores = projetores; }

    public List<Chave> getChaves() { return chaves; }
    public void setChaves(List<Chave> chaves) { this.chaves = chaves; }
}