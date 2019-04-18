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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author jose.diegues
 */
@Entity
@Table(name = "ataarquivo")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class AtaArquivo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonIgnore
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ata_id")
    @JsonIgnore    
    private Ata ata;

    @Column(name = "ata_link_arquivo")
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
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.id);
        hash = 61 * hash + Objects.hashCode(this.ata);
        hash = 61 * hash + Objects.hashCode(this.arquivo);
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
        return "arquivo=" + arquivo;
    }

}
