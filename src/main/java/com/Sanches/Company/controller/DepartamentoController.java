package com.Sanches.Company.controller;

import com.Sanches.Company.controller.request.DepartamentoRequest;
import com.Sanches.Company.controller.response.DepartamentosResponse;
import com.Sanches.Company.exception.ObjectAlreadyExists;
import com.Sanches.Company.service.DepartamentosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/departamentos")
public class DepartamentoController {

    private DepartamentosService service;
    @Autowired
    public DepartamentoController(DepartamentosService service){
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<DepartamentosResponse>novoDepartamento(
            @RequestBody DepartamentoRequest request) throws ObjectAlreadyExists {
       final DepartamentosResponse response = this.service.novoDepartamento(request);
       return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
