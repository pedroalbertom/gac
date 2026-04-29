package com.gac.api.core.usecase;

import com.gac.api.core.domain.Projetor;
import com.gac.api.core.domain.StatusItem;
import com.gac.api.core.gateway.ProjetorGateway;

public class CriarProjetorUseCase {

    private final ProjetorGateway projetorGateway;

    public CriarProjetorUseCase(ProjetorGateway projetorGateway) {
        this.projetorGateway = projetorGateway;
    }

    public Projetor executar(Projetor novoProjetor) {
        projetorGateway.buscarPorPatrimonio(novoProjetor.getPatrimonio())
            .ifPresent(p -> {
                throw new RuntimeException("Já existe um projetor cadastrado com este patrimônio.");
            });

        novoProjetor.setStatus(StatusItem.DISPONIVEL);

        if (novoProjetor.getMarca() == null || novoProjetor.getPatrimonio() == null) {
            throw new RuntimeException("Marca e Patrimônio são campos obrigatórios.");
        }

        return projetorGateway.salvar(novoProjetor);
    }
}