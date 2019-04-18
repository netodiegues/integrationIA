package com.finch.business.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "publicacao")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Publicacao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonIgnore
    private Long id;

    @NotNull
    @Column(name = "id_publicacao")
    private Long id_Publicacao;

    @NotNull
    @Column(name = "texto_publicacao")
    private String textoPublicacao;

    @NotNull
    @Length(min = 0, max = 2)
    @Column(name = "uf")
    private String uf;

    @NotNull
    @Length(min = 0, max = 10)
    @Column(name = "sistema")
    private String sistema;

    public Publicacao() {
    }

    public Publicacao(Long id, Long id_Publicacao, String textoPublicacao, String uf, String sistema) {
        this.id = id;
        this.id_Publicacao = id_Publicacao;
        this.textoPublicacao = textoPublicacao;
        this.uf = uf;
        this.sistema = sistema;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_Publicacao() {
        return id_Publicacao;
    }

    public void setId_Publicacao(Long id_Publicacao) {
        this.id_Publicacao = id_Publicacao;
    }

    public String getTextoPublicacao() {
        return textoPublicacao;
    }

    public void setTextoPublicacao(String textoPublicacao) {
        this.textoPublicacao = textoPublicacao;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getSistema() {
        return sistema;
    }

    public void setSistema(String sistema) {
        this.sistema = sistema;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.id);
        hash = 83 * hash + Objects.hashCode(this.id_Publicacao);
        hash = 83 * hash + Objects.hashCode(this.textoPublicacao);
        hash = 83 * hash + Objects.hashCode(this.uf);
        hash = 83 * hash + Objects.hashCode(this.sistema);
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
        final Publicacao other = (Publicacao) obj;
        if (!Objects.equals(this.textoPublicacao, other.textoPublicacao)) {
            return false;
        }
        if (!Objects.equals(this.uf, other.uf)) {
            return false;
        }
        if (!Objects.equals(this.sistema, other.sistema)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return Objects.equals(this.id_Publicacao, other.id_Publicacao);
    }

    @Override
    public String toString() {
        return "Publicacao{" + "id=" + id + ", id_Publicacao=" + id_Publicacao + ", textoPublicacao=" + textoPublicacao + ", uf=" + uf + ", sistema=" + sistema + '}';
    }

}
