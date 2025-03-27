package com.example.Board.repository;

import com.example.Board.model.TarefaModel;
import com.example.Board.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TarefaRepository extends JpaRepository<TarefaModel, Long> {

}
