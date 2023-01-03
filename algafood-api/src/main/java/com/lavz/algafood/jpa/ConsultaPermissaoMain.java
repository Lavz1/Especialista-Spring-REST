package com.lavz.algafood.jpa;

import com.lavz.algafood.AlgafoodApiApplication;
import com.lavz.algafood.domain.model.Cidade;
import com.lavz.algafood.domain.model.Permissao;
import com.lavz.algafood.domain.repository.CidadeRepository;
import com.lavz.algafood.domain.repository.PermissaoRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.util.List;

public class ConsultaPermissaoMain {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        PermissaoRepository permissaoRepository = applicationContext.getBean(PermissaoRepository.class);

        List<Permissao> todasPermissoes = permissaoRepository.todos();

        for (Permissao permissao : todasPermissoes) {
            System.out.printf("%s - %s\n", permissao.getNome(), permissao.getDescricao());
        }
    }
}
