package com.projetoBar.controller;

import com.projetoBar.model.ProdutosNaComandaModel;
import com.projetoBar.model.dto.ProdutoDTO;
import com.projetoBar.service.ProdutosNaComandaService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin
public class ProdutosNaComandaController {

    private final ProdutosNaComandaService produtosNaComandaService;


    @GetMapping(path = "/produtosNaComanda/{idComanda}")
    public ResponseEntity<List<ProdutosNaComandaModel>> produtosNaComanda(@PathVariable Integer idComanda){

        List<ProdutosNaComandaModel>listaDeProdutos =  produtosNaComandaService.listaDeProdutosNaComanda(idComanda);

        return ResponseEntity.ok(listaDeProdutos);

    }

    @PostMapping(path = "/inserirProdutoNaComanda/{idComanda}/quantidade/{quantidadeProduto}/nome/{nomeProduto}")
    public ResponseEntity<String>inserirProdutoNaComanda(@PathVariable String nomeproduto, @PathVariable Integer idComanda, @PathVariable Integer quantidadeProduto){


        produtosNaComandaService.adicionarProduto(idComanda, nomeproduto, quantidadeProduto);

        return ResponseEntity.ok("Produto: " + nomeproduto + " adicionado com sucesso na comanda: " + idComanda);

    }
}
