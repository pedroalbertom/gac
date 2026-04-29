package com.gac.api.core.usecase;

import com.gac.api.core.domain.Movimentacao;
import com.gac.api.core.gateway.MovimentacaoGateway;
import java.util.List;

public class ListarMovimentacoesUseCase {

    private final MovimentacaoGateway movimentacaoGateway;

    public ListarMovimentacoesUseCase(MovimentacaoGateway movimentacaoGateway) {
        this.movimentacaoGateway = movimentacaoGateway;
    }

    public List<Movimentacao> executar() {
        return movimentacaoGateway.listarTodas();
    }
}