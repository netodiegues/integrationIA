package com.finch.wrapper.domain.service.publicacao;

import com.finch.wrapper.domain.model.publicacao.Publicacao;
import com.finch.wrapper.domain.model.restTemplate.RestResponsePage;
import com.finch.wrapper.domain.model.retorno.PublicacaoRetorno;
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
public class PublicacaoService {
    
    private Logger logger = LoggerFactory.getLogger(PublicacaoService.class);

    @Value("${finch.api-url.external}")
    private String URL;

    protected String getUrl() {
        return URL + "/publicacoes";
    }

    private final RestTemplate restTemplate;

    public PublicacaoService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
        this.restTemplate.setInterceptors(Collections.singletonList(new JWTAuthenticationInterceptor()));
    }

    public List<Publicacao> findAllPublicacao(Pageable pageable) {

        ParameterizedTypeReference<RestResponsePage<Publicacao>> responseType
                = new ParameterizedTypeReference<RestResponsePage<Publicacao>>() {
        };

        URI targetUrl = UriComponentsBuilder.fromUriString(getUrl())
                .queryParam("page", pageable.getPageNumber())
                .queryParam("size", pageable.getPageSize())
                .queryParam("sort", pageable.getSort().isSorted() ? pageable.getSort() : null)
                .build()
                .toUri();

        ResponseEntity<RestResponsePage<Publicacao>> result = this.restTemplate.exchange(targetUrl.toString().replaceAll(":%20", ","), HttpMethod.GET, null, responseType);
        List<Publicacao> searchResult = result.getBody().getContent();
        return searchResult;

    }

    public Publicacao findPublicacaoById(Long publicacaoId) {
        Publicacao publicacao = this.restTemplate.getForObject(getUrl() + "/{publicacaoId}", Publicacao.class, publicacaoId);
        return publicacao;
    }

    public PublicacaoRetorno createPublicacao(Publicacao publicacao) throws Exception {
        return this.restTemplate.postForObject(getUrl(), publicacao, PublicacaoRetorno.class);
    }

}
