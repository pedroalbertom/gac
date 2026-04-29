package com.gac.api.core.usecase;

import com.gac.api.core.domain.*;
import com.gac.api.core.gateway.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CriarMovimentacaoUseCase {

    private final MovimentacaoGateway movimentacaoGateway;
    private final ProjetorGateway projetorGateway;
    private final ChaveGateway chaveGateway;

    public CriarMovimentacaoUseCase(MovimentacaoGateway mG, ProjetorGateway pG, ChaveGateway cG) {
        this.movimentacaoGateway = mG;
        this.projetorGateway = pG;
        this.chaveGateway = cG;
    }

    public Movimentacao executar(
            String matriculaProfessor,
            String sala,
            List<Long> idsProjetores,
            List<Long> idsChaves,
            Usuario atendente,
            TipoMovimentacao tipo
    ) {
        List<Projetor> projetoresAlvo = new ArrayList<>();
        List<Chave> chavesAlvo = new ArrayList<>();

        for (Long id : idsProjetores) {
            Projetor p = projetorGateway.buscarPorId(id)
                    .orElseThrow(() -> new RuntimeException("Projetor ID " + id + " não encontrado."));
            
            validarEAtualizarStatus(p, tipo);
            projetorGateway.salvar(p);
            projetoresAlvo.add(p);
        }

        for (Long id : idsChaves) {
            Chave c = chaveGateway.buscarPorId(id)
                    .orElseThrow(() -> new RuntimeException("Chave ID " + id + " não encontrada."));
            
            validarEAtualizarStatus(c, tipo);
            chaveGateway.salvar(c);
            chavesAlvo.add(c);
        }

        Movimentacao movimentacao = new Movimentacao(
                null, 
                LocalDateTime.now(), 
                matriculaProfessor, 
                sala, 
                atendente, 
                tipo, 
                projetoresAlvo, 
                chavesAlvo
        );

        return movimentacaoGateway.salvar(movimentacao);
    }

    private void validarEAtualizarStatus(Object item, TipoMovimentacao tipo) {
        StatusItem novoStatus = (tipo == TipoMovimentacao.EMPRESTIMO) ? StatusItem.EMPRESTADO : StatusItem.DISPONIVEL;
        
        if (item instanceof Projetor p) {
            if (tipo == TipoMovimentacao.EMPRESTIMO && p.getStatus() == StatusItem.EMPRESTADO) {
                throw new RuntimeException("Projetor " + p.getPatrimonio() + " já está emprestado.");
            }
            p.setStatus(novoStatus);
        } else if (item instanceof Chave c) {
            if (tipo == TipoMovimentacao.EMPRESTIMO && c.getStatus() == StatusItem.EMPRESTADO) {
                throw new RuntimeException("Chave da sala " + c.getSala() + " já está emprestada.");
            }
            c.setStatus(novoStatus);
        }
    }
}