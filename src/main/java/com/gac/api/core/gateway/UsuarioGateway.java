package com.gac.api.core.gateway;

import com.gac.api.core.domain.Usuario;
import java.util.List;
import java.util.Optional;

public interface UsuarioGateway {
    Usuario salvar(Usuario usuario);

    List<Usuario> listarTodos();

    Optional<Usuario> buscarPorEmail(String email);

    Optional<Usuario> buscarPorMatricula(String matricula);

    Optional<Usuario> buscarPorId(Long id);

    void excluir(Long id);
}