package com.lavz.algafood;

import com.lavz.algafood.di.modelo.Cliente;
import com.lavz.algafood.di.service.AtivacaoClienteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class MeuPrimeiroController {

    private AtivacaoClienteService ativacaoClienteService;

    public MeuPrimeiroController(AtivacaoClienteService ativacaoClienteService) {
        this.ativacaoClienteService = ativacaoClienteService;
    }

    @GetMapping("/hello")
    @ResponseBody
    public String Hello() {

        Cliente joao = new Cliente("Joao", "joao@email.com", "34314134134");

        ativacaoClienteService.ativar(joao);
        return "Hello! bbb";
    }
}
