package com.projetoBar.controller;

import com.projetoBar.model.ComandaModel;
import com.projetoBar.service.ComandaService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class ComandaController {

    private final ComandaService comandaService;



    @PostMapping(path = "/abrirComanda")
    public ResponseEntity<String>abrirComanda(){

        ComandaModel comanda = comandaService.aberturaDeComanda();

        return ResponseEntity.ok("Abertura de comanda realizada! numero da comanda: " + comanda.getId().toString());
    }



    @PostMapping(path = "fecharComanda/{idComanda}")
    public ResponseEntity<String>fechamentoDeComanda(@PathVariable Integer idComanda){

        comandaService.fechamentoDeComanda(idComanda);



        return ResponseEntity.ok("Comanda: " + idComanda + "fechada com sucesso!");

    }







}
