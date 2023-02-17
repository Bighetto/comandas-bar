package com.projetoBar.validadores;

import com.projetoBar.model.ProdutoModel;
import com.projetoBar.repository.ProdutoRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TipoValidadorGenericoImpl implements TipoValidadorProduto {
    @Override
    public List<ProdutoModel> validadorDoTipo(String tiposGenericosEnum, ProdutoRepository repository) {

        List<ProdutoModel> lista =  repository.selecionarPeloTipoGenerico(tiposGenericosEnum);

//            return lista.stream().filter( p -> p.getTiposGenericos().equalsIgnoreCase(tiposGenericosEnum)).collect(Collectors.toList());

        return lista;

    }
}
