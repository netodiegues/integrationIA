package com.finch.business.infra.persistence.repository;

import com.finch.business.domain.model.UrlConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jose.diegues
 */
@Repository
public interface UrlConfigRepository extends JpaRepository<UrlConfig, Long> {

}
