package com.finch.business.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author jose.diegues
 */
@Entity
@Table(name = "urlconfig")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class UrlConfig implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Length(min = 0, max = 100)
    @Column(name = "url_ata")
    private String urlAta;

    @NotNull
    @Length(min = 0, max = 100)
    @Column(name = "url_publicacao")
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
        hash = 13 * hash + Objects.hashCode(this.id);
        hash = 13 * hash + Objects.hashCode(this.urlAta);
        hash = 13 * hash + Objects.hashCode(this.urlPublicacao);
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
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "UrlConfig{" + "id=" + id + ", urlAta=" + urlAta + ", urlPublicacao=" + urlPublicacao + '}';
    }

}
