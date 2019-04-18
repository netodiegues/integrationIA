package com.finch.wrapper.domain.model.publicacao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author jose.diegues
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Publicacao implements Serializable {

    private Long id;

    private Long id_Publicacao;

    private String textoPublicacao;

    private String uf;

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
        hash = 11 * hash + Objects.hashCode(this.id);
        hash = 11 * hash + Objects.hashCode(this.id_Publicacao);
        hash = 11 * hash + Objects.hashCode(this.textoPublicacao);
        hash = 11 * hash + Objects.hashCode(this.uf);
        hash = 11 * hash + Objects.hashCode(this.sistema);
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
        if (!Objects.equals(this.id_Publicacao, other.id_Publicacao)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Publicacao{" + "id=" + id + ", id_Publicacao=" + id_Publicacao + ", textoPublicacao=" + textoPublicacao + ", uf=" + uf + ", sistema=" + sistema + '}';
    }

    
    
}
