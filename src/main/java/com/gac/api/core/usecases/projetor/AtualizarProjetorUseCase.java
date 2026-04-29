package com.gac.api.core.usecase;

import com.gac.api.core.domain.Projetor;
import com.gac.api.core.gateway.ProjetorGateway;

public class EditarProjetorUseCase {

    private final ProjetorGateway projetorGateway;

    public EditarProjetorUseCase(ProjetorGateway projetorGateway) {
        this.projetorGateway = projetorGateway;
    }

    public Projetor executar(Long id, Projetor dadosAtualizados) {
        Projetor projetorExistente = projetorGateway.buscarPorId(id)
            .orElseThrow(() -> new RuntimeException("Projetor não encontrado."));

        projetorExistente.setMarca(dadosAtualizados.getMarca());
        projetorExistente.setModelo(dadosAtualizados.getModelo());
        projetorExistente.setPatrimonio(dadosAtualizados.getPatrimonio());

        return projetorGateway.salvar(projetorExistente);
    }
}