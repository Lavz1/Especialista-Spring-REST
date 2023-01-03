package com.lavz.algafood.domain.repository;

import com.lavz.algafood.domain.model.FormaPagamento;

import java.util.List;

public interface FormaPagamentoRepository {

    List<FormaPagamento> todos();
    FormaPagamento porId(Long id);
    FormaPagamento adicionar(FormaPagamento formaPagamento);
    void remover(FormaPagamento formaPagamento);


}
