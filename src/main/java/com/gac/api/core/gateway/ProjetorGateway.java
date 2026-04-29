package com.gac.api.core.gateway;

import com.gac.api.core.domain.Projetor;
import java.util.List;
import java.util.Optional;

public interface ProjetorGateway {
    Projetor salvar(Projetor projetor);

    List<Projetor> listarTodos();

    Optional<Projetor> buscarPorId(Long id);

    Optional<Projetor> buscarPorPatrimonio(String patrimonio);

    void excluir(Long id);
}