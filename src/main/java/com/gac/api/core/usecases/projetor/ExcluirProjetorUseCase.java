package com.gac.api.core.usecase;

import com.gac.api.core.gateway.ProjetorGateway;

public class ExcluirProjetorUseCase {
    
    private final ProjetorGateway projetorGateway;

    public ExcluirProjetorUseCase(ProjetorGateway projetorGateway) {
        this.projetorGateway = projetorGateway;
    }

    public void executar(Long id) {
        Projetor projetor = projetorGateway.buscarPorId(id)
            .orElseThrow(() -> new RuntimeException("Projetor não encontrado."));

        if (projetor.getStatus() == StatusItem.EMPRESTADO) {
            throw new RuntimeException("Não é possível excluir um projetor que está em uso.");
        }

        projetorGateway.excluir(id);
    }
}