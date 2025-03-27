package com.example.Board.model;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;


@Data
@Entity
@Table(name = "tb_tarefas")
public class TarefaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    private String titulo;

    @Column(length = 1200)
    private String descricao;

    @Column(length = 20)
    private String status;

    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao;

}
