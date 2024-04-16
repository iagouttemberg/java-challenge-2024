package com.example.challenge.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder


@Entity
@Table(name = "TB_CLIENTE")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_CLIENTE")
    @SequenceGenerator(name = "SQ_CLIENTE", sequenceName = "SQ_CLIENTE", allocationSize = 1)
    @Column(name = "ID_CLIENTE")
    private Long id;
    private String nomeCompleto;
    private String email;
    private String senha;
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(
            name = "HISTORICOCHAMADAS",
            referencedColumnName = "ID_HISTORICOCHAMADAS",
            foreignKey = @ForeignKey(
                    name = "FK_HISTORICOCHAMADAS_CLIENTE"
            )
    )
    private HistoricoChamadas historicoChamadas;
}