package com.lavz.algafood.listener;


import com.lavz.algafood.di.notificacao.NivelUrgencia;
import com.lavz.algafood.di.notificacao.Notificador;
import com.lavz.algafood.di.notificacao.TipoDoNotificador;
import com.lavz.algafood.di.service.ClienteAtivadoEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EmissaoNotaFiscalService {

    @EventListener
    public void clienteAtivadoListener(ClienteAtivadoEvent event){
        System.out.println("Emitindo nota fiscal para o clinete: " + event.getCliente().getNome());
    }
}
