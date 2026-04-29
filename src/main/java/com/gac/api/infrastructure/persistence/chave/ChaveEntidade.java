package com.gac.api.infrastructure.persistence;

import com.gac.api.core.domain.StatusItem;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "chaves")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChaveEntidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sala;
    private String bloco;

    @Enumerated(EnumType.STRING)
    private StatusItem status;
}