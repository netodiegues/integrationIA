package com.finch.business.domain.service;

import com.finch.business.domain.model.Publicacao;
import com.finch.business.infra.persistence.repository.PublicacaoRepository;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author jose.diegues
 */
@Service
public class PublicacaoService implements ServiceInterface<Publicacao, Long> {

    private Logger logger = LoggerFactory.getLogger(PublicacaoService.class);

    private final PublicacaoRepository publicacaoRepository;

    @Autowired
    public PublicacaoService(PublicacaoRepository publicacaoRepository) {
        this.publicacaoRepository = publicacaoRepository;
    }

    public Page<Publicacao> findAllPagination(Pageable pageable) {
        return publicacaoRepository.findAll(pageable);
    }

    @Override
    public List<Publicacao> findAll() {
        return publicacaoRepository.findAll();
    }

    @Override
    public Publicacao findById(Long id) {
        return publicacaoRepository.getOne(id);
    }

    @Override
    public boolean existsById(Long id) {
        return publicacaoRepository.existsById(id);
    }

    @Override
    public Publicacao create(Publicacao model) {
        try {
            logger.info("Registrando Publicacao");
            return publicacaoRepository.save(model);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }
    }

    @Override
    public Publicacao update(Publicacao model) {
        return publicacaoRepository.save(model);
    }

    @Override
    public boolean deleteById(Long id) {
        if (publicacaoRepository.existsById(id)) {
            publicacaoRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
