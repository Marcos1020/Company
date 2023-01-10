package com.Sanches.Company.controller;

import com.Sanches.Company.controller.request.FuncionarioRequest;
import com.Sanches.Company.controller.response.FuncionarioResponse;
import com.Sanches.Company.controller.response.UpdateResponse;
import com.Sanches.Company.entity.Funcionario;
import com.Sanches.Company.exception.ObjectAlreadyExists;
import com.Sanches.Company.exception.PreconditionFailedException;
import com.Sanches.Company.service.FuncionarioService;
import com.Sanches.Company.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

    private FuncionarioService service;
    @Autowired
    public FuncionarioController(FuncionarioService service){
        this.service =  service;
    }
    @PostMapping
    public ResponseEntity<FuncionarioResponse>novoFuncionario(
            @RequestBody FuncionarioRequest request)throws ObjectAlreadyExists{
        FuncionarioResponse response= this.service.cadastroDeNovoFuncionario(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    @PutMapping("{id}")
    public ResponseEntity<UpdateResponse>AtualizandoFuncionario(
            @PathVariable("id")Long idFuncionario,
            @RequestBody FuncionarioRequest request) throws PreconditionFailedException{
        UpdateResponse response = this.service.atualizarFuncionario(idFuncionario, request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String>deletandoFuncionario(
        @PathVariable("id")Long idFuncionario) throws PreconditionFailedException {
        this.service.deletaFuncionario(idFuncionario);
        return ResponseEntity.status(HttpStatus.OK).body(Constants.FUNCIONARIO_DELETADO);
    }
    @GetMapping("find-all")
    public List<Funcionario>buscaPorTodosFuncionarios()throws PreconditionFailedException {
        return service.findAll();
    }
    @GetMapping
    public List<Funcionario>BuscaFuncionarioPorNmoe(
            @RequestParam(name = "nome", required = false, value = "nome")final String nome,
            @RequestParam(name = "cpf", required = false, value = "cpf")final String cpf)throws PreconditionFailedException{
        return service.findByNome(nome, cpf);
    }
}