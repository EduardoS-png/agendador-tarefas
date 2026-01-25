package com.eduardo.agendadortarefas.controller;

import com.eduardo.agendadortarefas.business.TarefasService;
import com.eduardo.agendadortarefas.business.dto.TarefasDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/tarefas")
@RequiredArgsConstructor
public class TarefasController {

    private final TarefasService tarefasService;

    @PostMapping
    public ResponseEntity<TarefasDTO> criarTarefas(@RequestBody TarefasDTO dto, @RequestHeader("Authorization") String token) {
        return ResponseEntity.ok(tarefasService.gravarTarefa(token, dto));
    }

    @GetMapping("/eventos")
    public ResponseEntity<List<TarefasDTO>> buscaListaDeTarefasPorPeriodo(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataInicio,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataFinal
            ) {
        List<TarefasDTO> tarefas = tarefasService.buscaTarefasAgendadasPorPeriodo(dataInicio, dataFinal);

        return ResponseEntity.ok(tarefas);
    }

    @GetMapping
    public ResponseEntity<List<TarefasDTO>> buscaTarefasPorEmail(@RequestHeader("Authorization") String token) {
        List<TarefasDTO> tarefas = tarefasService.buscaTarefasPorEmail(token);

        return ResponseEntity.ok(tarefas);
    }
}
