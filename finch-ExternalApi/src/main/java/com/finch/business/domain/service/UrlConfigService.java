package com.finch.business.domain.service;

import com.finch.business.domain.model.UrlConfig;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.finch.business.infra.persistence.repository.UrlConfigRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author jose.diegues
 */
@Service
public class UrlConfigService implements ServiceInterface<UrlConfig, Long> {

    private Logger logger = LoggerFactory.getLogger(UrlConfigService.class);

    private final UrlConfigRepository urlConfigRepository;

    @Autowired
    public UrlConfigService(UrlConfigRepository urlConfigRepository) {
        this.urlConfigRepository = urlConfigRepository;
    }

    public Page<UrlConfig> findAllPagination(Pageable pageable) {
        return urlConfigRepository.findAll(pageable);
    }

    @Override
    public List<UrlConfig> findAll() {
        return urlConfigRepository.findAll();
    }

    @Override
    public UrlConfig findById(Long id) {
        return urlConfigRepository.getOne(id);
    }

    @Override
    public boolean existsById(Long id) {
        return urlConfigRepository.existsById(id);
    }

    @Override
    public UrlConfig create(UrlConfig model) {
        try {
            return urlConfigRepository.save(model);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }
    }

    @Override
    public UrlConfig update(UrlConfig model) {
        return urlConfigRepository.save(model);
    }

    @Override
    public boolean deleteById(Long id) {
        if (urlConfigRepository.existsById(id)) {
            urlConfigRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
