//Marcelo Lopez Rodriguez Filho
//RM: 94592

package com.github.malopez23.ms_proposta.service;

import com.github.malopez23.ms_proposta.dto.PropostaDTO;
import com.github.malopez23.ms_proposta.model.Proposta;
import com.github.malopez23.ms_proposta.model.User;
import com.github.malopez23.ms_proposta.repository.PropostaRepository;
import com.github.malopez23.ms_proposta.repository.UserRepository;
import com.github.malopez23.ms_proposta.service.exception.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PropostaService {
    @Autowired
    private PropostaRepository repository;

    @Autowired
    private UserRepository userRepository;

    @Transactional(readOnly = true)
    public Page<PropostaDTO> findAll(Pageable pageable) {
        Page<Proposta> page = repository.findAll(pageable);
        return page.map(PropostaDTO::new);
    }

    @Transactional(readOnly = true)
    public PropostaDTO findById(Long id) {
        Proposta entity = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado Id: " + id)
        );
        return new PropostaDTO(entity);
    }

    @Transactional
    public PropostaDTO insert(PropostaDTO dto) {
        Proposta entity = new Proposta();
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return new PropostaDTO(entity);
    }

    private void copyDtoToEntity(PropostaDTO dto, Proposta entity) {
        entity.setValorSolicitado(dto.getValorSolicitado());
        entity.setPrazoParaPagamento(dto.getPrazoParaPagamento());
        entity.setAprovado(dto.isAprovado());

        User user = userRepository.getReferenceById(dto.getUserId());
        entity.setUser(user);
    }

    @Transactional
    public PropostaDTO update(Long id, PropostaDTO dto) {
        try {
            Proposta proposta = repository.getReferenceById(id);
            copyDtoToEntity(dto, proposta);
            proposta = repository.save(proposta);
            return new PropostaDTO(proposta);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Recurso não encontrado! Id: " + id);
        }
    }

    @Transactional
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Recurso não encontrado! Id: " + id);
        }
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            throw new ResourceNotFoundException("Recurso não encontrado! Id: " + id);
        }
    }

}

