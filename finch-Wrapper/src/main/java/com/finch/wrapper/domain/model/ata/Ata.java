package com.finch.wrapper.domain.model.ata;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author jose.diegues
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Ata implements Serializable {

    @JsonIgnore
    private Long id;

    private Long idSolicitacao;

    private List<AtaArquivo> arquivos;

    public Ata() {
    }

    public Ata(Long id, Long idSolicitacao, List<AtaArquivo> arquivos) {
        this.id = id;
        this.idSolicitacao = idSolicitacao;
        this.arquivos = arquivos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdSolicitacao() {
        return idSolicitacao;
    }

    public void setIdSolicitacao(Long idSolicitacao) {
        this.idSolicitacao = idSolicitacao;
    }

    public List<AtaArquivo> getArquivos() {
        return arquivos;
    }

    public void setArquivos(List<AtaArquivo> arquivos) {
        this.arquivos = arquivos;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.id);
        hash = 79 * hash + Objects.hashCode(this.idSolicitacao);
        hash = 79 * hash + Objects.hashCode(this.arquivos);
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
        final Ata other = (Ata) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.idSolicitacao, other.idSolicitacao)) {
            return false;
        }
        if (!Objects.equals(this.arquivos, other.arquivos)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Ata{" + "id=" + id + ", idSolicitacao=" + idSolicitacao + ", arquivos=" + arquivos + '}';
    }

}
