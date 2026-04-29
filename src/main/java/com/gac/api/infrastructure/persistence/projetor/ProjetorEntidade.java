package com.gac.api.infrastructure.persistence;

import com.gac.api.core.domain.StatusItem;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "projetores")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjetorEntidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String marca;
    private String modelo;

    @Column(unique = true)
    private String patrimonio;

    @Enumerated(EnumType.STRING)
    private StatusItem status;
}