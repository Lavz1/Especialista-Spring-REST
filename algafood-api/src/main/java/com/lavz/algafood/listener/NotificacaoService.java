package com.lavz.algafood.listener;


import com.lavz.algafood.di.notificacao.NivelUrgencia;
import com.lavz.algafood.di.notificacao.Notificador;
import com.lavz.algafood.di.notificacao.TipoDoNotificador;
import com.lavz.algafood.di.service.ClienteAtivadoEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class NotificacaoService {

    @TipoDoNotificador(NivelUrgencia.NAO_URGENTE)
    @Autowired
    Notificador notificador;

    @EventListener
    public void clienteAtivadoListener(ClienteAtivadoEvent event){
        notificador.notificar(event.getCliente(), "Cliente ativado com SUCESSO!");
    }
}
