package com.gac.api.infrastructure.configuration;

import com.gac.api.core.gateway.ChaveGateway;
import com.gac.api.core.gateway.ProjetorGateway;
import com.gac.api.core.usecase.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjetorConfig {

    @Bean
    public CriarProjetorUseCase criarProjetorUseCase(ProjetorGateway gateway) {
        return new CriarProjetorUseCase(gateway);
    }

    @Bean
    public ListarProjetoresUseCase listarProjetoresUseCase(ProjetorGateway gateway) {
        return new ListarProjetoresUseCase(gateway);
    }

    @Bean
    public EditarProjetorUseCase editarProjetorUseCase(ProjetorGateway gateway) {
        return new EditarProjetorUseCase(gateway);
    }

    @Bean
    public ExcluirProjetorUseCase excluirProjetorUseCase(ProjetorGateway gateway) {
        return new ExcluirProjetorUseCase(gateway);
    }
}