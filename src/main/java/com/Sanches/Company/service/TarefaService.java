package com.Sanches.Company.service;

import com.Sanches.Company.config.Convertions;
import com.Sanches.Company.controller.TarefaController;
import com.Sanches.Company.controller.request.TarefasRequest;
import com.Sanches.Company.controller.response.FinalizarTarefaResponse;
import com.Sanches.Company.controller.response.TarefaResponse;
import com.Sanches.Company.entity.Tarefas;
import com.Sanches.Company.enums.StatusTarefa;
import com.Sanches.Company.exception.ObjectAlreadyExists;
import com.Sanches.Company.exception.PreconditionFailedException;
import com.Sanches.Company.repository.TarefaRepository;
import com.Sanches.Company.utils.Constants;
import com.Sanches.Company.utils.ConverterUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.Objects;
@Lazy
@Service
@Slf4j
public class TarefaService {

    private TarefaRepository repository;
    private Convertions conversoes;
    @Autowired
    public TarefaService(TarefaRepository repository, Convertions conversoes){
        this.repository = repository;
        this.conversoes = conversoes;
    }
    public TarefaResponse CadastroDeNovaTarefa(TarefasRequest request)throws ObjectAlreadyExists{
        log.info(Constants.NOVA_TAREFA);
        Tarefas tarefas = this.repository.findByTitulo(request.getTitulo());

        if (Objects.nonNull(tarefas)){
            log.error(Constants.TAREFA_JA_REGISTRADA);
            throw new ObjectAlreadyExists(Constants.TAREFA_JA_REGISTRADA);
        }
        Tarefas tarefa = new Tarefas();
        conversoes.ConvertTarefaRequesttoEntity(request, tarefa);
        Tarefas tarefaSave = this.repository.save(tarefa);

        TarefaResponse response = conversoes.convertEntityToResponse(tarefaSave);
        return response;
    }
    public FinalizarTarefaResponse finalizaTarefa(final Long idTarefa)throws PreconditionFailedException{
        log.info(Constants.FINALIZA_TAREFA);
        Tarefas tarefas = this.repository.findById(idTarefa).orElse(null);

        if(Objects.isNull(tarefas)){
            log.error(Constants.ID_NAO_ENCONTRADO);
            throw new PreconditionFailedException(Constants.ID_NAO_ENCONTRADO);
        }
        tarefas.setStatus(StatusTarefa.FINALIZADA);
        tarefas.setDataFinalizacao(ConverterUtil.nowTime());
        Tarefas tarefaSave = this.repository.save(tarefas);

        FinalizarTarefaResponse response = conversoes.convertEntityToTarefaResponse(tarefaSave);
        return response;
    }
    public void alocarFuncionarioNaTarefa(final Long idTarefa, final TarefasRequest request)throws PreconditionFailedException {
        log.info(Constants.ALOCANDO_FUNCIONARIO);
        Tarefas tarefas = this.repository.findById(idTarefa).orElse(null);
        if (Objects.isNull(tarefas)) {
            log.error(Constants.ID_NAO_ENCONTRADO);
            throw new PreconditionFailedException(Constants.ID_NAO_ENCONTRADO);

        } else if (request.getIdDepartamento() != tarefas.getIdDepartamento()) {
            log.error(Constants.FUNCIONARIO_E_DEPARTAMENTO_INCOMPATIVEIS);
            throw new PreconditionFailedException(Constants.FUNCIONARIO_E_DEPARTAMENTO_INCOMPATIVEIS);
        }
        tarefas.setIdFuncionario(request.getIdFuncionario());
        tarefas.setDataAlocaFuncionario(ConverterUtil.nowTime());
        this.repository.save(tarefas);
    }
}