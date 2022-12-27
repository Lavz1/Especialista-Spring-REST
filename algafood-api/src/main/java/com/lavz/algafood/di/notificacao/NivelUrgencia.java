package com.lavz.algafood.di.notificacao;

public enum NivelUrgencia {

    URGENTE("Urgente"),
    NAO_URGENTE("Não urgente");

    private String descricao;

    NivelUrgencia(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
