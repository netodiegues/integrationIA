package com.finch.wrapper.domain.model.retorno;

/**
 *
 * @author jose.diegues
 */
public enum ResultadoEnum {

    COM_PROVIDENCIA("Com Providência"),
    SEM_PROVIDENCIA("Sem Providência"),
    SENTENCA_EXTINCAO_EXECUCAO("Sentença De Extinção Da Execução (Art. 924)"),
    SENTENCA_EXTINCAO_SEM_JULGAMENTO_DE_MERITO("Sentença De Extinção Sem Julgamento De Mérito"),
    SENTENCA_HOMOLOGATORIA("Sentença Homologatória"),
    SENTENCA_IMPROCEDENTE("Sentença Improcedente"),
    SENTENCA_PROCEDENTE("Sentença Procedente"),
    
    ACORDO_EM_AUDIENCIA("ACORDO EM AUDIENCIA"),
    AUSENCIA_DO_AUTOR("AUSÊNCIA DO AUTOR"),
    AUTOR_DESISTIU_DO_PROCESSO("AUTOR DESISTIU DO PROCESSO"),
    AUTOS_CONCLUSOS("AUTOS CONCLUSOS"),
    DESIGNACAO_DE_AIJ("DESIGNAÇÃO DE AIJ"),
    LEITURA_DE_SENTENCA_DESIGNADA("LEITURA DE SENTENÇA DESIGNADA"),
    SENTENCA("SENTENÇA"),
    TEXTO_INELEGIVEL("TEXTO INELEGÍVEL");

    private String descricao;

    ResultadoEnum(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
