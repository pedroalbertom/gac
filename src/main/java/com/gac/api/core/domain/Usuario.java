package com.gac.api.core.domain;

public class Usuario {
    private Long id;
    private String nome;
    private String email;
    private String matricula;
    private String senha;
    private Role role;

    public Usuario() {
    }

    public Usuario(Long id, String nome, String email, String matricula, String senha, Role role) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.matricula = matricula;
        this.senha = senha;
        this.role = role;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}