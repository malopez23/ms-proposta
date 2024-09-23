//package com.github.malopez23.ms_proposta.dto;
//
//import com.github.malopez23.ms_proposta.model.Proposta;
//import com.github.malopez23.ms_proposta.model.User;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.math.BigDecimal;
//
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//public class PropostaResponseDTO {
//    private Long id;
//    private BigDecimal valorSolicitado;
//    private Integer prazoParaPagamento;
//    private Boolean aprovado;
//    private String nomeUsuario;
//    private String sobrenomeUsuario;
//
//    public PropostaResponseDTO(User user, Proposta proposta) {
//        this.id = proposta.getId();
//        this.valorSolicitado = proposta.getValorSolicitado();
//        this.prazoParaPagamento = proposta.getPrazoParaPagamento();
//        this.aprovado = proposta.getAprovado();
//        this.nomeUsuario = user.getNome();
//        this.sobrenomeUsuario = user.getSobrenome();
//    }
//}
