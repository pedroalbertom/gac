package com.gac.api.infrastructure.persistence;

import com.gac.api.core.domain.Movimentacao;
import com.gac.api.core.domain.Projetor;
import com.gac.api.core.domain.Chave;
import com.gac.api.core.domain.Usuario;
import com.gac.api.core.gateway.MovimentacaoGateway;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class MovimentacaoGatewayImpl implements MovimentacaoGateway {

    private final MovimentacaoRepository repository;

    public MovimentacaoGatewayImpl(MovimentacaoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Movimentacao salvar(Movimentacao m) {
        List<ProjetorEntity> pEntities = m.getProjetores().stream()
            .map(p -> new ProjetorEntity(p.getId(), p.getMarca(), p.getModelo(), p.getPatrimonio(), p.getStatus()))
            .collect(Collectors.toList());

        List<ChaveEntity> cEntities = m.getChaves().stream()
            .map(c -> new ChaveEntity(c.getId(), c.getSala(), c.getBloco(), c.getStatus()))
            .collect(Collectors.toList());

        UsuarioEntity atendenteEntity = new UsuarioEntity(
            m.getAtendente().getId(), m.getAtendente().getNome(), m.getAtendente().getEmail(),
            m.getAtendente().getMatricula(), m.getAtendente().getSenha(), m.getAtendente().getRole()
        );

        MovimentacaoEntity entity = new MovimentacaoEntity(
            m.getId(), m.getDataHora(), m.getMatriculaProfessor(), m.getSala(),
            atendenteEntity, m.getTipo(), pEntities, cEntities
        );

        return toDomain(repository.save(entity));
    }

    @Override
    public List<Movimentacao> listarTodas() {
        return repository.findAll().stream().map(this::toDomain).collect(Collectors.toList());
    }

    @Override
    public List<Movimentacao> buscarPorMatriculaProfessor(String matricula) {
        return repository.findByMatriculaProfessor(matricula).stream()
                .map(this::toDomain).collect(Collectors.toList());
    }

    @Override
    public void excluir(Long id) {
        repository.deleteById(id);
    }

    private Movimentacao toDomain(MovimentacaoEntity e) {
        List<Projetor> projetores = e.getProjetores().stream()
            .map(p -> new Projetor(p.getId(), p.getMarca(), p.getModelo(), p.getPatrimonio(), p.getStatus()))
            .collect(Collectors.toList());

        List<Chave> chaves = e.getChaves().stream()
            .map(c -> new Chave(c.getId(), c.getSala(), c.getBloco(), c.getStatus()))
            .collect(Collectors.toList());

        Usuario atendente = new Usuario(
            e.getAtendente().getId(), e.getAtendente().getNome(), e.getAtendente().getEmail(),
            e.getAtendente().getMatricula(), e.getAtendente().getSenha(), e.getAtendente().getRole()
        );

        return new Movimentacao(e.getId(), e.getDataHora(), e.getMatriculaProfessor(), 
                               e.getSala(), atendente, e.getTipo(), projetores, chaves);
    }
}