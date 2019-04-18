package com.finch.business.application.controller;

import com.finch.business.application.exception.ResourceNotFoundException;
import com.finch.business.domain.model.UrlConfig;
import com.finch.business.domain.service.UrlConfigService;
import com.finch.business.infra.util.RestResponsePage;
import java.util.Objects;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jose.diegues
 */
@RestController
@RequestMapping(value = "urls")
@CrossOrigin(value = "*")
public class UrlConfigController {

    private final UrlConfigService urlConfigService;

    @Autowired
    public UrlConfigController(UrlConfigService urlConfigService) {
        this.urlConfigService = urlConfigService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "")
    public ResponseEntity<RestResponsePage<?>> findAll(Pageable pageable) {
        Page<?> requestPage = this.urlConfigService.findAllPagination(pageable);
        RestResponsePage<?> result = new RestResponsePage<>(requestPage.getContent(), requestPage.getTotalPages());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        if (this.urlConfigService.existsById(id)) {
            return new ResponseEntity<>(this.urlConfigService.findById(id), HttpStatus.OK);
        } else {
            throw new ResourceNotFoundException("UrlConfig not found for ID: " + id);
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "")
    public ResponseEntity<?> create(@Valid @RequestBody UrlConfig model) {
        model.setId(null);
        return new ResponseEntity<>(this.urlConfigService.create(model), HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "{id}")
    public ResponseEntity<?> update(@Valid @RequestBody UrlConfig model, @PathVariable Long id) {
        if ((Objects.equals(id, model.getId())) && (this.urlConfigService.existsById(id))) {
            return new ResponseEntity<>(this.urlConfigService.update(model), HttpStatus.OK);
        } else {
            throw new ResourceNotFoundException("UrlConfig not exists for ID: " + id);
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        if (this.urlConfigService.existsById(id)) {
            return new ResponseEntity<>(this.urlConfigService.deleteById(id), HttpStatus.NO_CONTENT);
        } else {
            throw new ResourceNotFoundException("UrlConfig not exists for ID: " + id);
        }
    }
}
