package com.finch.business.domain.service;

import com.finch.business.domain.model.Ata;
import com.finch.business.infra.persistence.repository.AtaRepository;
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
public class AtaService implements ServiceInterface<Ata, Long> {

    private Logger logger = LoggerFactory.getLogger(AtaService.class);

    private final AtaRepository ataRepository;

    @Autowired
    public AtaService(AtaRepository ataRepository) {
        this.ataRepository = ataRepository;
    }

    public Page<Ata> findAllPagination(Pageable pageable) {
        return ataRepository.findAll(pageable);
    }

    @Override
    public List<Ata> findAll() {
        return ataRepository.findAll();
    }

    @Override
    public Ata findById(Long id) {
        return ataRepository.getOne(id);
    }

    @Override
    public boolean existsById(Long id) {
        return ataRepository.existsById(id);
    }

    @Override
    public Ata create(Ata model) {

        try {
            logger.info("Registrando Ata");

            Ata ata = new Ata(model);
            model.getArquivos().forEach(arquivo -> {
                arquivo.setAta(ata);
            });
            ata.setArquivos(model.getArquivos());
            return ataRepository.save(ata);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }

    }

    @Override
    public Ata update(Ata model) {
        return ataRepository.save(model);
    }

    @Override
    public boolean deleteById(Long id) {
        if (ataRepository.existsById(id)) {
            ataRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
