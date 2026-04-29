package com.gac.api.infrastructure.persistence;

import com.gac.api.core.domain.Usuario;
import com.gac.api.core.gateway.UsuarioGateway;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class UsuarioGatewayImpl implements UsuarioGateway {

    private final UsuarioRepository repository;

    public UsuarioGatewayImpl(UsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public Usuario salvar(Usuario usuario) {
        UsuarioEntity entity = new UsuarioEntity(
            usuario.getId(),
            usuario.getNome(),
            usuario.getEmail(),
            usuario.getMatricula(),
            usuario.getSenha(),
            usuario.getRole()
        );
        
        UsuarioEntity saved = repository.save(entity);
        
        return toDomain(saved);
    }

    @Override
    public List<Usuario> listarTodos() {
        return repository.findAll().stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Usuario> buscarByEmail(String email) {
        return repository.findByEmail(email).map(this::toDomain);
    }

    @Override
    public Optional<Usuario> buscarByMatricula(String matricula) {
        return repository.findByMatricula(matricula).map(this::toDomain);
    }

    @Override
    public Optional<Usuario> buscarById(Long id) {
        return repository.findById(id).map(this::toDomain);
    }

    @Override
    public void excluir(Long id) {
        repository.deleteById(id);
    }

    private Usuario toDomain(UsuarioEntity entity) {
        return new Usuario(
            entity.getId(),
            entity.getNome(),
            entity.getEmail(),
            entity.getMatricula(),
            entity.getSenha(),
            entity.getRole()
        );
    }
}