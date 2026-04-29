package com.gac.api.core.usecase;

import com.gac.api.core.domain.Chave;
import com.gac.api.core.domain.StatusItem;
import com.gac.api.core.gateway.ChaveGateway;

public class CriarChaveUseCase {
    private final ChaveGateway chaveGateway

    public CriarChaveUseCase(ChaveGateway chaveGateway){
        this.chaveGateway = chaveGateway
    }

    public Chave executar(Chave novaChave) {
        novaChave.setStatus(StatusItem.DISPONIVEL);
        
        if (novaChave.getSala() == null || novaChave.getBloco() == null) {
            throw new RuntimeException("Sala e Bloco são obrigatórios para cadastrar uma chave.");
        }

        return chaveGateway.salvar(novaChave);
    }
}