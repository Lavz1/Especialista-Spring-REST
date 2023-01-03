package com.lavz.algafood.domain.repository;

import com.lavz.algafood.domain.model.Cidade;

import java.util.List;

public interface CidadeRepository {

    List<Cidade> todos();
    Cidade porId(Long id);
    Cidade adicionar(Cidade cidade);
    void remover(Cidade cidade);


}
