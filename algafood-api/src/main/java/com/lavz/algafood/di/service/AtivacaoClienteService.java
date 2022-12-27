package com.lavz.algafood.di.service;

import com.lavz.algafood.di.modelo.Cliente;
import com.lavz.algafood.di.notificacao.NivelUrgencia;
import com.lavz.algafood.di.notificacao.Notificador;
import com.lavz.algafood.di.notificacao.TipoDoNotificador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AtivacaoClienteService {

    @Autowired(required = false)
    @TipoDoNotificador(NivelUrgencia.NAO_URGENTE)
    private Notificador notificador;

    public void ativar(Cliente cliente) {
        cliente.ativar();

        notificador.notificar(cliente, "Seu cadastro no sistema está ativo!");
    }
}
