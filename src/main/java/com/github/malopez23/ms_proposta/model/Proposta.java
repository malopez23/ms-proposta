package com.github.malopez23.ms_proposta.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "tb_proposta")
public class Proposta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private BigDecimal valorSolicitado;
    private String prazoParaPagamento;
    private boolean aprovado;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    private User user;
}
