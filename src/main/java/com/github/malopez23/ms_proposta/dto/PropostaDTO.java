
//Marcelo Lopez Rodriguez Filho

//RM: 94592

package com.github.malopez23.ms_proposta.dto;

import com.github.malopez23.ms_proposta.model.Proposta;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PropostaDTO {

    private Long id;

    @NotNull(message = "O valor solicitado não pode ser nulo")
    private BigDecimal valorSolicitado;
    @Size(max = 3, message = "Máximo de 3 caracteres")
    private String prazoParaPagamento;
    @NotNull()
    private boolean aprovado;

    private Long userId;

    public PropostaDTO(Proposta entity) {
        id = entity.getId();
        valorSolicitado = entity.getValorSolicitado();
        prazoParaPagamento = entity.getPrazoParaPagamento();
        aprovado = entity.isAprovado();
        userId = entity.getUser().getId();
    }
}

//teste
