package com.lavz.algafood.domain.repository;

import com.lavz.algafood.domain.model.Permissao;

import java.util.List;

public interface PermissaoRepository {

    List<Permissao> todos();
    Permissao porId(Long id);
    Permissao adicionar(Permissao permissao);
    void remover(Permissao permissao);


}
