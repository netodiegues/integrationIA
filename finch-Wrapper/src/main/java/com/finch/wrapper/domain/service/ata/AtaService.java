package com.finch.wrapper.domain.service.ata;

import com.finch.wrapper.domain.model.ata.Ata;
import com.finch.wrapper.domain.model.restTemplate.RestResponsePage;
import com.finch.wrapper.domain.model.retorno.AtaRetorno;
import com.finch.wrapper.infra.security.JWTAuthenticationInterceptor;
import java.net.URI;
import java.util.Collections;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

/**
 *
 * @author jose.diegues
 */
@Service
public class AtaService {
    
    private Logger logger = LoggerFactory.getLogger(AtaService.class);

    @Value("${finch.api-url.external}")
    private String URL;

    protected String getUrl() {
        return URL + "/atas";
    }

    private final RestTemplate restTemplate;

    public AtaService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
        this.restTemplate.setInterceptors(Collections.singletonList(new JWTAuthenticationInterceptor()));
    }

    public List<Ata> findAllAta(Pageable pageable) {

        ParameterizedTypeReference<RestResponsePage<Ata>> responseType
                = new ParameterizedTypeReference<RestResponsePage<Ata>>() {
        };

        URI targetUrl = UriComponentsBuilder.fromUriString(getUrl())
                .queryParam("page", pageable.getPageNumber())
                .queryParam("size", pageable.getPageSize())
                .queryParam("sort", pageable.getSort().isSorted() ? pageable.getSort() : null)
                .build()
                .toUri();

        ResponseEntity<RestResponsePage<Ata>> result = this.restTemplate.exchange(targetUrl.toString().replaceAll(":%20", ","), HttpMethod.GET, null, responseType);
        List<Ata> searchResult = result.getBody().getContent();
        return searchResult;

    }

    public Ata findAtaById(Long ataId) {
        Ata ata = this.restTemplate.getForObject(getUrl() + "/{ataId}", Ata.class, ataId);
        return ata;
    }

    public AtaRetorno createAta(Ata ata) throws Exception {
        return this.restTemplate.postForObject(getUrl(), ata, AtaRetorno.class);
    }

}
