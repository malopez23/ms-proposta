package com.github.malopez23.ms_proposta.dto;

import com.github.malopez23.ms_proposta.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserDTO {

    private Long id;

    @Size(max = 50, message = "Máximo de 50 caracteres")
    private String nome;
    @Size(max = 50, message = "Máximo de 50 caracteres")
    private String sobrenome;
    @Size(min = 11, max = 11, message = "Número do CPF deve ter 11 caracteres")
    private String cpf;
    @Size(min = 10, max = 10, message = "Número de telefone deve ter 10 caracteres")
    private String telefone;
    @DecimalMin(value = "0.0", inclusive = false, message = "O valor solicitado deve ser positivo")
    private BigDecimal renda;

    public UserDTO(User entity) {
        id = entity.getId();
        nome = entity.getNome();
        sobrenome = entity.getSobrenome();
        cpf = entity.getCpf();
        telefone = entity.getTelefone();
        renda = entity.getRenda();
    }
}
