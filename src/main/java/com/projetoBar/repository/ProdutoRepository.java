package com.projetoBar.repository;

import com.projetoBar.model.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoModel, Integer> {

    @Query(value = "select * from produto where nome like '%' :nome '%' ;",nativeQuery = true)
    List<ProdutoModel> getByNome(@Param("nome") String nome);

    @Query(value = "select * from produto;",nativeQuery = true)
    List<ProdutoModel> selecionarTudo();

    @Query(value = "select * from produto where idproduto = :id ;", nativeQuery = true )
    ProdutoModel selecionarProdutoPeloId(@Param("id")Integer idProduto);

    @Transactional
    @Modifying
    @Query(value = "update produto set valor_de_venda = :valorDeVenda where nome= :nome ;",nativeQuery = true)
    void updateValorProduto(@Param("valorDeVenda")Double valorDeVenda,
                       @Param("nome")String nome);

//    @Modifying
//    @Transactional
//    @Query(value = "",nativeQuery = true)
//    void deleteProduct(@Param("nome") String nome);
}
