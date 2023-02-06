package com.projetoBar.validadores;

import com.projetoBar.enums.TipoProdutoEnum;
import com.projetoBar.model.ProdutoModel;
import com.projetoBar.repository.ProdutoRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TipoValidadorImpl implements TipoValidador {
    @Override
    public List<ProdutoModel> validadorDoTipo(TipoProdutoEnum produtoEnum, ProdutoRepository repository) {

            List<ProdutoModel> lista =  repository.selecionarTudo();

            return lista.stream().filter( p -> p.getTipo() == produtoEnum).collect(Collectors.toList());

    }
}
