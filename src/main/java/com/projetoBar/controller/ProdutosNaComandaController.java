package com.projetoBar.controller;

import com.projetoBar.dto.ProdutosNaComandaDTO;
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
    public ResponseEntity<List<ProdutosNaComandaDTO>> produtosNaComanda(@PathVariable Integer idComanda){

        List<ProdutosNaComandaDTO>listaDeProdutos =  produtosNaComandaService.listaDeProdutosNaComanda(idComanda);

        return ResponseEntity.ok(listaDeProdutos);

    }

    @PostMapping(path = "/inserirProdutoNaComanda/{idComanda}/quantidade/{quantidadeProduto}/idProduto/{idProduto}")
    public ResponseEntity<ProdutosNaComandaDTO>inserirProdutoNaComanda(@PathVariable Integer idComanda, @PathVariable Integer quantidadeProduto, @PathVariable Integer idProduto){


        ProdutosNaComandaDTO produto = produtosNaComandaService.adicionarProduto(idComanda, quantidadeProduto, idProduto);

        return ResponseEntity.ok(produto);

    }

    @DeleteMapping(path = "/deletarProdutoNaComanda/idComanda{idComanda}/idProduto{idProduto}")
    public ResponseEntity<String> removerProdutoNaComanda(@PathVariable Integer idComanda, @PathVariable Integer idProduto){

        produtosNaComandaService.deletarProdutoNaComanda(idComanda, idProduto);


        return ResponseEntity.ok("Deletado com sucesso!");


    }
}
