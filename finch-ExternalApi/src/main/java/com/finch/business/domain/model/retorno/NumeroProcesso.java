package com.finch.business.domain.model.retorno;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author jose.diegues
 */
public class NumeroProcesso implements Serializable {

    private String numero;

    public NumeroProcesso() {
    }

    public NumeroProcesso(String numero) {
        this.numero = numero;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.numero);
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
        final NumeroProcesso other = (NumeroProcesso) obj;
        if (!Objects.equals(this.numero, other.numero)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Numero:" + numero;
    }

}
