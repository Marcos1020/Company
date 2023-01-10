package com.Sanches.Company.service;

import com.Sanches.Company.config.Convertions;
import com.Sanches.Company.controller.request.FuncionarioRequest;
import com.Sanches.Company.controller.response.FuncionarioResponse;
import com.Sanches.Company.controller.response.UpdateResponse;
import com.Sanches.Company.entity.Funcionario;
import com.Sanches.Company.exception.ObjectAlreadyExists;
import com.Sanches.Company.exception.PreconditionFailedException;
import com.Sanches.Company.repository.FuncionarioRepository;
import com.Sanches.Company.utils.Constants;
import com.Sanches.Company.utils.ConverterUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
@Lazy
@Service
@Slf4j
public class FuncionarioService {

    private FuncionarioRepository repository;
    private Convertions conversoes;
    @Autowired
    public FuncionarioService(FuncionarioRepository repository, Convertions conversoes){
        this.repository = repository;
        this.conversoes = conversoes;
    }

    public FuncionarioResponse cadastroDeNovoFuncionario(FuncionarioRequest request)throws ObjectAlreadyExists{
        log.info(Constants.NOVO_FUNCIONARIO);
        Funcionario funcionario = this.repository.findByCpf(request.getCpf());

        if (Objects.nonNull(funcionario)){
            log.error(Constants.CPF_JA_CADASTRADO);
            throw new ObjectAlreadyExists(Constants.CPF_JA_CADASTRADO);
        }
        Funcionario funcionarioSave = new Funcionario();
        conversoes.converterFuncionarioRequestToFuncionarioEntity(funcionarioSave, request);
        this.repository.save(funcionarioSave);

        FuncionarioResponse response = conversoes.convertFuncionarioEntityToFuncionarioResponse(funcionarioSave);
        return response;
    }
    public UpdateResponse atualizarFuncionario(final Long idFuncionario, FuncionarioRequest request)throws PreconditionFailedException {
        log.info(Constants.ATUALIZA_FUNCIONARIO);
        Funcionario funcionario = this.repository.findById(idFuncionario).orElse(null);
        if(Objects.isNull(funcionario)){
            log.error(Constants.ID_NAO_ENCONTRADO);
            throw new PreconditionFailedException(Constants.ID_NAO_ENCONTRADO);
        }
        conversoes.convertUpdateFuncionario(request, funcionario);
        Funcionario funcionarioSave = this.repository.save(funcionario);

        UpdateResponse response = conversoes.ConvertEntityToUpdateResponse(funcionarioSave);
        return response;
    }
    public void deletaFuncionario(final Long idFuncionario)throws PreconditionFailedException{
        log.info(Constants.DELETANDO_FUNCIONARIO);
        Funcionario funcionario = this.repository.findById(idFuncionario).orElse(null);
        if(Objects.isNull(funcionario)){
            log.error(Constants.ID_NAO_ENCONTRADO);
            throw new PreconditionFailedException(Constants.ID_NAO_ENCONTRADO);
        }
        this.repository.delete(funcionario);
    }
    public List<Funcionario>findAll()throws PreconditionFailedException{
        log.info(Constants.BUSCA_TODOS_FUNCIONARIOS);
        return repository.findAll();
    }
    public List<Funcionario>findByNome(final String nome, final String cpf)throws PreconditionFailedException{
        log.info(Constants.BUSCA_POR_NOME_OU_CPF);
        return repository.findByNomeOrCpf(nome, cpf);
    }
}
