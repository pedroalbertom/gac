package com.gac.api.core.gateway;

import com.gac.api.core.domain.Chave;
import java.util.List;
import java.util.Optional;

public interface ChaveGateway {
    Chave salvar(Chave chave);

    List<Chave> listarTodas();

    Optional<Chave> buscarPorId(Long id);

    void excluir(Long id);
}
