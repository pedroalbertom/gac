package com.gac.api.core.usecase;

import com.gac.api.core.domain.Chave;
import com.gac.api.core.domain.StatusItem;
import com.gac.api.core.gateway.ChaveGateway;

public class ListarChaveUseCase {
    private final ChaveGateway chaveGateway

    public ListarChaveUseCase(ChaveGateway chaveGateway){
        this.chaveGateway = chaveGateway
    }

    public List<Chave> executar() {
        return chaveGateway.listarTodas(novaChave);
    }
}