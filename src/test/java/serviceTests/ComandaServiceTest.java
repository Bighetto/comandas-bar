package serviceTests;


import com.projetoBar.model.ComandaModel;
import com.projetoBar.repository.ComandaRepository;
import com.projetoBar.service.ComandaService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class ComandaServiceTest {

    @Mock
    private ComandaService comandaService;
    @Mock
    private ComandaRepository comandaRepository;

    @Test
    public void deveRetornarListaDeComandasAbertas(){

        ComandaRepository comandaRepository = Mockito.mock(ComandaRepository.class);
        List<ComandaModel> lista = new ArrayList<>();
        LocalDate data = LocalDate.now();
        ComandaModel obj = new ComandaModel(1, data, 22.00, "ABERTO");
        lista.add(obj);
        lista.add(new ComandaModel(3, data, 66.00, "ABERTO"));
        when(comandaRepository.listaDeComandasAbertas()).thenReturn(lista);

        List<ComandaModel> result = comandaRepository.listaDeComandasAbertas();

        assertEquals(lista.size(), result.size());
        assertEquals(lista.get(0).getId(), result.get(0).getId());
        assertEquals(lista.get(0).getValorTotal(), result.get(0).getValorTotal());
        assertEquals(lista.get(1).getId(), result.get(1).getId());
        assertEquals(lista.get(1).getValorTotal(), result.get(1).getValorTotal());


    }

}
