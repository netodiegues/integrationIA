package com.finch.business.infra.persistence.repository;

import com.finch.business.domain.model.Publicacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jose.diegues
 */
@Repository
public interface PublicacaoRepository extends JpaRepository<Publicacao, Long> {

}
