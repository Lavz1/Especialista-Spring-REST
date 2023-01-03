package com.lavz.algafood.domain.repository;

import com.lavz.algafood.domain.model.Estado;

import java.util.List;

public interface EstadoRepository {

    List<Estado> todos();
    Estado porId(Long id);
    Estado adicionar(Estado estado);
    void remover(Estado estado);


}
