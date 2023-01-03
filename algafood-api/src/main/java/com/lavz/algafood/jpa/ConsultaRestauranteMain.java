package com.lavz.algafood.jpa;

import com.lavz.algafood.AlgafoodApiApplication;
import com.lavz.algafood.domain.model.Cozinha;
import com.lavz.algafood.domain.model.Restaurante;
import com.lavz.algafood.domain.repository.RestauranteRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.util.List;

public class ConsultaRestauranteMain {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        RestauranteRepository restaurantes = applicationContext.getBean(RestauranteRepository.class);

        List<Restaurante> todosRestaurantes = restaurantes.todos();

        for (Restaurante restaurante : todosRestaurantes) {
            System.out.printf("O restaurante %s de cozinha %s possui uma taxa frete de %f\n", restaurante.getNome(), restaurante.getCozinha().getNome(), restaurante.getTaxaFrete());
        }

       /* Cozinha cozinha1 = new Cozinha();
        cozinha1.setNome("Brasileira");

        Cozinha cozinha2 = new Cozinha();
        cozinha2.setId(5L);
        cozinha2.setNome("Americana");


        System.out.println(cadastroCozinha.adicionar(cozinha1));
        System.out.println(cadastroCozinha.adicionar(cozinha2));*/

//        System.out.println(cadastroCozinha.buscar(1L));

       /* Cozinha cozinha1 = new Cozinha();
        cozinha1.setId(1L);
        cozinha1.setNome("Brasileira");

        System.out.println(cadastroCozinha.salvar(cozinha1));*/

    }
}
