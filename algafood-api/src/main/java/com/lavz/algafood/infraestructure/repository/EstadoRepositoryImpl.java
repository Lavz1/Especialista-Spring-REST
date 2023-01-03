package com.lavz.algafood.infraestructure.repository;

import com.lavz.algafood.domain.model.Estado;
import com.lavz.algafood.domain.repository.CidadeRepository;
import com.lavz.algafood.domain.repository.EstadoRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class EstadoRepositoryImpl implements EstadoRepository {


    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Estado> todos() {
        TypedQuery<Estado> query =  entityManager.createQuery("from Estado", Estado.class);

        return query.getResultList();
    }

    @Transactional
    @Override
    public Estado adicionar(Estado estado) {
        return entityManager.merge(estado);
    }

    @Override
    public Estado porId(Long id) {
        return entityManager.find(Estado.class, id);
    }

    @Transactional
    @Override
    public void remover(Estado estado){
        estado = porId(estado.getId());

        if (estado == null) {
            System.out.println("Não existe estado com o ID informado");
            return;
        }

        entityManager.remove(estado);
        System.out.printf("Estado %s excluído com sucesso", estado.getNome());
    }
}
