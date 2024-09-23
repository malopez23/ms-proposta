//Marcelo Lopez Rodriguez Filho
//RM: 94592

package com.github.malopez23.ms_proposta.model;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "tb_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;
    private String sobrenome;
    private String cpf;
    private String telefone;
    private BigDecimal renda;

    @OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST)
    private List<Proposta> itens = new ArrayList<>();

}
