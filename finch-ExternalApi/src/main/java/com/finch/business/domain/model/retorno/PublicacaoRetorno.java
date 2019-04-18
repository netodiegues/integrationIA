package com.finch.business.domain.model.retorno;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author jose.diegues
 */
public class PublicacaoRetorno implements Serializable {

    private Long idPublicacao;

    private Boolean retorno;

    private String mensagem;

    private List<NumeroProcesso> numeroProcesso;

    private ResultadoEnum resultado;

    private BigDecimal confianca;

    public PublicacaoRetorno() {
    }

    public PublicacaoRetorno(Long idPublicacao, Boolean retorno, String mensagem, List<NumeroProcesso> numeroProcesso, ResultadoEnum resultado, BigDecimal confianca) {
        this.idPublicacao = idPublicacao;
        this.retorno = retorno;
        this.mensagem = mensagem;
        this.numeroProcesso = numeroProcesso;
        this.resultado = resultado;
        this.confianca = confianca;
    }

    public Long getIdPublicacao() {
        return idPublicacao;
    }

    public void setIdPublicacao(Long idPublicacao) {
        this.idPublicacao = idPublicacao;
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
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.idPublicacao);
        hash = 37 * hash + Objects.hashCode(this.retorno);
        hash = 37 * hash + Objects.hashCode(this.mensagem);
        hash = 37 * hash + Objects.hashCode(this.numeroProcesso);
        hash = 37 * hash + Objects.hashCode(this.resultado);
        hash = 37 * hash + Objects.hashCode(this.confianca);
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
        final PublicacaoRetorno other = (PublicacaoRetorno) obj;
        if (!Objects.equals(this.mensagem, other.mensagem)) {
            return false;
        }
        if (!Objects.equals(this.numeroProcesso, other.numeroProcesso)) {
            return false;
        }
        if (!Objects.equals(this.idPublicacao, other.idPublicacao)) {
            return false;
        }
        if (!Objects.equals(this.retorno, other.retorno)) {
            return false;
        }
        if (this.resultado != other.resultado) {
            return false;
        }
        return Objects.equals(this.confianca, other.confianca);
    }

    @Override
    public String toString() {
        return "Publicacao{" + "IdPublicacao=" + idPublicacao + ", Retorno=" + retorno + ", Mensagem=" + mensagem + ", NumeroProcesso=" + numeroProcesso + ", Resultado=" + resultado + ", Confianca=" + confianca + '}';
    }

}
