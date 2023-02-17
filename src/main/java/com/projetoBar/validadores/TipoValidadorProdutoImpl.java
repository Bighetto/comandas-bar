package com.projetoBar.validadores;

import com.projetoBar.enums.TipoProdutoEnum;
import com.projetoBar.model.ProdutoModel;
import com.projetoBar.repository.ProdutoRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TipoValidadorProdutoImpl implements TipoValidadorProduto {
    @Override
    public List<ProdutoModel> validadorDoTipo(String tiposGenericosEnum, ProdutoRepository repository) {

        List<ProdutoModel> lista =  repository.selecionarPeloTipo(tiposGenericosEnum);

//            return lista.stream().filter( p -> p.getTiposGenericos().equalsIgnoreCase(tiposGenericosEnum)).collect(Collectors.toList());

        return lista;

    }
}
