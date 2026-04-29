package com.gac.api.core.usecase;

import com.gac.api.core.gateway.ChaveGateway;

public class ExcluirChaveUseCase {
    
    private final ChaveGateway chaveGateway;

    public ExcluirChaveUseCase(ChaveGateway chaveGateway) {
        this.chaveGateway = chaveGateway;
    }

    public void executar(Long id) {
        Chave chave = chaveGateway.buscarPorId(id)
            .orElseThrow(() -> new RuntimeException("Chave não encontrada para o ID informado."));

        if (chave.getStatus() == StatusItem.EMPRESTADO) {
            throw new RuntimeException("Regra de Negócio: Chaves em uso não podem ser removidas.");
        }
        
        chaveGateway.excluir(id);
    }
}