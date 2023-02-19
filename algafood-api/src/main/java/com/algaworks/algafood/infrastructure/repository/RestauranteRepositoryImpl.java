package com.algaworks.algafood.infrastructure.repository;

import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.RestauranteRepository;
import com.algaworks.algafood.domain.repository.RestauranteRepositoryQueries;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static com.algaworks.algafood.infrastructure.repository.spec.RestauranteSpecs.*;

@Repository
public class RestauranteRepositoryImpl implements RestauranteRepositoryQueries {

    @PersistenceContext
    EntityManager entityManager;

    @Autowired @Lazy
    RestauranteRepository restauranteRepository;

    @Override
    public List<Restaurante> find(String nome, BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal) {

//        StringBuilder query = new StringBuilder("from Restaurante where 0 = 0 ");
//        Map<String, Object> parametros = new HashMap<>();
//
//        if (StringUtils.hasLength(nome)) {
//            query.append("and nome like :nome ");
//            parametros.put("nome", "%" + nome + "%");
//        }
//
//        if (taxaFreteInicial != null) {
//            query.append("and taxaFrete >= :taxaFreteInicial ");
//            parametros.put("taxaFreteInicial", taxaFreteInicial);
//        }
//
//        if (taxaFreteFinal != null) {
//            query.append("and taxaFrete <= :taxaFreteFinal ");
//            parametros.put("taxaFreteFinal", taxaFreteFinal);
//        }
//
//        TypedQuery<Restaurante> typedQuery = entityManager.createQuery(query.toString(), Restaurante.class);
//
//        parametros.forEach((chave, valor) -> typedQuery.setParameter(chave, valor));
//
//        return typedQuery.getResultList();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Restaurante> criteria = builder.createQuery(Restaurante.class);
        Root<Restaurante> root =  criteria.from(Restaurante.class); // from Restaurantes

        List<Predicate> predicates = new ArrayList<>();

        Predicate defaultQuery = builder.equal(builder.literal(0),0 );
        predicates.add(defaultQuery);

        if(StringUtils.hasLength(nome))
            predicates.add(builder.like(root.get("nome"), "%" + nome + "%"));

        if (taxaFreteInicial != null)
            predicates.add(builder.greaterThanOrEqualTo(root.get("taxaFrete"), taxaFreteInicial));

        if (taxaFreteFinal != null)
            predicates.add(builder.lessThanOrEqualTo(root.get("taxaFrete"), taxaFreteFinal));

        criteria.where(predicates.toArray(new Predicate[0]));

        TypedQuery<Restaurante> query= entityManager.createQuery(criteria);

        return query.getResultList();
    }


    public List<Restaurante> findComFreteGratis(String nome) {
        return restauranteRepository.findAll(comFreteGratis().and(comNomeSemelhante(nome)));
    }
}
