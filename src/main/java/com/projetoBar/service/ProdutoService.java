package com.projetoBar.service;

import com.projetoBar.enums.TipoProdutoEnum;
import com.projetoBar.model.ProdutoModel;
import com.projetoBar.model.dto.ExibirProdutoDTO;
import com.projetoBar.model.dto.ProdutoDTO;
import com.projetoBar.repository.ProdutoRepository;
import com.projetoBar.validadores.TipoValidador;
import com.projetoBar.validadores.TipoValidadorImpl;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ProdutoService {

    private ProdutoRepository produtoRepository;
    private TipoValidadorImpl tipoValidador;

    public List<ExibirProdutoDTO> getByNome(String nome){

        List<ProdutoModel> produtos = produtoRepository.getByNome(nome);

        List<ExibirProdutoDTO> exibirProdutoDTOS = new ArrayList<>();

        for (ProdutoModel produtoModel: produtos){

            exibirProdutoDTOS.add(new ExibirProdutoDTO(produtoModel));
        }

        return exibirProdutoDTOS;

    }

    public List<ExibirProdutoDTO> selecionarPeloTipo(TipoProdutoEnum bebidaEnum){


        List<ProdutoModel> listaDeProdutos = tipoValidador.validadorDoTipo(bebidaEnum, produtoRepository);

        List<ExibirProdutoDTO> exibirProdutoDTOS = new ArrayList<>();

        for (ProdutoModel produtoModel: listaDeProdutos){

            exibirProdutoDTOS.add(new ExibirProdutoDTO(produtoModel));
        }

        return exibirProdutoDTOS;

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
