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
@Table(name = "TB_MENSAGEM")
public class Mensagem {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_MENSAGEM")
    @SequenceGenerator(name = "SQ_MENSAGEM", sequenceName = "SQ_MENSAGEM", allocationSize = 1)
    @Column(name = "ID_MENSAGEM")
    private Long id;
    private String conteudo;
}