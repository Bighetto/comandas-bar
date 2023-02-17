package com.projetoBar.validadores;

import com.projetoBar.enums.TipoProdutoEnum;
import com.projetoBar.enums.TiposGenericosEnum;
import com.projetoBar.model.ProdutoModel;
import com.projetoBar.model.dto.ExibirProdutoDTO;
import com.projetoBar.repository.ProdutoRepository;

import java.util.List;

public interface TipoValidadorTipoGenerico {


    public List<ProdutoModel> validadorDoTipo(String produtoEnum, ProdutoRepository repository);


}
