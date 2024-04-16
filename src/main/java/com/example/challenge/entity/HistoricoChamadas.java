package com.example.challenge.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder


@Entity
@Table(name = "TB_HISTORICOCHAMADAS")
public class HistoricoChamadas {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_HISTORICOCHAMADAS")
    @SequenceGenerator(name = "SQ_HISTORICOCHAMADAS", sequenceName = "SQ_HISTORICOCHAMADAS", allocationSize = 1)
    @Column(name = "ID_HISTORICOCHAMADAS")
    private Long id;
    private LocalDateTime dataHora;
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(
            name = "MENSAGEM",
            referencedColumnName = "ID_MENSAGEM",
            foreignKey = @ForeignKey(
                    name = "FK_MENSAGEM_HISTORICOCHAMADAS"
            )
    )
    private Mensagem mensagens;
}