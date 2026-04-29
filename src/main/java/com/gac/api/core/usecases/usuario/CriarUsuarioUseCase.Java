package com.gac.api.core.usecase;

import com.gac.api.core.domain.Usuario;
import com.gac.api.core.gateway.UsuarioGateway;

public class CriarUsuarioUseCase {

    private final UsuarioGateway usuarioGateway;

    public CriarUsuarioUseCase(UsuarioGateway usuarioGateway) {
        this.usuarioGateway = usuarioGateway;
    }

    public Usuario executar(Usuario novoUsuario) {
        usuarioGateway.buscarPorEmail(novoUsuario.getEmail())
            .ifPresent(u -> {
                throw new RuntimeException("Este e-mail já está em uso.");
            });

        usuarioGateway.buscarPorMatricula(novoUsuario.getMatricula())
            .ifPresent(u -> {
                throw new RuntimeException("Esta matrícula já está cadastrada.");
            });

        if (novoUsuario.getSenha() == null || novoUsuario.getSenha().length() < 6) {
            throw new RuntimeException("A senha deve ter no mínimo 6 caracteres.");
        }

        return usuarioGateway.salvar(novoUsuario);
    }
}