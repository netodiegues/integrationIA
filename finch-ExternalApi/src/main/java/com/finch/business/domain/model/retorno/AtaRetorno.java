package com.finch.business.domain.model.retorno;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author jose.diegues
 */
public class AtaRetorno implements Serializable {

    private Long idSolicitacao;

    private Boolean retorno;

    private String mensagem;

    private List<NumeroProcesso> numeroProcesso;

    private ResultadoEnum resultado;

    private BigDecimal confianca;

    public AtaRetorno() {
    }

    public AtaRetorno(Long idSolicitacao, Boolean retorno, String mensagem, List<NumeroProcesso> numeroProcesso, ResultadoEnum resultado, BigDecimal confianca) {
        this.idSolicitacao = idSolicitacao;
        this.retorno = retorno;
        this.mensagem = mensagem;
        this.numeroProcesso = numeroProcesso;
        this.resultado = resultado;
        this.confianca = confianca;
    }

    public Long getIdSolicitacao() {
        return idSolicitacao;
    }

    public void setIdSolicitacao(Long idSolicitacao) {
        this.idSolicitacao = idSolicitacao;
    }

    public Boolean getRetorno() {
        return retorno;
    }

    public void setRetorno(Boolean retorno) {
        this.retorno = retorno;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public List<NumeroProcesso> getNumeroProcesso() {
        return numeroProcesso;
    }

    public void setNumeroProcesso(List<NumeroProcesso> numeroProcesso) {
        this.numeroProcesso = numeroProcesso;
    }

    public ResultadoEnum getResultado() {
        return resultado;
    }

    public void setResultado(ResultadoEnum resultado) {
        this.resultado = resultado;
    }

    public BigDecimal getConfianca() {
        return confianca;
    }

    public void setConfianca(BigDecimal confianca) {
        this.confianca = confianca;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.idSolicitacao);
        hash = 59 * hash + Objects.hashCode(this.retorno);
        hash = 59 * hash + Objects.hashCode(this.mensagem);
        hash = 59 * hash + Objects.hashCode(this.numeroProcesso);
        hash = 59 * hash + Objects.hashCode(this.resultado);
        hash = 59 * hash + Objects.hashCode(this.confianca);
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
        final AtaRetorno other = (AtaRetorno) obj;
        if (!Objects.equals(this.mensagem, other.mensagem)) {
            return false;
        }
        if (!Objects.equals(this.idSolicitacao, other.idSolicitacao)) {
            return false;
        }
        if (!Objects.equals(this.retorno, other.retorno)) {
            return false;
        }
        if (!Objects.equals(this.numeroProcesso, other.numeroProcesso)) {
            return false;
        }
        if (this.resultado != other.resultado) {
            return false;
        }
        return Objects.equals(this.confianca, other.confianca);
    }

    @Override
    public String toString() {
        return "Ata{" + "idSolicitacao=" + idSolicitacao + ", Retorno=" + retorno + ", Mensagem=" + mensagem + ", NumeroProcesso=" + numeroProcesso + ", Resultado=" + resultado + ", Confianca=" + confianca + '}';
    }

}
