package com.projetoBar.controller;

import com.projetoBar.model.ComandaModel;
import com.projetoBar.dto.ExibirTudoNaComandaDTO;
import com.projetoBar.service.ComandaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@AllArgsConstructor
@CrossOrigin
public class ComandaController {

    private final ComandaService comandaService;



    @PostMapping(path = "/abrirComanda/{id}")
    public ResponseEntity<ComandaModel>abrirComanda(@PathVariable Integer id){

            ComandaModel comanda = comandaService.aberturaDeComanda(id);

                return ResponseEntity.ok(comanda);

    }

    @GetMapping(path = "/comandasAbertas")
    public ResponseEntity<List<ComandaModel>>ListaDeComandasAbertas(){

        try {
            List<ComandaModel> lista = comandaService.comandasAbertas();

            return ResponseEntity.ok(lista);
        }catch (Exception e){

            List<ComandaModel> lista = new ArrayList<>();
            ComandaModel objeto = new ComandaModel(404, LocalDate.now(),0.00,e.getMessage());
            lista.add(objeto);

            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(lista);

        }

    }



    @PostMapping(path = "fecharComanda/{id}")
    public ResponseEntity<ExibirTudoNaComandaDTO>fechamentoDeComanda(@PathVariable Integer id){

        ExibirTudoNaComandaDTO fechamento = comandaService.fechamentoDeComanda(id);


        return ResponseEntity.ok(fechamento);

    }

    @GetMapping(path = "/exibirFechamentoDeComanda/{id}")
    public ResponseEntity<ExibirTudoNaComandaDTO>exibirFechamentoDeComanda(@PathVariable Integer id){

        ExibirTudoNaComandaDTO fechamento = comandaService.exibirFechamentoDeComanda(id);

        return ResponseEntity.ok(fechamento);

    }







}
