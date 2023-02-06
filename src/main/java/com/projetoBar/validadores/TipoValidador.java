package com.projetoBar.validadores;

import com.projetoBar.enums.TipoProdutoEnum;
import com.projetoBar.model.ProdutoModel;
import com.projetoBar.repository.ProdutoRepository;

import java.util.List;
import java.util.stream.Collectors;

public interface TipoValidador {


    public List<ProdutoModel> validadorDoTipo(TipoProdutoEnum produtoEnum, ProdutoRepository repository);


}
