package com.projetoBar;

import com.projetoBar.model.ComandaModel;
import com.projetoBar.service.ComandaService;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Testable
public class testeAberturaComanda {

    private ComandaService comandaService;

    @Test
    void criacaoDeNovaComanda(){

        ComandaModel novaComanda = comandaService.aberturaDeComanda();

        System.out.println(novaComanda);

        assertEquals(1, novaComanda.getId());
    }



}
