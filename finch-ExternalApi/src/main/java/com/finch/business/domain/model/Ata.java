package com.finch.business.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author jose.diegues
 */
@Entity
@Table(name = "ata")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Ata implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonIgnore
    private Long id;

    @NotNull
    @Column(name = "id_solicitacao")
    private Long idSolicitacao;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ata")
    private List<AtaArquivo> arquivos;

    public Ata() {
    }

    public Ata(Ata ata) {
        this.id = ata.id;
        this.idSolicitacao = ata.idSolicitacao;
        this.arquivos = ata.arquivos;
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
        hash = 17 * hash + Objects.hashCode(this.id);
        hash = 17 * hash + Objects.hashCode(this.idSolicitacao);
        hash = 17 * hash + Objects.hashCode(this.arquivos);
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
        return "Ata{" + "id=" + id + ", idSolicitacao=" + idSolicitacao;
    }

}
