package com.lavz.algafood.di.notificacao;

import com.lavz.algafood.di.modelo.Cliente;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@TipoDoNotificador(NivelUrgencia.URGENTE)
@Component
public class NotificadorSMS implements Notificador {

    public NotificadorSMS() {
    }

   @Override
   public void notificar(Cliente cliente, String mensagem) {
       System.out.printf("Notificando %s atraves do SMS %s: %s\n",
               cliente.getNome(), cliente.getEmail(), mensagem);
   }
}
