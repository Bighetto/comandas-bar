package com.projetoBar.validadores;

import com.projetoBar.enums.TipoProdutoEnum;
import com.projetoBar.model.ProdutoModel;
import com.projetoBar.repository.ProdutoRepository;

import java.util.List;

public interface TipoValidadorProduto {


    public List<ProdutoModel> validadorDoTipo(String produtoEnum, ProdutoRepository repository);


}
