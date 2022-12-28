package com.lavz.algafood.di.notificacao;

import com.lavz.algafood.di.modelo.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

//@Profile("prod")
@TipoDoNotificador(NivelUrgencia.NAO_URGENTE)
@Component
public class NotificadorEmail implements Notificador {

    private String email = "smtp@email.com";

    @Autowired
    private NotificadorProperties notificador;

   @Override
   public void notificar(Cliente cliente, String mensagem) {


       System.out.println("parametros: " + notificador.getHostServidor() + " " + notificador.getPortaServidor());

        System.out.printf("Notificando %s atraves do email %s e smtp %s: %s\n",
               cliente.getNome(), cliente.getEmail(), this.email, mensagem);
   }
}
