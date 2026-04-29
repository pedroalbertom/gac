package com.gac.api.core.usecase;

import com.gac.api.core.domain.Usuario;
import com.gac.api.core.gateway.UsuarioGateway;

public class EditarUsuarioUseCase {

    private final UsuarioGateway usuarioGateway;

    public EditarUsuarioUseCase(UsuarioGateway usuarioGateway) {
        this.usuarioGateway = usuarioGateway;
    }

    public Usuario executar(Long id, Usuario dadosAtualizados) {
        Usuario usuarioExistente = usuarioGateway.buscarPorId(id)
            .orElseThrow(() -> new RuntimeException("Usuário não encontrado."));

        usuarioExistente.setNome(dadosAtualizados.getNome());
        usuarioExistente.setEmail(dadosAtualizados.getEmail());
        usuarioExistente.setRole(dadosAtualizados.getRole());

        return usuarioGateway.salvar(usuarioExistente);
    }
}