package com.gac.api.core.usecase;

import com.gac.api.core.gateway.UsuarioGateway;

public class ExcluirUsuarioUseCase {
    private final UsuarioGateway usuarioGateway;

    public ExcluirUsuarioUseCase(UsuarioGateway usuarioGateway) {
        this.usuarioGateway = usuarioGateway;
    }

    public void executar(Long id) {
        if (!usuarioGateway.buscarPorId(id).isPresent()) {
            throw new RuntimeException("Usuário não encontrado.");
        }
        usuarioGateway.excluir(id);
    }
}