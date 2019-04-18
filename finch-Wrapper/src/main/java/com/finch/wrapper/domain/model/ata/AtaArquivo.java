package com.finch.wrapper.domain.model.ata;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author jose.diegues
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AtaArquivo implements Serializable {

    @JsonIgnore
    private Long id;

    @JsonIgnore
    private Ata ata;

    private String arquivo;

    public AtaArquivo() {
    }

    public AtaArquivo(Long id, Ata ata, String arquivo) {
        this.id = id;
        this.ata = ata;
        this.arquivo = arquivo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Ata getAta() {
        return ata;
    }

    public void setAta(Ata ata) {
        this.ata = ata;
    }

    public String getArquivo() {
        return arquivo;
    }

    public void setArquivo(String arquivo) {
        this.arquivo = arquivo;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 73 * hash + Objects.hashCode(this.id);
        hash = 73 * hash + Objects.hashCode(this.ata);
        hash = 73 * hash + Objects.hashCode(this.arquivo);
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
        final AtaArquivo other = (AtaArquivo) obj;
        if (!Objects.equals(this.arquivo, other.arquivo)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return Objects.equals(this.ata, other.ata);
    }

    @Override
    public String toString() {
        return "AtaArquivo{" + "id=" + id + ", ata=" + ata + ", arquivo=" + arquivo + '}';
    }

}
