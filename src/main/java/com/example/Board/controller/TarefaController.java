package com.example.Board.controller;


import com.example.Board.model.TarefaModel;
import com.example.Board.service.TarefaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/tarefa")
public class TarefaController {
    private final TarefaService tarefaService;


    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    @PostMapping
    public TarefaModel criarTarefa(@RequestBody TarefaModel tarefa) {
        tarefa.setDataCriacao(LocalDateTime.now());
        return tarefaService.salvarTarefa(tarefa.getId(), tarefa);
    }

    @GetMapping
    public List<TarefaModel> listarTarefas() {
        return tarefaService.listarTarefas();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<TarefaModel>> buscarPorId(@PathVariable Long id) {
        Optional<TarefaModel> tarefa = tarefaService.buscarPorId(id);
        if (tarefa.isPresent()) {
            return ResponseEntity.ok(tarefa);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        }
    }

    @PutMapping(value = {"/id"})
    public ResponseEntity<TarefaModel> atualizarTarefa(@RequestBody TarefaModel tarefa){
        Optional<TarefaModel> tarefaOptional = tarefaService.buscarPorId(tarefa.getId());
        if (tarefaOptional.isPresent()){
            TarefaModel tarefaAtualizada = tarefaService.atualizarTarefa(tarefa.getId(), tarefa);
            return ResponseEntity.ok(tarefaAtualizada);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Void> deletarTarefa(@PathVariable Long id){
        if (tarefaService.buscarPorId(id).isPresent()){
            tarefaService.deletarTarefa(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }


}



