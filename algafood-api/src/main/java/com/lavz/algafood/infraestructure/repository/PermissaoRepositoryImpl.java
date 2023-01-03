package com.lavz.algafood.infraestructure.repository;

import com.lavz.algafood.domain.model.Permissao;
import com.lavz.algafood.domain.repository.EstadoRepository;
import com.lavz.algafood.domain.repository.PermissaoRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class PermissaoRepositoryImpl implements PermissaoRepository {


    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Permissao> todos() {
        TypedQuery<Permissao> query =  entityManager.createQuery("from Permissao", Permissao.class);

        return query.getResultList();
    }

    @Transactional
    @Override
    public Permissao adicionar(Permissao permissao) {
        return entityManager.merge(permissao);
    }

    @Override
    public Permissao porId(Long id) {
        return entityManager.find(Permissao.class, id);
    }

    @Transactional
    @Override
    public void remover(Permissao permissao){
        permissao = porId(permissao.getId());

        if (permissao == null) {
            System.out.println("Não existe permissao com o ID informado");
            return;
        }

        entityManager.remove(permissao);
        System.out.printf("Permissao %s excluído com sucesso", permissao.getNome());
    }
}
