package com.projetoBar.repository;

import com.projetoBar.enums.StatusEnum;
import com.projetoBar.model.ComandaModel;
import com.projetoBar.model.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.List;

@Repository
public interface ComandaRepository extends JpaRepository<ComandaModel, Integer> {

    @Query(value = "select * from comanda where idcomanda = :id",nativeQuery = true)
    ComandaModel selecionarPeloNumero(@Param("id") Integer id);


    @Transactional
    @Modifying
    @Query(value = "insert into comanda (fk_idproduto, data_criacao, nome_produto, valor_produto, quantidade_produto, status) \n" +
            "values (:idProduto,:dataCriacao, :nomeProduto, :valorProduto, :quantidade, :status);",nativeQuery = true)
    void inserirProdutoNaComanda(@Param("idProduto")Integer idProduto,
                                 @Param("dataCriacao") Timestamp dataCriacao,
                                 @Param("nomeProduto")String nomeProduto,
                                 @Param("valorProduto")Double valorProduto,
                                 @Param("quantidade")Integer quantidade,
                                 @Param("status")String status);


    @Query(value = "select * from comanda where idcomanda = :idComanda;", nativeQuery = true)
    List<ProdutoModel>selecionarProdutosNaComanda(@Param("idComanda")Integer idComanda);

//    @Modifying
//    @Transactional
//    @Query(value = "",nativeQuery = true)
//    void deleteProduct(@Param("id") String nome);
}
