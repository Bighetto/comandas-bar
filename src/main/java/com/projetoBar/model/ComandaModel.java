package com.projetoBar.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Table(name = "comanda")
@Entity
@Data
public class ComandaModel {

    @Id
    @JsonProperty("idcomanda")
    @Column(name = "idcomanda")
    private Integer id;

    @Column(name = "data_criacao")
    @JsonProperty("dataCriacao")
    private LocalDate dataCriacao;

    @Column(name = "valor_total")
    @JsonProperty("valorTotal")
    private Double valorTotal;

    @Column(name = "status")
    @JsonProperty("status")
    private String status;

}
