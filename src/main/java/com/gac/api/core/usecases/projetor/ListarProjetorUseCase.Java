package com.gac.api.core.usecase;

import com.gac.api.core.domain.Projetor;
import com.gac.api.core.domain.StatusItem;
import com.gac.api.core.gateway.ProjetorGateway;

public class ListarProjetorUseCase {
    private final ProjetorGateway projetorGateway

    public ListarProjetorUseCase(ProjetorGateway projetorGateway){
        this.projetorGateway = projetorGateway
    }

    public List<Projetor> executar() {
        return projetorGateway.listarTodos(novaProjetor);
    }
}