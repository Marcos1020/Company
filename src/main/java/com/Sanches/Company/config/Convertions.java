package com.Sanches.Company.config;

import com.Sanches.Company.controller.request.FuncionarioRequest;
import com.Sanches.Company.controller.request.TarefasRequest;
import com.Sanches.Company.controller.response.FinalizarTarefaResponse;
import com.Sanches.Company.controller.response.FuncionarioResponse;
import com.Sanches.Company.controller.response.TarefaResponse;
import com.Sanches.Company.controller.response.UpdateResponse;
import com.Sanches.Company.entity.Funcionario;
import com.Sanches.Company.entity.Tarefas;
import com.Sanches.Company.enums.StatusTarefa;
import com.Sanches.Company.exception.PreconditionFailedException;
import com.Sanches.Company.utils.Constants;
import com.Sanches.Company.utils.ConverterUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class Convertions {
    public static void converterFuncionarioRequestToFuncionarioEntity(Funcionario funcionarioSave, FuncionarioRequest request) {
        funcionarioSave.setIdDepartamento(request.getIdDepartamento());
        funcionarioSave.setCpf(request.getCpf());
        funcionarioSave.setNome(request.getNome());
        funcionarioSave.setTarefas(request.getTarefas());
        funcionarioSave.setDataRegistro(ConverterUtil.nowTime());
    }
    public static FuncionarioResponse convertFuncionarioEntityToFuncionarioResponse(Funcionario funcionarioSave) {
        FuncionarioResponse response = new FuncionarioResponse();
        response.setIdFuncionario(funcionarioSave.getIdFuncionario());
        response.setIdDepartamento(funcionarioSave.getIdDepartamento());
        response.setNome(funcionarioSave.getNome());
        response.setCpf(funcionarioSave.getCpf());
        response.setDataRegistro(ConverterUtil.nowTime());
        return response;
    }
    public static UpdateResponse ConvertEntityToUpdateResponse(Funcionario funcionarioSave) {
        UpdateResponse response= new UpdateResponse();
        response.setIdFuncionario(funcionarioSave.getIdFuncionario());
        response.setIdDepartamento(funcionarioSave.getIdDepartamento());
        response.setNome(funcionarioSave.getNome());
        response.setCpf(funcionarioSave.getCpf());
        response.setDataAlteracao(ConverterUtil.nowTime());
        return response;
    }
    public  static void convertUpdateFuncionario(FuncionarioRequest request, Funcionario funcionario) {
        try{
            funcionario.setNome(request.getNome());
            funcionario.setCpf(request.getCpf());
            funcionario.setIdDepartamento(request.getIdDepartamento());
            funcionario.setDataAlteracao(ConverterUtil.nowTime());
        }catch (PreconditionFailedException exception){
            log.error(Constants.CAMPOS_OBRIGATORIOS);
            throw new PreconditionFailedException(Constants.CAMPOS_OBRIGATORIOS);
        }
    }
    public  static void ConvertTarefaRequesttoEntity(TarefasRequest request, Tarefas tarefa) {
        tarefa.setDescricao(request.getDescricao());
        tarefa.setDuracao(request.getDuracao());
        tarefa.setPrazo(request.getPrazo());
        tarefa.setTitulo(request.getTitulo());
        tarefa.setIdDepartamento(request.getIdDepartamento());
        tarefa.setIdFuncionario(request.getIdFuncionario());
        tarefa.setDataRegistro(ConverterUtil.nowTime());
        tarefa.setStatus(StatusTarefa.ATIVA);
    }
    public static TarefaResponse convertEntityToResponse(Tarefas tarefaSave) {
        TarefaResponse response = new TarefaResponse();
        response.setIdTarefa(tarefaSave.getIdTarefa());
        response.setIdDepartamento(tarefaSave.getIdDepartamento());
        response.setIdFuncionario(tarefaSave.getIdFuncionario());
        response.setDuracao(tarefaSave.getDuracao());
        response.setTitulo(tarefaSave.getTitulo());
        response.setStatus(tarefaSave.getStatus());
        response.setPrazo(tarefaSave.getPrazo());
        response.setDescricao(tarefaSave.getDescricao());
        response.setDataRegistro(ConverterUtil.nowTime());
        return response;
    }
    public static FinalizarTarefaResponse convertEntityToTarefaResponse(Tarefas tarefaSave) {
        FinalizarTarefaResponse response = new FinalizarTarefaResponse();
        response.setIdTarefa(tarefaSave.getIdTarefa());
        response.setDatafinalizacao(tarefaSave.getDataFinalizacao());
        response.setStatus(tarefaSave.getStatus());
        return response;
    }
}
