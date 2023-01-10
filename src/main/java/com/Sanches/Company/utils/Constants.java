package com.Sanches.Company.utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Constants {
    public final String ERROR_DEP  = "Departamento já cadastrado";
    public final String ID_NAO_ENCONTRADO = "ID não encontrado na base de dados";
    public final String CPF_JA_CADASTRADO = "CPF já cadastrado na base de dados";
    public final String ATUALIZA_FUNCIONARIO = "Atualizando dados de um funcionarios";
    public final String BUSCA_TODOS_FUNCIONARIOS = "Buscando todos funcionarios cadastrados";
    public final String BUSCA_POR_NOME_OU_CPF = "Busca funcionario por nome ou cpf";
    public final String FUNCIONARIO_E_DEPARTAMENTO_INCOMPATIVEIS = "esse funcionario não pode executar esse trabalho";
    public final String FUNCIONARIO_ALOCADO_PARA_TAREFA = "Funcionario alocado a tarefa com sucesso";
    public final String ALOCANDO_FUNCIONARIO = "Atribuindo um funcionario a nova tarefa";
    public final String CAMPOS_OBRIGATORIOS = "Todos os campos são obrigatórios";
    public final String NOVO_FUNCIONARIO = "Inserindo um novo funcionario";
    public final String FINALIZA_TAREFA = "Finalizando uma atividade";
    public final String NOVA_TAREFA = "Inserindo nova tarefa";
    public final String TAREFA_JA_REGISTRADA = "Titulo já registrado, favor alterar o titulo da tarefa";
    public final String FUNCIONARIO_DELETADO = "Funcionario deletado com sucesso";
    public final String DELETANDO_FUNCIONARIO= "deletando um usuario";
    public static final String SQ_TB_DEPARTAMENTO = "sq_tb_departamento";
    public static final String SQ_TB_FUNCIONARIO = "sq_tb_funcionario";
    public static final String SQ_TB_TAREFAS = "sq_tb_tarefas";
}
