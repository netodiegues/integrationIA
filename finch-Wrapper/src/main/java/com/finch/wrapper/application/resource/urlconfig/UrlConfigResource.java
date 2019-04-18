package com.finch.wrapper.application.resource.urlconfig;

import com.finch.wrapper.application.exception.ValidationErrorException;
import com.finch.wrapper.domain.model.urlconfig.UrlConfig;
import com.finch.wrapper.domain.service.urlConfig.UrlConfigService;
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
@RequestMapping(value = "wrapper/urls")
@CrossOrigin("*")
@Api(value = "Urls-Config")
public class UrlConfigResource {

    private final UrlConfigService urlConfigService;

    @Autowired
    public UrlConfigResource(UrlConfigService urlConfigService) {
        this.urlConfigService = urlConfigService;
    }

    @ApiOperation(
            value = "List all Urls",
            response = String.class,
            notes = "This operation creates a new Url.")
    @ApiResponses(value = {
        @ApiResponse(
                code = 200,
                message = "Success",
                response = String.class
        )
        ,
			@ApiResponse(
                code = 500,
                message = "Error to return Url",
                response = String.class
        )

    })
    @RequestMapping(method = RequestMethod.GET, value = "")
    public ResponseEntity<?> findAll(Pageable pageable) {
        return new ResponseEntity<>(this.urlConfigService.findAllUrlConfig(pageable), HttpStatus.OK);
    }

    @ApiOperation(value = "Url By Id")
    @RequestMapping(method = RequestMethod.GET, value = "{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(this.urlConfigService.findUrlConfigById(id), HttpStatus.OK);
    }

    @ApiOperation(value = "Create New Url Config")
    @RequestMapping(method = RequestMethod.POST, value = "")
    public ResponseEntity<?> create(@Valid @RequestBody UrlConfig urlConfig) throws Exception {
        ResponseEntity<?> responseEntity = null;
        try {
            responseEntity = new ResponseEntity<>(urlConfigService.createUrlConfig(urlConfig), HttpStatus.CREATED);

        } catch (ValidationErrorException ve) {
            return new ResponseEntity<>(ve.getErrors(), HttpStatus.BAD_REQUEST);

        } catch (Exception e) {
            throw e;
        }
        return responseEntity;
    }

    @ApiOperation(value = "Update Url Config")
    @RequestMapping(method = RequestMethod.PUT, value = "{urlConfigId}")
    public ResponseEntity<?> update(@Valid @RequestBody UrlConfig urlConfig, @PathVariable("urlConfigId") Long urlConfigId) throws Exception {
        ResponseEntity<?> responseEntity = null;
        try {
            urlConfigService.updateUrlConfig(urlConfig, urlConfigId);
            responseEntity = new ResponseEntity<>(urlConfig, HttpStatus.OK);

        } catch (ValidationErrorException ve) {
            return new ResponseEntity<>(ve.getErrors(), HttpStatus.BAD_REQUEST);

        } catch (Exception e) {
            throw e;
        }
        return responseEntity;
    }

    @ApiOperation(value = "Delete Url Config")
    @RequestMapping(method = RequestMethod.DELETE, value = "{urlConfigId}")
    public void delete(@PathVariable("urlConfigId") Long urlConfigId) throws Exception {
        urlConfigService.deleteUrlConfig(urlConfigId);
    }
}
