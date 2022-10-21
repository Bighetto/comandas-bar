package com.projetoBar.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.projetoBar.enums.StatusEnum;
import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Table(name = "comanda")
@Entity
@Data
public class ComandaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("idcomanda")
    @Column(name = "idcomanda")
    private Integer id;

    @Column(name = "data_criacao")
    @JsonProperty("dataCriacao")
    private Timestamp dataCriacao;

    @Column(name = "valor_total")
    @JsonProperty("valorTotal")
    private Double valorTotal;

    @Column(name = "status")
    @JsonProperty("status")
    private String status;

}
