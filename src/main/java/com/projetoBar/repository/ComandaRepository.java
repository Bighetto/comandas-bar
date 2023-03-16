package com.projetoBar.repository;

import com.projetoBar.model.ComandaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface ComandaRepository extends JpaRepository<ComandaModel, Integer> {


    @Query(value = "select * from comanda where idcomanda = :id and status = 'ABERTO' ;",nativeQuery = true)
    ComandaModel selecionarPeloNumeroEStatus(@Param("id") Integer id);

    @Transactional
    @Modifying
    @Query(value = "update comanda set valor_total = :valorTotal, status= 'FECHADO' where idcomanda = :id and status = 'ABERTO' ;",nativeQuery = true)
    void atualizarComandaAberta(@Param("valorTotal")Double valorTotal,
                                        @Param("id") Integer id);

    @Transactional
    @Modifying
    @Query(value = "insert into comanda (idcomanda, data_criacao, valor_total, status) VALUE (:id, :dataCriacao, 0.00, :status );",nativeQuery = true)
    void abrirComanda(@Param("id")Integer id,
                      @Param("dataCriacao")LocalDate dataCriacao,
                      @Param("status")String status);


    @Query(value = "select * from comanda where status = \"ABERTO\" ;", nativeQuery = true)
    List<ComandaModel> listaDeComandasAbertas();

    @Query(value = "select * from comanda c where data_criacao = :dataCriacao ;",nativeQuery = true)
    List<ComandaModel> selecionarTodasAsComandasDoDia(@Param("dataCriacao") LocalDate dataCriacao);
}
