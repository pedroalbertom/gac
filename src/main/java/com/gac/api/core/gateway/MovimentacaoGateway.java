package com.gac.api.core.gateway;

import com.gac.api.core.domain.Movimentacao;
import java.util.List;

public interface MovimentacaoGateway {
    Movimentacao salvar(Movimentacao movimentacao);

    List<Movimentacao> listarTodas();

    List<Movimentacao> buscarPorMatriculaProfessor(String matricula);

    void excluir(Long id);
}
