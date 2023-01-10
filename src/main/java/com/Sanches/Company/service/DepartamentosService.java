package com.Sanches.Company.service;

import com.Sanches.Company.controller.request.DepartamentoRequest;
import com.Sanches.Company.controller.response.DepartamentosResponse;
import com.Sanches.Company.entity.Departamentos;
import com.Sanches.Company.exception.ObjectAlreadyExists;
import com.Sanches.Company.repository.DepartamentosRepository;
import com.Sanches.Company.utils.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.Objects;
@Lazy
@Service
@Slf4j
public class DepartamentosService {

    private DepartamentosRepository repository;
    @Autowired
    public DepartamentosService(DepartamentosRepository repository){
        this.repository = repository;
    }
    public DepartamentosResponse novoDepartamento(DepartamentoRequest request)throws ObjectAlreadyExists {
        log.info("Inserindo um novo departamento");
        Departamentos departamento = this.repository.findByNomeDepartamento(request.getNomeDepartamento());

        if(Objects.nonNull(departamento)){
            log.error(Constants.ERROR_DEP);
            throw new ObjectAlreadyExists(Constants.ERROR_DEP);
        }
        Departamentos novoDepartamento = new Departamentos();
        novoDepartamento.setNomeDepartamento(request.getNomeDepartamento());
        this.repository.save(novoDepartamento);

        DepartamentosResponse response = new DepartamentosResponse();
        response.setIdDepartamento(novoDepartamento.getIdDepartamento());
        response.setNomeDepartamento(novoDepartamento.getNomeDepartamento());
        return response;
    }
}
