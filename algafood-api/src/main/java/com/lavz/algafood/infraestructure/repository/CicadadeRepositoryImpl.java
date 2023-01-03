package com.lavz.algafood.infraestructure.repository;

import com.lavz.algafood.domain.model.Cidade;
import com.lavz.algafood.domain.repository.CidadeRepository;
import com.lavz.algafood.domain.repository.RestauranteRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class CicadadeRepositoryImpl implements CidadeRepository {


    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Cidade> todos() {
        TypedQuery<Cidade> query =  entityManager.createQuery("from Cidade", Cidade.class);

        return query.getResultList();
    }

    @Transactional
    @Override
    public Cidade adicionar(Cidade cidade) {
        return entityManager.merge(cidade);
    }

    @Override
    public Cidade porId(Long id) {
        return entityManager.find(Cidade.class, id);
    }

    @Transactional
    @Override
    public void remover(Cidade cidade){
        cidade = porId(cidade.getId());

        if (cidade == null) {
            System.out.println("Não existe cidade com o ID informado");
            return;
        }

        entityManager.remove(cidade);
        System.out.printf("Cidade %s excluído com sucesso", cidade.getNome());
    }
}
