package com.projetoBar.service;

import com.projetoBar.enums.TipoProdutoEnum;
import com.projetoBar.model.ProdutoModel;
import com.projetoBar.model.dto.ProdutoDTO;
import com.projetoBar.repository.ProdutoRepository;
import com.projetoBar.validadores.TipoValidador;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.projetoBar.validadores.TipoValidador.validadorDoTipo;

@Service
@AllArgsConstructor
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public List<ProdutoModel> getByNome(String nome){

        List<ProdutoModel> user = produtoRepository.getByNome(nome);

        return user;

    }

    public List<ProdutoModel> selecionarPeloTipo(TipoProdutoEnum produtoEnum){


        List<ProdutoModel> listaDeProdutos = validadorDoTipo(produtoEnum, produtoRepository);

        return listaDeProdutos;

    }

    public List<ProdutoModel> listarTudo(){

        List<ProdutoModel> produtos = produtoRepository.selecionarTudo();

        return produtos;
    }

    public Page<ProdutoModel> getList(Pageable paginacao){

        /* DEFINIR O PAGEREQUEST NA MAO COM PROPRIEDADES VINDO DO getList
        PageRequest paginacao = PageRequest.of(pagina, quantidade, Direction.ASC,ordenacao);//definir a requisicao da pagina, quantidade de itens e o numero dela
         */

        Page<ProdutoModel> user = produtoRepository.findAll(paginacao);//metodo findAll do JPA com paginacao ja incluso no Spring

        return user;

    }

    public ProdutoModel inserirProduto(ProdutoModel produtoModel) {

        produtoRepository.save(produtoModel);

        return produtoModel;

    }


    public ProdutoDTO atualizarValorProduto(ProdutoDTO produtoDTO){


        produtoRepository.updateValorProduto(produtoDTO.getValorDeVenda(),
                produtoDTO.getNome());

        return produtoDTO;

    }

    public String deletarProduto(Integer id){

        ProdutoModel produtoModel = produtoRepository.getById(id);

        produtoRepository.deleteById(id);

        String resposta = "Produto: " + produtoModel.toString() + "deletado com sucesso!";

        return resposta;
    }
}
