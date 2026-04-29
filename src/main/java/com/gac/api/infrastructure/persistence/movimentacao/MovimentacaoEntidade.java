package com.gac.api.infrastructure.persistence;

import com.gac.api.core.domain.TipoMovimentacao;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "movimentacoes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovimentacaoEntidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dataHora;
    private String matriculaProfessor;
    private String sala;

    @ManyToOne
    @JoinColumn(name = "atendente_id")
    private UsuarioEntity atendente;

    @Enumerated(EnumType.STRING)
    private TipoMovimentacao tipo;

    @ManyToMany
    @JoinTable(
        name = "movimentacao_projetores",
        joinColumns = @JoinColumn(name = "movimentacao_id"),
        inverseJoinColumns = @JoinColumn(name = "projetor_id")
    )
    private List<ProjetorEntity> projetores;

    @ManyToMany
    @JoinTable(
        name = "movimentacao_chaves",
        joinColumns = @JoinColumn(name = "movimentacao_id"),
        inverseJoinColumns = @JoinColumn(name = "chave_id")
    )
    private List<ChaveEntity> chaves;
}