package com.lavz.algafood.infraestructure.repository;

import com.lavz.algafood.domain.model.Restaurante;
import com.lavz.algafood.domain.repository.RestauranteRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class RestauranteRepositoryImpl implements RestauranteRepository {


    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Restaurante> todos() {
        TypedQuery<Restaurante> query =  entityManager.createQuery("from Restaurante", Restaurante.class);

        return query.getResultList();
    }

    @Transactional
    @Override
    public Restaurante adicionar(Restaurante restaurante) {
        return entityManager.merge(restaurante);
    }

    @Override
    public Restaurante porId(Long id) {
        return entityManager.find(Restaurante.class, id);
    }

    @Transactional
    @Override
    public void remover(Restaurante restaurante){
        restaurante = porId(restaurante.getId());

        if (restaurante == null) {
            System.out.println("Não existe restaurante com o ID informado");
            return;
        }

        entityManager.remove(restaurante);
        System.out.printf("Restaurante %s excluído com sucesso", restaurante.getNome());
    }
}
