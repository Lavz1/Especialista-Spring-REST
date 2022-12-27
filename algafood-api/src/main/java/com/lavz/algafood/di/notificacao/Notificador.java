package com.lavz.algafood.di.notificacao;

import com.lavz.algafood.di.modelo.Cliente;
import org.springframework.stereotype.Component;

public interface Notificador {
    void notificar(Cliente cliente, String mensagem);
}
