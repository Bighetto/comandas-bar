package com.projetoBar.repository;

import com.projetoBar.model.ProdutoModel;
import com.projetoBar.model.ProdutosNaComandaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Repository
public interface ProdutosNaComandaRepository extends JpaRepository<ProdutosNaComandaModel, Integer> {

    @Query(value = "select * from produtos_na_comanda where idcomanda = :idComanda ;", nativeQuery = true)
    List<ProdutosNaComandaModel> selecionarProdutosNaComanda(@Param("idComanda")Integer idComanda);

    @Query(value = "select SUM(valor_produto * quantidade) as valor_total  from produtos_na_comanda where idcomanda = :idcomanda ; ", nativeQuery = true)
    Double selecionarValorTotalComanda(@Param("idcomanda")Integer idComanda);


    @Transactional
    @Modifying
    @Query(value = "insert into produtos_na_comanda (idcomanda , nome_produto, valor_produto, quantidade, data_comanda) \n" +
            "values (:idcomanda, :nomeProduto, :valorProduto, :quantidade, :dataComanda);",nativeQuery = true)
    void inserirProdutoNaComanda(@Param("idcomanda")Integer idcomanda,
                                 @Param("nomeProduto")String nomeProduto,
                                 @Param("valorProduto")Double valorProduto,
                                 @Param("quantidade")Integer quantidade,
                                 @Param("dataComanda") Date dataComanda);

    @Query(value = "select * from produtos_na_comanda where nome_produto  = :nomeProduto ;", nativeQuery = true)
    ProdutosNaComandaModel selecionarPeloNome(@Param("nomeProduto")String nomeProduto);

    @Query(value = "select * from produtos_na_comanda where nome_produto  = :nomeProduto and data_comanda = :dataComanda and idcomanda = :idComanda ;", nativeQuery = true)
    ProdutosNaComandaModel selecionarSeJaExiste(@Param("nomeProduto")String nomeProduto,
                                                @Param("dataComanda")Date dataComanda,
                                                @Param("idComanda")Integer idComanda);


    @Transactional
    @Modifying
    @Query(value = "update produtos_na_comanda set quantidade = :quantidade where idcomanda = :idComanda and nome_produto = :nomeProduto and data_comanda = :dataComanda", nativeQuery = true)
    void atualizarValorQuantidade(@Param("quantidade")Integer quantidade,
                                  @Param("idComanda")Integer idComanda,
                                  @Param("nomeProduto")String nomeProduto,
                                  @Param("dataComanda")Date dataComanda);
}
