package com.lavz.algafood.domain.controller;

import com.lavz.algafood.domain.repository.CozinhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Cozinhas {

    @Autowired
    CozinhaRepository cadastroCozinha;

    @GetMapping("/cozinhas")
    public void cozinhas(){
        System.out.println(cadastroCozinha.todas());
    }

}
