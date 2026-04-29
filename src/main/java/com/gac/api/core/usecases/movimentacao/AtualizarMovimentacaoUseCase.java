package com.gac.api.core.usecase;

import com.gac.api.core.domain.*;
import com.gac.api.core.gateway.*;

public class AtualizarMovimentacaoUseCase {

    private final MovimentacaoGateway movimentacaoGateway;

    public AtualizarMovimentacaoUseCase(MovimentacaoGateway movimentacaoGateway) {
        this.movimentacaoGateway = movimentacaoGateway;
    }

    public Movimentacao executar(Long id, Movimentacao dadosAtualizados) {
        Movimentacao movimentacaoExistente = movimentacaoGateway.listarTodas().stream()
            .filter(m -> m.getId().equals(id))
            .findFirst()
            .orElseThrow(() -> new RuntimeException("Registro de movimentação não encontrado."));

        movimentacaoExistente.setMatriculaProfessor(dadosAtualizados.getMatriculaProfessor());
        movimentacaoExistente.setSala(dadosAtualizados.getSala());

        if (dadosAtualizados.getDataHora() != null) {
            movimentacaoExistente.setDataHora(dadosAtualizados.getDataHora());
        }

        return movimentacaoGateway.salvar(movimentacaoExistente);
    }
}