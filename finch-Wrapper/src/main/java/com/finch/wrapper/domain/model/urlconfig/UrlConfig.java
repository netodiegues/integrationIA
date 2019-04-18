package com.finch.wrapper.domain.model.urlconfig;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author jose.diegues
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UrlConfig implements Serializable {

    private Long id;
    private String urlAta;
    private String urlPublicacao;

    public UrlConfig() {
    }

    public UrlConfig(Long id, String urlAta, String urlPublicacao) {
        this.id = id;
        this.urlAta = urlAta;
        this.urlPublicacao = urlPublicacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrlAta() {
        return urlAta;
    }

    public void setUrlAta(String urlAta) {
        this.urlAta = urlAta;
    }

    public String getUrlPublicacao() {
        return urlPublicacao;
    }

    public void setUrlPublicacao(String urlPublicacao) {
        this.urlPublicacao = urlPublicacao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
        hash = 97 * hash + Objects.hashCode(this.urlAta);
        hash = 97 * hash + Objects.hashCode(this.urlPublicacao);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final UrlConfig other = (UrlConfig) obj;
        if (!Objects.equals(this.urlAta, other.urlAta)) {
            return false;
        }
        if (!Objects.equals(this.urlPublicacao, other.urlPublicacao)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "UrlConfig{" + "id=" + id + ", urlAta=" + urlAta + ", urlPublicacao=" + urlPublicacao + '}';
    }

}
