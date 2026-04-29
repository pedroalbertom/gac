package com.gac.api.infrastructure.configuration;

import com.gac.api.core.gateway.ChaveGateway;
import com.gac.api.core.gateway.ProjetorGateway;
import com.gac.api.core.usecase.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChaveConfig {

    @Bean
    public CriarChaveUseCase criarChaveUseCase(ChaveGateway gateway) {
        return new CriarChaveUseCase(gateway);
    }

    @Bean
    public ListarChavesUseCase listarChavesUseCase(ChaveGateway gateway) {
        return new ListarChavesUseCase(gateway);
    }

    @Bean
    public EditarChaveUseCase editarChaveUseCase(ChaveGateway gateway) {
        return new EditarChaveUseCase(gateway);
    }

    @Bean
    public ExcluirChaveUseCase excluirChaveUseCase(ChaveGateway gateway) {
        return new ExcluirChaveUseCase(gateway);
    }
}