package com.lavz.algafood.infraestructure.repository;

import com.lavz.algafood.domain.model.FormaPagamento;
import com.lavz.algafood.domain.repository.FormaPagamentoRepository;
import com.lavz.algafood.domain.repository.PermissaoRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class FormaPagamentoRepositoryImpl implements FormaPagamentoRepository {


    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<FormaPagamento> todos() {
        TypedQuery<FormaPagamento> query =  entityManager.createQuery("from FormaPagamento", FormaPagamento.class);

        return query.getResultList();
    }

    @Transactional
    @Override
    public FormaPagamento adicionar(FormaPagamento formaPagamento) {
        return entityManager.merge(formaPagamento);
    }

    @Override
    public FormaPagamento porId(Long id) {
        return entityManager.find(FormaPagamento.class, id);
    }

    @Transactional
    @Override
    public void remover(FormaPagamento formaPagamento){
        formaPagamento = porId(formaPagamento.getId());

        if (formaPagamento == null) {
            System.out.println("Não existe formaPagamento com o ID informado");
            return;
        }

        entityManager.remove(formaPagamento);
        System.out.printf("FormaPagamento %s excluído com sucesso", formaPagamento.getDescricao());
    }
}
