package com.projetoBar.repository;

import com.projetoBar.model.ProdutosNaComandaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface ProdutosNaComandaRepository extends JpaRepository<ProdutosNaComandaModel, Integer> {

    @Query(value = "select SUM(valor_produto * quantidade_produto) as valor_total  from comanda where idcomanda = :idcomanda; ", nativeQuery = true)
    Integer selecionarValorTotalComanda(@Param("idcomanda")Integer idComanda);

    @Transactional
    @Modifying
    @Query(value = "insert into produtos_na_comanda (idcomanda, valor_produto, nome_produto, quantidade) \n" +
            "values (:idcomanda, :valorProduto, :nomeProduto, :quantidade);",nativeQuery = true)
    void inserirProduto(@Param("idcomanda")Integer idComanda,
                        @Param("valorProduto")Double valorProduto,
                        @Param("nomeProduto")String nomeProduto,
                        @Param("quantidade")Integer quantidade);

}
