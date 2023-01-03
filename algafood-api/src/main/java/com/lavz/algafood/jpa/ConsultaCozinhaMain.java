package com.lavz.algafood.jpa;

import com.lavz.algafood.AlgafoodApiApplication;
import com.lavz.algafood.domain.model.Cozinha;
import com.lavz.algafood.domain.repository.CozinhaRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.util.List;

public class ConsultaCozinhaMain {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        CozinhaRepository cozinhas = applicationContext.getBean(CozinhaRepository.class);

        List<Cozinha> todasCozinhas = cozinhas.todas();

        todasCozinhas.forEach(System.out::println);

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
