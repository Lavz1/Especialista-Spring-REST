package com.lavz.algafood.di.notificacao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties("notificador.email")
@Component
public class NotificadorProperties {

    /**
     * Configuracao do host do servidor
     */
    private String hostServidor;

    /**
     * configuracao da porta do servidor
     */
    private Integer portaServidor = 8082;

    public String getHostServidor() {
        return hostServidor;
    }

    public void setHostServidor(String hostServidor) {
        this.hostServidor = hostServidor;
    }

    public Integer getPortaServidor() {
        return portaServidor;
    }

    public void setPortaServidor(Integer portaServidor) {
        this.portaServidor = portaServidor;
    }
}
