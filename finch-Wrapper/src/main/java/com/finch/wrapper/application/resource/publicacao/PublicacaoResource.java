package com.finch.wrapper.application.resource.publicacao;

import com.finch.wrapper.application.exception.ValidationErrorException;
import com.finch.wrapper.domain.model.publicacao.Publicacao;
import com.finch.wrapper.domain.service.publicacao.PublicacaoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping(value = "wrapper/publicacoes")
@CrossOrigin("*")
@Api(value = "Publicacoes")
public class PublicacaoResource {

    private final PublicacaoService publicacaoService;

    @Autowired
    public PublicacaoResource(PublicacaoService publicacaoService) {
        this.publicacaoService = publicacaoService;
    }

    @ApiOperation(
            value = "List all Publicacao",
            response = String.class,
            notes = "This operation creates a new Publicacao.")
    @ApiResponses(value = {
        @ApiResponse(
                code = 200,
                message = "Success",
                response = String.class
        )
        ,
			@ApiResponse(
                code = 500,
                message = "Error to return Publicacao",
                response = String.class
        )

    })
    @RequestMapping(method = RequestMethod.GET, value = "")
    public ResponseEntity<?> findAll(Pageable pageable) {
        return new ResponseEntity<>(this.publicacaoService.findAllPublicacao(pageable), HttpStatus.OK);
    }

    @ApiOperation(value = "Publicacao By Id")
    @RequestMapping(method = RequestMethod.GET, value = "{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(this.publicacaoService.findPublicacaoById(id), HttpStatus.OK);
    }

    @ApiOperation(value = "Create New Publicacao")
    @RequestMapping(method = RequestMethod.POST, value = "")
    public ResponseEntity<?> create(@Valid @RequestBody Publicacao publicacao) throws Exception {
        ResponseEntity<?> responseEntity = null;
        try {
            responseEntity = new ResponseEntity<>(publicacaoService.createPublicacao(publicacao), HttpStatus.CREATED);

        } catch (ValidationErrorException ve) {
            return new ResponseEntity<>(ve.getErrors(), HttpStatus.BAD_REQUEST);

        } catch (Exception e) {
            throw e;
        }
        return responseEntity;
    }
}
