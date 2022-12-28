package com.lavz.algafood.di.service;

import com.lavz.algafood.di.modelo.Cliente;

public class ClienteAtivadoEvent {

    private Cliente cliente;

    ClienteAtivadoEvent(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }
}
