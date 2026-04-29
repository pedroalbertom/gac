package com.gac.api.core.usecase;

import com.gac.api.core.domain.Usuario;
import com.gac.api.core.gateway.UsuarioGateway;
import java.util.List;

public class ListarUsuariosUseCase {
    private final UsuarioGateway usuarioGateway;

    public ListarUsuariosUseCase(UsuarioGateway usuarioGateway) {
        this.usuarioGateway = usuarioGateway;
    }

    public List<Usuario> executar() {
        return usuarioGateway.listarTodos();
    }
}