package com.example.Board.service;

import com.example.Board.model.TarefaModel;
import com.example.Board.repository.TarefaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TarefaService {
    private final TarefaRepository tarefaRepository;


    public TarefaService(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }

    public List<TarefaModel> listarTarefas() {
        return tarefaRepository.findAll();
    }

    public Optional<TarefaModel> buscarPorId(Long id) {
        return tarefaRepository.findById(id);
    }

    public TarefaModel salvarTarefa(Long id, TarefaModel tarefaModel) {
        return tarefaRepository.save(tarefaModel);
    }

    public TarefaModel atualizarTarefa(Long id, TarefaModel tarefaModel){
        return tarefaRepository.save(tarefaModel);
    }

    public void  deletarTarefa(Long id) {
        tarefaRepository.deleteById(id);
    }
}
