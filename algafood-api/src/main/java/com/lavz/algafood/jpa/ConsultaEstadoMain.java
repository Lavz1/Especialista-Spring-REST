package com.lavz.algafood.jpa;

import com.lavz.algafood.AlgafoodApiApplication;
import com.lavz.algafood.domain.model.Estado;
import com.lavz.algafood.domain.repository.EstadoRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.util.List;

public class ConsultaEstadoMain {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        EstadoRepository estadoRepository = applicationContext.getBean(EstadoRepository.class);

        List<Estado> todosEstados = estadoRepository.todos();

        for (Estado estado : todosEstados) {
            System.out.printf("%s\n", estado.getNome());
        }
    }
}
