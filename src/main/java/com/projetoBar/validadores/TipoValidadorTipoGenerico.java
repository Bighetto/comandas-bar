package com.projetoBar.validadores;

import com.projetoBar.model.ProdutoModel;
import com.projetoBar.repository.ProdutoRepository;

import java.util.List;

public interface TipoValidadorTipoGenerico {


    public List<ProdutoModel> validadorDoTipo(String produtoEnum, ProdutoRepository repository);


}
