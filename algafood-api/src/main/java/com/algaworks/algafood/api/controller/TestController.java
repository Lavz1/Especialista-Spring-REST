package com.algaworks.algafood.api.controller;

import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.CozinhaRepository;
import com.algaworks.algafood.domain.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/teste")
public class TestController {

    @Autowired
    private CozinhaRepository cozinhaRepository;

    @Autowired
    private RestauranteRepository restauranteRepository;

//    @GetMapping("/cozinhas/por-nome")
//    public List<Cozinha> cozinhasPorNome(String nome) {
//        return cozinhaRepository.findTodasByNomeContaining(nome);
//    }
//
//    @GetMapping("/cozinhas/unica-por-nome")
//    public Optional<Cozinha> cozinhaPorNome(String nome) {
//        return cozinhaRepository.findByNome(nome);
//    }
//
//    @GetMapping("/cozinhas/exists")
//    public boolean cozinhaExists(String nome) {
//        return cozinhaRepository.existsByNome(nome);
//    }

    @GetMapping("/restaurantes/por-taxa-frete")
    public List<Restaurante> restaurantesPorTaxaFrete(
            BigDecimal taxaInicial, BigDecimal taxaFinal) {
        return restauranteRepository.queryByTaxaFreteBetween(taxaInicial, taxaFinal);
    }

    @GetMapping("/restaurantes/nome-taxa-frete")
    public List<Restaurante> restaurantesPorNomeETaxaFrete(@RequestParam(value = "nome", required = false) String nome, BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal) {

        return  restauranteRepository.find(nome, taxaFreteInicial, taxaFreteFinal);
    }

    @GetMapping("/restaurantes/por-nome")
    public List<Restaurante> restaurantesPorTaxaFrete(
            String nome, Long cozinhaId) {
        return restauranteRepository.findByNomeContainingAndCozinhaId(nome, cozinhaId);
    }

    @GetMapping("/restaurantes/primeiro-por-nome")
    public Optional<Restaurante> restaurantePrimeiroPorNome(String nome) {
        return restauranteRepository.findFirstRestauranteByNomeContaining(nome);
    }

    @GetMapping("/restaurantes/top2-por-nome")
    public List<Restaurante> restaurantesTop2PorNome(String nome) {
        return restauranteRepository.findTop2ByNomeContaining(nome);
    }

    @GetMapping("/restaurantes/count-por-cozinha")
    public int restaurantesCountPorCozinha(Long cozinhaId) {
        return restauranteRepository.countByCozinhaId(cozinhaId);
    }

    @GetMapping("/restaurantes/por-frete-gratis")
    public List<Restaurante> restaurantesPorFreteGratisENome(@RequestParam(required = false, name = "nome") String nome){
        return restauranteRepository.findComFreteGratis(nome);
    }

    @GetMapping("/restaurantes/primeiro")
    public Restaurante buscarPrimeiro(){
        return restauranteRepository.buscarPrimeiro().get();
    }

    @GetMapping("/cozinhas/primeiro")
    public Cozinha buscarPrimeira(){
        return cozinhaRepository.buscarPrimeiro().get();
    }
}


