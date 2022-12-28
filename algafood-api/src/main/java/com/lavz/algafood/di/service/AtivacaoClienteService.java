package com.lavz.algafood.di.service;

import com.lavz.algafood.di.modelo.Cliente;
import com.lavz.algafood.di.notificacao.NivelUrgencia;
import com.lavz.algafood.di.notificacao.Notificador;
import com.lavz.algafood.di.notificacao.TipoDoNotificador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;

public class AtivacaoClienteService {

    @Autowired(required = false)
    @TipoDoNotificador(NivelUrgencia.NAO_URGENTE)
    private Notificador notificador;

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    public void init(){
        System.out.println("INIT");
    }

    public void destroy(){
        System.out.println("DESTROY");
    }

    public void ativar(Cliente cliente) {
        cliente.ativar();

        eventPublisher.publishEvent(new ClienteAtivadoEvent(cliente));
    }
}
