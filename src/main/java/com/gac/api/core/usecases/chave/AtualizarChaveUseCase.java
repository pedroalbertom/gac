package com.gac.api.core.usecase;

import com.gac.api.core.domain.Chave;
import com.gac.api.core.gateway.ChaveGateway;

public class EditarChaveUseCase {

    private final ChaveGateway chaveGateway;

    public EditarChaveUseCase(ChaveGateway chaveGateway) {
        this.chaveGateway = chaveGateway;
    }

    public Chave executar(Long id, Chave chaveAtualizada) {
        Chave chaveExistente = chaveGateway.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Chave não encontrada para o ID informado."));

        chaveExistente.setSala(chaveAtualizada.getSala());
        chaveExistente.setBloco(chaveAtualizada.getBloco());

        if (chaveExistente.getSala() == null || chaveExistente.getBloco() == null) {
            throw new RuntimeException("Sala e Bloco são obrigatórios para a edição.");
        }

        return chaveGateway.salvar(chaveExistente);
    }
}