package com.finch.wrapper.domain.service.urlConfig;

import com.finch.wrapper.domain.model.urlconfig.UrlConfig;
import com.finch.wrapper.domain.model.restTemplate.RestResponsePage;
import com.finch.wrapper.infra.persistence.handler.RestClientExceptionHandler;
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
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

/**
 *
 * @author jose.diegues
 */
@Service
public class UrlConfigService {
    
    private Logger logger = LoggerFactory.getLogger(UrlConfigService.class);

    @Value("${finch.api-url.external}")
    private String URL;

    protected String getUrl() {
        return URL + "/urls";
    }

    private final RestTemplate restTemplate;

    public UrlConfigService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
        this.restTemplate.setInterceptors(Collections.singletonList(new JWTAuthenticationInterceptor()));
    }

    public List<UrlConfig> findAllUrlConfig(Pageable pageable) {

        ParameterizedTypeReference<RestResponsePage<UrlConfig>> responseType
                = new ParameterizedTypeReference<RestResponsePage<UrlConfig>>() {
        };

        URI targetUrl = UriComponentsBuilder.fromUriString(getUrl())
                .queryParam("page", pageable.getPageNumber())
                .queryParam("size", pageable.getPageSize())
                .queryParam("sort", pageable.getSort().isSorted() ? pageable.getSort() : null)
                .build()
                .toUri();

        ResponseEntity<RestResponsePage<UrlConfig>> result = this.restTemplate.exchange(targetUrl.toString().replaceAll(":%20", ","), HttpMethod.GET, null, responseType);
        List<UrlConfig> searchResult = result.getBody().getContent();
        return searchResult;

    }

    public UrlConfig findUrlConfigById(Long urlConfigId) {
        UrlConfig urlConfig = this.restTemplate.getForObject(getUrl() + "/{urlConfigId}", UrlConfig.class, urlConfigId);
        return urlConfig;
    }

    public UrlConfig createUrlConfig(UrlConfig urlConfig) throws Exception {
        return this.restTemplate.postForObject(getUrl(), urlConfig, UrlConfig.class);
    }

    public void updateUrlConfig(UrlConfig urlConfig, Long urlConfigId) throws Exception {
        try {
            restTemplate.put(getUrl() + "/{urlConfigId}", urlConfig, urlConfigId);
        } catch (HttpStatusCodeException e) {
            RestClientExceptionHandler restClientExceptionHandler = new RestClientExceptionHandler(e, getUrl(), "update");
        }
    }

    public void deleteUrlConfig(Long urlConfigId) throws Exception {
        try {
            restTemplate.delete(URL + "/{id}", urlConfigId);
        } catch (HttpStatusCodeException e) {
            RestClientExceptionHandler restClientExceptionHandler = new RestClientExceptionHandler(e, getUrl(), "delete");
        }
    }

}
