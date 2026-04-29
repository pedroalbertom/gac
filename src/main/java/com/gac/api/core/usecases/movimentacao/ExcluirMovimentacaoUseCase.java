package com.gac.api.core.usecase;

import com.gac.api.core.gateway.MovimentacaoGateway;

public class ExcluirMovimentacaoUseCase {

    private final MovimentacaoGateway movimentacaoGateway;

    public ExcluirMovimentacaoUseCase(MovimentacaoGateway movimentacaoGateway) {
        this.movimentacaoGateway = movimentacaoGateway;
    }

    public void executar(Long id) {
        movimentacaoGateway.listarTodas().stream()
            .filter(m -> m.getId().equals(id))
            .findFirst()
            .orElseThrow(() -> new RuntimeException("Registro de movimentação não encontrado."));

        movimentacaoGateway.excluir(id);
    }
}