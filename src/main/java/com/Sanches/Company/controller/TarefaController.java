package com.Sanches.Company.controller;

import com.Sanches.Company.controller.request.TarefasRequest;
import com.Sanches.Company.controller.response.FinalizarTarefaResponse;
import com.Sanches.Company.controller.response.TarefaResponse;
import com.Sanches.Company.exception.ObjectAlreadyExists;
import com.Sanches.Company.exception.PreconditionFailedException;
import com.Sanches.Company.service.TarefaService;
import com.Sanches.Company.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/tarefas")
public class TarefaController {
    private TarefaService service;
    @Autowired
    public TarefaController(TarefaService service){
        this.service = service;
    }
    @PostMapping
    public ResponseEntity<TarefaResponse>cadastroDeNovaTarefa(
            @RequestBody TarefasRequest request) throws ObjectAlreadyExists{
       TarefaResponse response = this.service.CadastroDeNovaTarefa(request);
       return new ResponseEntity<>(response ,HttpStatus.CREATED);
    }
    @PutMapping("/finaliza/{id}")
    public ResponseEntity<FinalizarTarefaResponse>FinalizaTarefa(
            @PathVariable("id") Long idTarefa
            )throws PreconditionFailedException {
       final FinalizarTarefaResponse response = this.service.finalizaTarefa(idTarefa);
       return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @PutMapping("/alocar/{id}/funcionario")
    public ResponseEntity<String>alocarFuncionario(
            @PathVariable("id")Long idTarefa,
            @RequestBody TarefasRequest request) throws PreconditionFailedException{
        this.service.alocarFuncionarioNaTarefa(idTarefa, request);
        return ResponseEntity.status(HttpStatus.OK).body(Constants.FUNCIONARIO_ALOCADO_PARA_TAREFA);
    }
}
