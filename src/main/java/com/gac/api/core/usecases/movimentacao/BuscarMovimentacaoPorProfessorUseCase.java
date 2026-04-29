package com.gac.api.core.usecase;

import com.gac.api.core.domain.Movimentacao;
import com.gac.api.core.gateway.MovimentacaoGateway;
import java.util.List;

public class BuscarMovimentacaoPorProfessorUseCase {

    private final MovimentacaoGateway movimentacaoGateway;

    public BuscarMovimentacaoPorProfessorUseCase(MovimentacaoGateway movimentacaoGateway) {
        this.movimentacaoGateway = movimentacaoGateway;
    }

    public List<Movimentacao> executar(String matricula) {
        return movimentacaoGateway.buscarPorMatriculaProfessor(matricula);
    }
}