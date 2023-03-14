package com.projetoBar.repository;

import com.projetoBar.model.ComandaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface ComandaRepository extends JpaRepository<ComandaModel, Integer> {

    @Query(value = "select * from comanda where idcomanda = :id",nativeQuery = true)
    ComandaModel selecionarPeloNumero(@Param("id") Integer id);


    @Query(value = "select * from comanda where status = \"ABERTO\" ;", nativeQuery = true)
    List<ComandaModel> listaDeComandasAbertas();

    @Query(value = "select * from comanda c where data_criacao = :dataCriacao ;",nativeQuery = true)
    List<ComandaModel> selecionarTodasAsComandasDoDia(@Param("dataCriacao") LocalDate dataCriacao);
}
