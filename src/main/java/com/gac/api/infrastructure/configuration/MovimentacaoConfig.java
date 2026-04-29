package com.gac.api.infrastructure.configuration;

import com.gac.api.core.gateway.*;
import com.gac.api.core.usecase.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MovementConfig {

    @Bean
    public RegistrarMovimentacaoUseCase registrarMovimentacaoUseCase(
            MovimentacaoGateway mG, ProjetorGateway pG, ChaveGateway cG) {
        return new RegistrarMovimentacaoUseCase(mG, pG, cG);
    }

    @Bean
    public ListarMovimentacoesUseCase listarMovimentacoesUseCase(MovimentacaoGateway gateway) {
        return new ListarMovimentacoesUseCase(gateway);
    }

    @Bean
    public EditarMovimentacaoUseCase editarMovimentacaoUseCase(MovimentacaoGateway gateway) {
        return new EditarMovimentacaoUseCase(gateway);
    }

    @Bean
    public ExcluirMovimentacaoUseCase excluirMovimentacaoUseCase(MovimentacaoGateway gateway) {
        return new ExcluirMovimentacaoUseCase(gateway);
    }

    @Bean
    public BuscarMovimentacaoPorProfessorUseCase buscarMovimentacaoPorProfessorUseCase(MovimentacaoGateway gateway) {
        return new BuscarMovimentacaoPorProfessorUseCase(gateway);
    }
}