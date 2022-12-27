package com.lavz.algafood.di.notificacao;

import com.lavz.algafood.di.modelo.Cliente;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("dev")
@TipoDoNotificador(NivelUrgencia.NAO_URGENTE)
@Component
public class NotificadorEmailMock implements Notificador {

    private String email = "smtp@email.com";

   @Override
   public void notificar(Cliente cliente, String mensagem) {

        System.out.printf("MOCK: Notificacao seria enviada para %s atraves do email %s e smtp %s: %s\n",
               cliente.getNome(), cliente.getEmail(), this.email, mensagem);
   }
}
