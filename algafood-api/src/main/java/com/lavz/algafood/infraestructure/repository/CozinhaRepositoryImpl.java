package com.lavz.algafood.infraestructure.repository;

import com.lavz.algafood.domain.model.Cozinha;
import com.lavz.algafood.domain.repository.CozinhaRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class CozinhaRepositoryImpl implements CozinhaRepository {


    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Cozinha> todas() {
        TypedQuery<Cozinha> query =  entityManager.createQuery("from Cozinha", Cozinha.class);

        return query.getResultList();
    }

    @Transactional
    @Override
    public Cozinha adicionar(Cozinha cozinha) {
        return entityManager.merge(cozinha);
    }

    @Override
    public Cozinha porId(Long id) {
        return entityManager.find(Cozinha.class, id);
    }

    @Transactional
    @Override
    public void remover(Cozinha cozinha){
        cozinha = porId(cozinha.getId());

        if (cozinha == null) {
            System.out.println("Não existe cozinha com o ID informado");
            return;
        }

        entityManager.remove(cozinha);
        System.out.printf("Cozinha %s excluída com sucesso", cozinha.getNome());
    }
}
