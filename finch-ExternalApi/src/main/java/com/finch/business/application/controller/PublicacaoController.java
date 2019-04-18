package com.finch.business.application.controller;

import com.finch.business.application.exception.ResourceNotFoundException;
import com.finch.business.application.exception.ValidationErrorException;
import com.finch.business.domain.model.Publicacao;
import com.finch.business.domain.model.retorno.NumeroProcesso;
import com.finch.business.domain.model.retorno.PublicacaoRetorno;
import com.finch.business.domain.model.retorno.ResultadoEnum;
import com.finch.business.domain.service.PublicacaoService;
import com.finch.business.infra.util.RestResponsePage;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
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
@RequestMapping(value = "publicacoes")
@CrossOrigin(value = "*")
public class PublicacaoController {

    private final PublicacaoService publicacaoService;

    @Autowired
    public PublicacaoController(PublicacaoService publicacaoService) {
        this.publicacaoService = publicacaoService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "")
    public ResponseEntity<RestResponsePage<?>> findAll(Pageable pageable) {
        Page<?> requestPage = this.publicacaoService.findAllPagination(pageable);
        RestResponsePage<?> result = new RestResponsePage<>(requestPage.getContent(), requestPage.getTotalPages());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        if (this.publicacaoService.existsById(id)) {
            return new ResponseEntity<>(this.publicacaoService.findById(id), HttpStatus.OK);
        } else {
            throw new ResourceNotFoundException("Publicacao not found for ID: " + id);
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "")
    public ResponseEntity<?> create(@Valid @RequestBody Publicacao model) {

        try {
            model.setId(null);
            this.publicacaoService.create(model);

            List<NumeroProcesso> numeroProcesso = new ArrayList<>();

            PublicacaoRetorno retorno = new PublicacaoRetorno(model.getId_Publicacao(),
                    Boolean.TRUE,
                    HttpStatus.OK.toString(),
                    numeroProcesso,
                    ResultadoEnum.COM_PROVIDENCIA,
                    new BigDecimal(90L));

            return new ResponseEntity<>(retorno, HttpStatus.CREATED);

        } catch (ValidationErrorException ve) {
            return new ResponseEntity<>(ve.getErrors(), HttpStatus.BAD_REQUEST);

        }
    }

}
