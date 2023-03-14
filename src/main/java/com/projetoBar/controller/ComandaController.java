package com.projetoBar.controller;

import com.projetoBar.model.ComandaModel;
import com.projetoBar.model.dto.ExibirTudoNaComandaDTO;
import com.projetoBar.service.ComandaService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@CrossOrigin
public class ComandaController {

    private final ComandaService comandaService;



    @PostMapping(path = "/abrirComanda/{id}")
    public ResponseEntity<String>abrirComanda(@PathVariable Integer id){

        ComandaModel comanda = comandaService.aberturaDeComanda(id);

        return ResponseEntity.ok("Abertura de comanda realizada! numero da comanda: " + comanda.getId().toString());
    }

    @GetMapping(path = "/comandasAbertas")
    public ResponseEntity<List<ComandaModel>>ListaDeComandasAbertas(){

        List<ComandaModel> lista = comandaService.comandasAbertas();

        return ResponseEntity.ok(lista);

    }



    @PostMapping(path = "fecharComanda/{id}")
    public ResponseEntity<ExibirTudoNaComandaDTO>fechamentoDeComanda(@PathVariable Integer id){

        ExibirTudoNaComandaDTO fechamento = comandaService.fechamentoDeComanda(id);


        return ResponseEntity.ok(fechamento);

    }







}
