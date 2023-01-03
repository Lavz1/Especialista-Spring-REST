package com.lavz.algafood.jpa;

import com.lavz.algafood.AlgafoodApiApplication;
import com.lavz.algafood.domain.model.FormaPagamento;
import com.lavz.algafood.domain.model.Permissao;
import com.lavz.algafood.domain.repository.FormaPagamentoRepository;
import com.lavz.algafood.domain.repository.PermissaoRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.util.List;

public class ConsultaFormaPagamentoMain {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        FormaPagamentoRepository formaPagamentoRepository = applicationContext.getBean(FormaPagamentoRepository.class);

        List<FormaPagamento> todasFormasPagamentos = formaPagamentoRepository.todos();

        for (FormaPagamento formaPagamento : todasFormasPagamentos) {
            System.out.println(formaPagamento.getDescricao());
        }
    }
}
