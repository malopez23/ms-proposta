//Marcelo Lopez Rodriguez Filho
//RM: 94592

package com.github.malopez23.ms_proposta.repository;

import com.github.malopez23.ms_proposta.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
