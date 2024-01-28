package br.com.leandrolara.gestao_vagas.modules.candidate;

import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.leandrolara.gestao_vagas.exceptions.UserFoundException;

public interface CandidateRepository extends JpaRepository<CandidateEntity, UUID>{
    
    Optional<CandidateEntity> findByUsernameOrEmail(String username, String email);

}
