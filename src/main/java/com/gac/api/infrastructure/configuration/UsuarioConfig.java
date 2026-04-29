package com.gac.api.infrastructure.configuration;

import com.gac.api.core.gateway.UsuarioGateway;
import com.gac.api.core.usecase.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UsuarioConfig {

    @Bean
    public CriarUsuarioUseCase criarUsuarioUseCase(UsuarioGateway gateway) {
        return new CriarUsuarioUseCase(gateway);
    }

    @Bean
    public ListarUsuariosUseCase listarUsuariosUseCase(UsuarioGateway gateway) {
        return new ListarUsuariosUseCase(gateway);
    }

    @Bean
    public EditarUsuarioUseCase editarUsuarioUseCase(UsuarioGateway gateway) {
        return new EditarUsuarioUseCase(gateway);
    }

    @Bean
    public ExcluirUsuarioUseCase excluirUsuarioUseCase(UsuarioGateway gateway) {
        return new ExcluirUsuarioUseCase(gateway);
    }
}